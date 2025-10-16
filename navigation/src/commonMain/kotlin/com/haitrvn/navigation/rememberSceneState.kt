package com.haitrvn.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.util.fastMap
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.rememberDecoratedNavEntries

internal fun <T : Any> SceneStrategy<T>.calculateSceneWithSinglePaneFallback(
    scope: SceneStrategyScope<T>,
    entries: List<NavEntry<T>>,
): Scene<T> {
    return scope.calculateScene(entries)
        ?: with(SinglePaneSceneStrategy<T>()) { scope.calculateScene(entries) }
}

/** Returns a [SceneSetupNavEntryDecorator] that is remembered across recompositions. */
@Composable
internal fun <T : Any> rememberSceneSetupNavEntryDecorator(): SceneSetupNavEntryDecorator<T> =
    remember {
        SceneSetupNavEntryDecorator()
    }

@Composable
fun <T : Any> rememberSceneState(
    entries: List<NavEntry<T>>,
    sceneStrategy: SceneStrategy<T>,
    onBack: () -> Unit,
): SceneState<T> =
    with(SceneStrategyScope<T>(onBack)) {
        // re-wrap the entries with the SceneSetupNavEntryDecorator to ensure all the ensures are
        // inside of a moveable content.
        // Calculate the single scene based on the sceneStrategy and start the list there.
        val allScenes =
            mutableListOf(
                sceneStrategy.calculateSceneWithSinglePaneFallback(
                    this,
                    rememberDecoratedNavEntries(
                        entries,
                        listOf(rememberSceneSetupNavEntryDecorator()),
                    ),
                )
            )
        // find all of the OverlayScenes
        do {
            // Starts from previously calculated scene and check if it is an OverlayScene
            val overlayScene = allScenes.last() as? OverlayScene
            val overlaidEntries = overlayScene?.overlaidEntries
            if (overlaidEntries != null) {
                // TODO Consider allowing a NavDisplay of only OverlayScene instances
                require(overlaidEntries.isNotEmpty()) {
                    "Overlaid entries from $overlayScene must not be empty"
                }
                // Keep added scenes to the end of our list until we find a non-overlay scene
                allScenes +=
                    sceneStrategy.calculateSceneWithSinglePaneFallback(this, overlaidEntries)
            }
        } while (overlaidEntries != null)

        // Find all the overlay scenes
        val overlayScenes = allScenes.dropLast(1).fastMap { it as OverlayScene<T> }
        // The currentScene is just just whatever is last on the list.
        val currentScene = allScenes.last()
        // Get the previous scenes, starting from the current scene.
        val previousScenes = mutableListOf(allScenes.first())

        do {
            // get the first scene off the list
            val previousScene = previousScenes.firstOrNull()
            val previousEntries = previousScene?.previousEntries
            if (!previousEntries.isNullOrEmpty()) {
                // If there are previous entries, add the scene from those entries to the front of
                // the
                // list
                previousScenes.add(
                    0,
                    sceneStrategy.calculateSceneWithSinglePaneFallback(this, previousEntries),
                )
            }
        } while (!previousEntries.isNullOrEmpty())

        // remove the currentScene from the list
        previousScenes.remove(currentScene)

        return SceneState(
            entries = entries,
            overlayScenes = overlayScenes,
            currentScene = currentScene,
            previousScenes = previousScenes,
        )
    }