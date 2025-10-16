package com.haitrvn.navigation

import androidx.navigation3.runtime.NavEntry

fun interface SceneStrategy<T : Any> {
    /**
     * Given a [SceneStrategyScope], calculate whether this [SceneStrategy] should take on the task
     * of rendering one or more of the entries in the scope.
     *
     * By returning a non-null [Scene], your [Scene] takes on the responsibility of rendering the
     * set of entries you declare in [Scene.entries]. If you return `null`, the next available
     * [SceneStrategy] will be called.
     *
     * @param entries The entries on the back stack that should be considered valid to render via a
     *   returned Scene.
     */
    fun SceneStrategyScope<T>.calculateScene(entries: List<NavEntry<T>>): Scene<T>?

    /**
     * Chains this [SceneStrategy] with another [sceneStrategy] to return a combined
     * [SceneStrategy].
     */
    infix fun then(sceneStrategy: SceneStrategy<T>): SceneStrategy<T> =
        object : SceneStrategy<T> {
            override fun SceneStrategyScope<T>.calculateScene(
                entries: List<NavEntry<T>>
            ): Scene<T>? =
                calculateScene(entries) ?: with(sceneStrategy) { calculateScene(entries) }
        }
}