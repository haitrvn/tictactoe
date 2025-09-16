@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.haitrvn.coreui.animate

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

context(scope: SharedTransitionScope)
@Composable
fun Modifier.sharedElementWithKey(
    key: String,
    animatedVisibilityScope: AnimatedVisibilityScope
): Modifier {
    return with(scope) {
        this@sharedElementWithKey.sharedElement(
            sharedContentState = rememberSharedContentState(key = key),
            animatedVisibilityScope = animatedVisibilityScope,
        )
    }
}