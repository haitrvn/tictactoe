package com.haitrvn.navigation

import androidx.navigationevent.NavigationEventInfo

class SceneInfo<T : Any>(val scene: Scene<T>) : NavigationEventInfo() {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as SceneInfo<*>

        return scene == other.scene
    }

    override fun hashCode(): Int {
        return scene.hashCode()
    }

    override fun toString(): String {
        return "SceneInfo(scene=$scene)"
    }
}