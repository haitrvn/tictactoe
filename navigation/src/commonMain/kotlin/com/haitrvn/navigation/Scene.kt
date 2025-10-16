package com.haitrvn.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavEntry

interface Scene<T : Any> {
    /**
     * The key identifying the [Scene]. This key will be combined with the class of the [Scene] to
     * determine the key that drives the transition in the top-level animation for the NavDisplay.
     *
     * Because the class of the [Scene] is also used, this [key] only needs to be unique for a given
     * type of [Scene] to indicate a different instance of the [Scene].
     */
    val key: Any

    /**
     * The list of [androidx.navigation3.runtime.NavEntry]s that can be displayed in this scene.
     *
     * When animating between scenes, the underlying content for each
     * [androidx.navigation3.runtime.NavEntry] will only be rendered by the scene that is most
     * recently the target scene, and is displaying that [androidx.navigation3.runtime.NavEntry] as
     * determined by this [entries] list.
     *
     * For example, consider a transition from `Scene1` to `Scene2` below:
     * ```
     * Scene1:      Scene2:
     * +---+---+     +---+---+
     * |   |   |     |   |   |
     * | A | B | --> | B | C |
     * |   |   |     |   |   |
     * +---+---+     +---+---+
     * ```
     *
     * `Scene1.entries` should be `[A, B]`, and `Scene2.entries` should be `[B, C]`
     *
     * When both are being rendered at the same time during the transition, the content for `A` will
     * be rendered in `Scene1`, while the content for `B` and `C` will be rendered in `Scene2`.
     */
    val entries: List<NavEntry<T>>

    /**
     * The resulting [NavEntry]s that should be computed after pressing back updates the backstack.
     *
     * This is required for calculating the proper predictive back state, which may result in a
     * different scene being shown.
     *
     * When predictive back is occurring, this list of entries will be passed through the
     * [SceneStrategy] again, to determine what the resulting scene would be if the back happens.
     */
    val previousEntries: List<NavEntry<T>>

    /**
     * The content rendering the [Scene] itself.
     *
     * This should call the content for the [entries], and can add any arbitrary UI around them
     * specific to the [Scene].
     */
    val content: @Composable () -> Unit

    /**
     * Provide [Scene]-specific information to [androidx.navigation3.ui.NavDisplay].
     *
     * By default includes the metadata of the last [NavEntry] in [entries].
     *
     * @sample androidx.navigation3.ui.samples.SceneDefaultTransitionsSample
     * @sample androidx.navigation3.ui.samples.SceneOverrideEntryTransitionsSample
     */
    val metadata: Map<String, Any>
        get() = entries.lastOrNull()?.metadata ?: emptyMap()
}