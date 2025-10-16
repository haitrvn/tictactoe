package com.haitrvn.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf

public val LocalNavAnimatedContentScope: ProvidableCompositionLocal<AnimatedContentScope> =
    compositionLocalOf {
        // no default, we need an AnimatedContent to get the AnimatedContentScope
        throw IllegalStateException(
            "Unexpected access to LocalNavAnimatedContentScope. You should only " +
                    "access LocalNavAnimatedContentScope inside a NavEntry passed " +
                    "to NavDisplay."
        )
    }