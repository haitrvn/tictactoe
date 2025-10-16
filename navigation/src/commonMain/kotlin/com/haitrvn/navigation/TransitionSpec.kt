package com.haitrvn.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleOut
import androidx.navigationevent.NavigationEvent

internal const val DEFAULT_TRANSITION_DURATION_MILLISECOND = 700

fun <T : Any> defaultTransitionSpec():
        AnimatedContentTransitionScope<Scene<T>>.() -> ContentTransform = {
    ContentTransform(
        fadeIn(animationSpec = tween(DEFAULT_TRANSITION_DURATION_MILLISECOND)),
        fadeOut(animationSpec = tween(DEFAULT_TRANSITION_DURATION_MILLISECOND)),
    )
}

fun <T : Any> defaultPopTransitionSpec():
        AnimatedContentTransitionScope<Scene<T>>.() -> ContentTransform = {
    ContentTransform(
        fadeIn(animationSpec = tween(DEFAULT_TRANSITION_DURATION_MILLISECOND)),
        fadeOut(animationSpec = tween(DEFAULT_TRANSITION_DURATION_MILLISECOND)),
    )
}

fun <T : Any> defaultPredictivePopTransitionSpec():
        AnimatedContentTransitionScope<Scene<T>>.(@NavigationEvent.SwipeEdge Int) -> ContentTransform =
    {
        ContentTransform(
            fadeIn(
                spring(
                    dampingRatio = 1.0f, // reflects material3 motionScheme.defaultEffectsSpec()
                    stiffness = 1600.0f, // reflects material3 motionScheme.defaultEffectsSpec()
                )
            ),
            scaleOut(targetScale = 0.7f),
        )
    }
