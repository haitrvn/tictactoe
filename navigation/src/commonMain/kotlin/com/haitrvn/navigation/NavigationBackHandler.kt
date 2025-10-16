package com.haitrvn.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.navigationevent.NavigationEventInfo

@Composable
fun NavigationBackHandler(
    state: NavigationEventState<out NavigationEventInfo>,
    isBackEnabled: Boolean = true,
    onBackCancelled: () -> Unit = {},
    onBackCompleted: () -> Unit,
) {
    NavigationEventHandler(
        state = state,
        onForwardCancelled = {},
        onForwardCompleted = {},
        isForwardEnabled = false, // disable forward
        onBackCancelled = onBackCancelled,
        onBackCompleted = onBackCompleted,
        isBackEnabled = isBackEnabled,
    )
}

@Composable
fun NavigationEventHandler(
    state: NavigationEventState<out NavigationEventInfo>,
    // ---- Forward Events ----
    isForwardEnabled: Boolean = true,
    onForwardCancelled: () -> Unit = {},
    onForwardCompleted: () -> Unit = {},
    // ---- Back Events ----
    isBackEnabled: Boolean = true,
    onBackCancelled: () -> Unit = {},
    onBackCompleted: () -> Unit = {},
) {
    val dispatcher =
        checkNotNull(LocalNavigationEventDispatcherOwner.current) {
            "No NavigationEventDispatcher was provided via LocalNavigationEventDispatcherOwner"
        }
            .navigationEventDispatcher

    val sourceHandler =
        remember(state) {
            ComposeNavigationEventHandler(
                initialInfo = state.currentInfo,
                onTransitionStateChanged = { transitionState ->
                    state.transitionState = transitionState
                },
            )
        }

    SideEffect {
        sourceHandler.isForwardEnabled = isForwardEnabled
        sourceHandler.currentOnForwardCancelled = onForwardCancelled
        sourceHandler.currentOnForwardCompleted = onForwardCompleted

        sourceHandler.isBackEnabled = isBackEnabled
        sourceHandler.currentOnBackCancelled = onBackCancelled
        sourceHandler.currentOnBackCompleted = onBackCompleted

        sourceHandler.setInfo(state.currentInfo, state.backInfo, state.forwardInfo)
    }

    DisposableEffect(state) {
        require(state.sourceHandler == null) {
            "NavigationEventState '$state' is already registered with a NavigationEventHandler '$sourceHandler'."
        }

        state.sourceHandler = sourceHandler
        dispatcher.addHandler(sourceHandler)

        onDispose {
            sourceHandler.remove()
            state.sourceHandler = null
        }
    }
}
