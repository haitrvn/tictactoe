package com.haitrvn.navigation

import androidx.compose.runtime.Immutable
import androidx.navigation3.runtime.NavEntry

@Immutable
class SceneState<T : Any>
internal constructor(
    val entries: List<NavEntry<T>>,
    val overlayScenes: List<OverlayScene<T>>,
    val currentScene: Scene<T>,
    val previousScenes: List<Scene<T>>,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as SceneState<*>

        return entries == other.entries &&
                overlayScenes == other.overlayScenes &&
                currentScene == other.currentScene &&
                previousScenes == other.previousScenes
    }

    override fun hashCode(): Int {
        return entries.hashCode() * 31 +
                overlayScenes.hashCode() * 31 +
                currentScene.hashCode() * 31 +
                previousScenes.hashCode() * 31
    }

    override fun toString(): String {
        return "SceneState(entries=$entries, overlayScenes=$overlayScenes, currentScene=$currentScene, previousScenes=$previousScenes)"
    }
}
