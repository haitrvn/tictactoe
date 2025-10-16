package com.haitrvn.navigation

import androidx.navigation3.runtime.NavEntry

interface OverlayScene<T : Any> : Scene<T> {

    /**
     * The [androidx.navigation3.runtime.NavEntry]s that should be handled by another [Scene] that
     * sits below this Scene.
     *
     * This *must* always be a non-empty list to correctly display entries below the overlay.
     */
    val overlaidEntries: List<NavEntry<T>>
}
