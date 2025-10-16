package com.haitrvn.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ContentTransform
import androidx.navigationevent.NavigationEvent

internal const val TRANSITION_SPEC = "transitionSpec"
internal const val POP_TRANSITION_SPEC = "popTransitionSpec"
internal const val PREDICTIVE_POP_TRANSITION_SPEC = "predictivePopTransitionSpec"

@Suppress("UNCHECKED_CAST")
fun <T : Any> Scene<T>.predictivePopSpec():
        (AnimatedContentTransitionScope<Scene<T>>.(
            @NavigationEvent.SwipeEdge Int
        ) -> ContentTransform)? {
    return metadata[PREDICTIVE_POP_TRANSITION_SPEC]
            as?
            AnimatedContentTransitionScope<Scene<T>>.(
                @NavigationEvent.SwipeEdge Int
            ) -> ContentTransform
}


@Suppress("UNCHECKED_CAST")
fun <T : Any> Scene<T>.contentTransform(
    key: String
): (AnimatedContentTransitionScope<Scene<T>>.() -> ContentTransform)? {
    return metadata[key] as? AnimatedContentTransitionScope<Scene<T>>.() -> ContentTransform
}