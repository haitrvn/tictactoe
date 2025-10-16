package com.haitrvn.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.util.fastForEachReversed
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavEntryDecorator
import androidx.navigation3.runtime.rememberDecoratedNavEntries
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigationevent.NavigationEventDispatcher
import androidx.navigationevent.NavigationEventDispatcherOwner

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

    val finalEntries =
        rememberDecoratedNavEntries(
            entries = entries,
            entryDecorators = listOf(),
        )

    val sceneState = rememberSceneState(finalEntries, sceneStrategy, onBack)
    val scene = sceneState.currentScene

    val currentInfo = SceneInfo(scene)
    val previousSceneInfos = sceneState.previousScenes.map { SceneInfo(it) }
    val gestureState =
        rememberNavigationEventState(currentInfo = currentInfo, backInfo = previousSceneInfos)

    NavigationBackHandler(
        state = gestureState,
        isBackEnabled = scene.previousEntries.isNotEmpty(),
        onBackCompleted = {
            repeat(finalEntries.size - scene.previousEntries.size) { onBack() }
        },
    )

    CustomNavDisplay(
        sceneState,
        modifier,
        contentAlignment,
    )
}

@Composable
fun <T : Any> CustomNavDisplay(
    sceneState: SceneState<T>,
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.TopStart,
) {
    val scene = sceneState.currentScene
    val overlayScenes = sceneState.overlayScenes

    val sceneToExcludedEntryMap = remember(sceneState.entries, overlayScenes) {
        buildMap {
            val coveredEntryKeys = mutableSetOf<Any>()
            overlayScenes.forEach { overlay ->
                put(overlay::class to overlay.key, coveredEntryKeys.toMutableSet())
                coveredEntryKeys.addAll(overlay.entries.map { it.contentKey })
            }
            put(scene::class to scene.key, coveredEntryKeys.toMutableSet())
        }
    }
    val navigationEventDispatcherOwner = remember {
        object : NavigationEventDispatcherOwner {
            override val navigationEventDispatcher: NavigationEventDispatcher
                get() = NavigationEventDispatcher()

        }
    }
    Box(modifier = modifier, contentAlignment = contentAlignment) {
        CompositionLocalProvider(
            LocalNavTransitionSettledState provides true,
            LocalEntriesToExcludeFromCurrentScene provides
                    sceneToExcludedEntryMap.getValue(scene::class to scene.key),
            LocalNavigationEventDispatcherOwner.LocalNavigationEventDispatcherOwner provides navigationEventDispatcherOwner
        ) {
            scene.content()
        }

        overlayScenes.fastForEachReversed { overlayScene ->
            CompositionLocalProvider(
                LocalEntriesToExcludeFromCurrentScene provides
                        sceneToExcludedEntryMap.getValue(overlayScene::class to overlayScene.key)
            ) {
                overlayScene.content()
            }
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
