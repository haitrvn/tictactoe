package com.haitrvn.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.util.fastAny
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Lifecycle.Event.ON_DESTROY
import androidx.lifecycle.Lifecycle.Event.ON_RESUME
import androidx.lifecycle.Lifecycle.State
import androidx.lifecycle.Lifecycle.State.RESUMED
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavEntryDecorator

@Composable
internal fun <T : Any> rememberTransitionAwareLifecycleNavEntryDecorator(
    entries: List<NavEntry<T>>
): NavEntryDecorator<T> {
    val updatedEntries by rememberUpdatedState(entries)
    return NavEntryDecorator { entry ->
        val isSettled = LocalNavTransitionSettledState.current
        val isInBackStack = updatedEntries.fastAnyOrAny { it.contentKey == entry.contentKey }
        val maxLifecycle =
            when {
                isInBackStack && isSettled -> Lifecycle.State.RESUMED
                isInBackStack && !isSettled -> Lifecycle.State.STARTED
                else /* !isInBackStack */ -> Lifecycle.State.CREATED
            }
        val owner = rememberLifecycleOwner(maxLifecycle = maxLifecycle)
        CompositionLocalProvider(LocalLifecycleOwner provides owner) { entry.Content() }
    }
}

internal fun <T> List<T>.fastAnyOrAny(predicate: (T) -> Boolean): Boolean =
    if (this is RandomAccess) {
        this.fastAny(predicate)
    } else {
        @Suppress("ListIterator") this.any(predicate)
    }

@Composable
public fun rememberLifecycleOwner(
    maxLifecycle: State = RESUMED,
    parent: LifecycleOwner? = LocalLifecycleOwner.current,
): LifecycleOwner {
    val localLifecycleOwner = remember(parent) { ComposeLifecycleOwner() }

    // Pass LifecycleEvents from the parent down to the child.
    DisposableEffect(localLifecycleOwner, parent) {
        val observer = LifecycleEventObserver { _, event ->
            // Connect parent's events to the child lifecycle.
            localLifecycleOwner.handleLifecycleEvent(event)
        }

        // Add observer only if there is a parent.
        parent?.lifecycle?.addObserver(observer)

        if (parent == null) {
            // No parent: manually mark this lifecycle as RESUMED.
            localLifecycleOwner.handleLifecycleEvent(event = ON_RESUME)
        }

        onDispose {
            // Remove observer if it was added (has a parent).
            parent?.lifecycle?.removeObserver(observer)

            // Manually dispatch ON_DESTROY. This ensures that any code holding a reference to this
            // from outside a composition is notified that it has been permanently destroyed.
            localLifecycleOwner.handleLifecycleEvent(event = ON_DESTROY)
        }
    }

    // Ensure that the child lifecycle is capped at the maxLifecycle.
    LaunchedEffect(localLifecycleOwner, maxLifecycle) {
        localLifecycleOwner.maxLifecycleState = maxLifecycle
    }

    return localLifecycleOwner
}

private class ComposeLifecycleOwner : LifecycleOwner {

    private val lifecycleRegistry = LifecycleRegistry(provider = this)

    override val lifecycle
        get() = lifecycleRegistry

    // Tracks the last known state from the parent lifecycle.
    private var parentLifecycleState: State = State.INITIALIZED

    // The maximum state this lifecycle can enter.
    var maxLifecycleState: State = State.INITIALIZED
        set(value) {
            field = value
            updateLifecycleState()
        }

    fun handleLifecycleEvent(event: Lifecycle.Event) {
        parentLifecycleState = event.targetState
        updateLifecycleState()
    }

    private fun updateLifecycleState() {
        // The child's state is capped at the minimum of the parent's state and the max state.
        // For example, if parent is RESUMED and max is STARTED, the child state becomes STARTED.
        lifecycleRegistry.currentState =
            if (parentLifecycleState.ordinal < maxLifecycleState.ordinal) {
                parentLifecycleState
            } else {
                maxLifecycleState
            }
    }
}