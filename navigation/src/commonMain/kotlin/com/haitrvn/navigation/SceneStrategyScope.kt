package com.haitrvn.navigation

class SceneStrategyScope<T : Any>(
    /**
     * A callback that should be connected to any internal handling of system back done by the
     * returned [Scene].
     *
     * For example, if your [Scene] uses a separate window that handles system back itself or if the
     * UI present in your [Scene] allows users to go back via a custom gesture or affordance, this
     * callback allows you to bubble up that event to the [SceneState] /
     * [androidx.navigation3.ui.NavDisplay] that interfaces with the developer owned back stack.
     *
     * @sample androidx.navigation3.scene.samples.SceneStrategyOnBackSample
     */
    val onBack: () -> Unit = {}
)