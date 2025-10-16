package com.haitrvn.navigation

import androidx.collection.mutableObjectFloatMapOf
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.SeekableTransitionState
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.rememberTransition
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.util.fastForEach
import androidx.compose.ui.util.fastForEachReversed
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavEntryDecorator
import androidx.navigation3.runtime.rememberDecoratedNavEntries
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigationevent.NavigationEvent
import androidx.navigationevent.NavigationEventTransitionState.Idle
import androidx.navigationevent.NavigationEventTransitionState.InProgress
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch
import kotlin.reflect.KClass

@Composable
fun <T : Any> CustomNavDisplay(
    backStack: List<T>,
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.TopStart,
    onBack: () -> Unit = {
        if (backStack is MutableList<T>) {
            backStack.removeLastOrNull()
        }
    },
    entryDecorators: List<NavEntryDecorator<T>> =
        listOf(rememberSaveableStateHolderNavEntryDecorator()),
    sceneStrategy: SceneStrategy<T> = SinglePaneSceneStrategy(),
    entryProvider: (key: T) -> NavEntry<T>,
) {
    require(backStack.isNotEmpty()) { "NavDisplay backstack cannot be empty" }

    val entries =
        rememberDecoratedNavEntries(
            backStack = backStack,
            entryDecorators = entryDecorators,
            entryProvider = entryProvider,
        )

    CustomNavDisplay(
        entries = entries,
        sceneStrategy = sceneStrategy,
        modifier = modifier,
        contentAlignment = contentAlignment,
        onBack = onBack,
    )
}

@Composable
fun <T : Any> CustomNavDisplay(
    entries: List<NavEntry<T>>,
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.TopStart,
    sceneStrategy: SceneStrategy<T> = SinglePaneSceneStrategy(),
    onBack: () -> Unit,
) {
    require(entries.isNotEmpty()) { "NavDisplay entries cannot be empty" }

    val transitionAwareLifecycleNavEntryDecorator =
        rememberTransitionAwareLifecycleNavEntryDecorator(entries)

    val finalEntries =
        rememberDecoratedNavEntries(
            entries = entries,
            entryDecorators = listOf(transitionAwareLifecycleNavEntryDecorator),
        )

    val sceneState =
        rememberSceneState(finalEntries, sceneStrategy, onBack)
    val scene = sceneState.currentScene

    // Predictive Back Handling
    val currentInfo = SceneInfo(scene)
    val previousSceneInfos = sceneState.previousScenes.map { SceneInfo(it) }
    val gestureState =
        rememberNavigationEventState(
            currentInfo = currentInfo,
            backInfo = previousSceneInfos
        )

    NavigationBackHandler(
        state = gestureState,
        isBackEnabled = scene.previousEntries.isNotEmpty(),
        onBackCompleted = {
            // If `enabled` becomes stale (e.g., it was set to false but a gesture was
            // dispatched in the same frame), this may result in no entries being popped
            // due to finalEntries.size being smaller than scene.previousEntries.size
            // but that's preferable to crashing with an IndexOutOfBoundsException
            repeat(finalEntries.size - scene.previousEntries.size) { onBack() }
        },
    )

    CustomNavDisplay(
        sceneState = sceneState,
        navigationEventState = gestureState,
        modifier = modifier,
        contentAlignment = contentAlignment,
    )
}

@Composable
fun <T : Any> CustomNavDisplay(
    sceneState: SceneState<T>,
    navigationEventState: NavigationEventState<SceneInfo<T>>,
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.TopStart,
    sizeTransform: SizeTransform? = null,
    transitionSpec: AnimatedContentTransitionScope<Scene<T>>.() -> ContentTransform = defaultTransitionSpec(),
    popTransitionSpec: AnimatedContentTransitionScope<Scene<T>>.() -> ContentTransform = defaultPopTransitionSpec(),
    predictivePopTransitionSpec: AnimatedContentTransitionScope<Scene<T>>.(@NavigationEvent.SwipeEdge Int) -> ContentTransform = defaultPredictivePopTransitionSpec(),
) {
    // Calculate current Scene and set up transitions
    val scene = sceneState.currentScene
    val transitionState = remember {
        // The state returned here cannot be nullable cause it produces the input of the
        // transitionSpec passed into the AnimatedContent and that must match the non-nullable
        // scope exposed by the transitions on the NavHost and composable APIs.
        SeekableTransitionState(scene)
    }

    val transition = rememberTransition(transitionState, label = "scene")

    // Transition Handling
    /** Keep track of the previous entries for the transition's current scene. */
    val transitionCurrentStateEntries =
        remember(transition.currentState) { sceneState.entries.toList() }

    // Set up Gesture Back tracking
    val previousScene = sceneState.previousScenes.lastOrNull()
    val gestureTransition = navigationEventState.transitionState

    val inPredictiveBack = gestureTransition is InProgress && previousScene != null
    val progress =
        when (gestureTransition) {
            is Idle -> 0f
            is InProgress -> gestureTransition.latestEvent.progress
        }
    val swipeEdge =
        when (gestureTransition) {
            is Idle -> NavigationEvent.EDGE_NONE
            is InProgress -> gestureTransition.latestEvent.swipeEdge
        }

    val isPop =
        isPop(
            // Consider this a pop if the current entries match the previous entries we have
            // recorded
            // from the current state of the transition
            transitionCurrentStateEntries.map { it.contentKey },
            sceneState.entries.map { it.contentKey },
        )

    // Track currently rendered Scenes and their ZIndices
    val sceneMap = remember { mutableStateMapOf<Pair<KClass<*>, Any>, Scene<T>>() }
    val zIndices = remember { mutableObjectFloatMapOf<Pair<KClass<*>, Any>>() }
    val initialKey = transition.currentState::class to transition.currentState.key
    val targetKey = transition.targetState::class to transition.targetState.key
    val initialZIndex = zIndices.getOrPut(initialKey) { 0f }
    val targetZIndex =
        when {
            initialKey == targetKey -> initialZIndex
            isPop || inPredictiveBack -> initialZIndex - 1f
            else -> initialZIndex + 1f
        }
    sceneMap[targetKey] = transition.targetState
    zIndices[targetKey] = targetZIndex

    val overlayScenes = sceneState.overlayScenes

    // Determine which entries should be rendered within each currently rendered scene,
    // using the z-index of each screen to always show the entry on the topmost screen
    // The map is Pair<KCLass<Scene<T>, Scene.key> to a Set of NavEntry.key values
    val sceneToExcludedEntryMap =
        remember(sceneMap.entries.toList(), overlayScenes.toList(), zIndices.toString()) {
            buildMap {
                val scenes = mutableListOf<Scene<T>>()
                // First sort the non-overlay scenes by z-order in descending order.
                sceneMap.entries
                    .sortedByDescending { zIndices[it.key] }
                    .map { it.value }
                    .forEach { if (!scenes.contains(it)) scenes.add(it) }

                // At this point we have a list in this order
                // [zIndex larger --> zIndex smaller]

                // Then combine them with overlay scenes to get the complete order of scenes in
                // z-order
                // overlayScenes is already in order of [top most overlay ---> lowest overlay],
                // so we put overlayScenes in front, and then add the scenes after.
                val scenesInZOrder = overlayScenes + scenes
                // At this point we have a list of all scenes in this order
                // [top most overlay ---> lowest overlay, other scenes zIndex larger --> zIndex
                // smaller]

                // Then we track which entries are already covered
                val coveredEntryKeys = mutableSetOf<Any>()

                // In scenesInZOrder's natural order, go through each scene, marking
                // all of the entries not already covered as associated
                // with that scene. This ensures that each unique contentKey will only be
                // rendered by one scene.
                scenesInZOrder.fastForEach { scene ->
                    val newlyCoveredEntryKeys =
                        scene.entries
                            .map { it.contentKey }
                            .filterNot(coveredEntryKeys::contains)
                            .toSet()
                    put(scene::class to scene.key, coveredEntryKeys.toMutableSet())
                    coveredEntryKeys.addAll(newlyCoveredEntryKeys)
                }
            }
        }

    // Determine which NavEntry's transition to use(if any), prioritizing the one with highest
    // zIndex
    val transitionScene =
        if (initialZIndex >= targetZIndex) {
            transition.currentState
        } else {
            transition.targetState
        }

    // check if in gesture back
    if (inPredictiveBack) {
        if (transition.currentState != previousScene) {
            LaunchedEffect(previousScene, progress) {
                // Retarget on key change; seek on progress updates.
                transitionState.seekTo(progress, previousScene)
            }
        }
    } else {
        LaunchedEffect(scene) {
            if (transitionState.currentState != scene) {
                // We are animating to the final state for regular navigate forward and regular pop
                transitionState.animateTo(scene)
            } else {
                // Predictive Back has either been completed or cancelled
                // so now we need to seekTo+snapTo the final state

                // convert from nanoseconds to milliseconds
                val totalDuration = transition.totalDurationNanos / 1000000
                // Which way we have to seek depends on whether the
                // Predictive Back was completed or cancelled
                val predictiveBackCompleted = transition.targetState == scene
                val (finalFraction, remainingDuration) =
                    if (predictiveBackCompleted) {
                        // If it completed, animate to the state we were
                        // already seeking to with the remaining duration
                        1f to ((1f - transitionState.fraction) * totalDuration).toInt()
                    } else {
                        // It it got cancelled, animate back to the
                        // initial state, reversing what we seeked to
                        0f to (transitionState.fraction * totalDuration).toInt()
                    }
                animate(
                    transitionState.fraction,
                    finalFraction,
                    animationSpec = tween(remainingDuration),
                ) { value, _ ->
                    this@LaunchedEffect.launch {
                        if (value != finalFraction) {
                            // Seek the transition towards the finalFraction
                            transitionState.seekTo(value)
                        }
                        if (value == finalFraction) {
                            // Once the animation finishes, we need to snap to the right state.
                            transitionState.snapTo(scene)
                        }
                    }
                }
            }
        }
    }

    val contentTransform: AnimatedContentTransitionScope<Scene<T>>.() -> ContentTransform = {
        when {
            inPredictiveBack -> {
                transitionScene.predictivePopSpec()?.invoke(this, swipeEdge)
                    ?: predictivePopTransitionSpec(swipeEdge)
            }

            isPop -> {
                transitionScene.contentTransform(POP_TRANSITION_SPEC)?.invoke(this)
                    ?: popTransitionSpec(this)
            }

            else -> {
                transitionScene.contentTransform(TRANSITION_SPEC)?.invoke(this)
                    ?: transitionSpec(this)
            }
        }
    }

    transition.AnimatedContent(
        contentKey = { scene -> scene::class to scene.key },
        contentAlignment = contentAlignment,
        modifier = modifier,
        transitionSpec = {
            ContentTransform(
                targetContentEnter = contentTransform(this).targetContentEnter,
                initialContentExit = contentTransform(this).initialContentExit,
                // z-index increases during navigate and decreases during pop.
                targetContentZIndex = targetZIndex,
                sizeTransform = sizeTransform,
            )
        },
    ) { targetScene ->
        val isSettled = transition.currentState == transition.targetState
        CompositionLocalProvider(
            LocalNavTransitionSettledState provides isSettled,
            LocalNavAnimatedContentScope provides this,
            LocalEntriesToExcludeFromCurrentScene provides
                    sceneToExcludedEntryMap.getValue(targetScene::class to targetScene.key),
        ) {
            targetScene.content()
        }
    }

    // Clean-up scene book-keeping once the transition is finished
    LaunchedEffect(transition) {
        snapshotFlow { transition.isRunning }
            .filter { !it }
            .collect {
                val targetKey = transition.targetState::class to transition.targetState.key
                // Creating a copy to avoid ConcurrentModificationException
                @Suppress("ListIterator")
                sceneMap.keys.toList().forEach { key ->
                    if (key != targetKey) {
                        sceneMap.remove(key)
                    }
                }
                // Creating a copy to avoid ConcurrentModificationException
                zIndices.removeIf { key, _ -> key != targetKey }
            }
    }

    // Show all OverlayScene instances above the AnimatedContent
    overlayScenes.fastForEachReversed { overlayScene ->
        CompositionLocalProvider(
            LocalEntriesToExcludeFromCurrentScene provides
                    sceneToExcludedEntryMap.getValue(overlayScene::class to overlayScene.key)
        ) {
            overlayScene.content.invoke()
        }
    }
}


internal val LocalNavTransitionSettledState: ProvidableCompositionLocal<Boolean> =
    compositionLocalOf {
        true
    }

internal val LocalEntriesToExcludeFromCurrentScene: ProvidableCompositionLocal<Set<Any>> =
    compositionLocalOf {
        HashSet()
    }
