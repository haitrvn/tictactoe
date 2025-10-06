package com.haitrvn.coreui

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import com.haitrvn.coreui.theme.Colors

@Composable
fun SmoothLinearProgressBar(
    progress: Float,
    modifier: Modifier = Modifier,
    trackColor: Color = Colors.background2,
    progressColor: Color = Colors.primary,
    animate: Boolean = true,
    animationSpec: AnimationSpec<Float> = tween(durationMillis = 600, easing = FastOutSlowInEasing),
) {
    val coerced = progress.coerceIn(0f, 1f)
    val anim = remember { Animatable(0f) }
    var initialized by rememberSaveable { mutableStateOf(false) }

    LaunchedEffect(coerced, animate, animationSpec) {
        if (!initialized) {
            anim.snapTo(0f)
            initialized = true
        }
        if (animate) {
            anim.animateTo(coerced, animationSpec = animationSpec)
        } else {
            anim.snapTo(coerced)
        }
    }

    Box(modifier = modifier) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val w = size.width
            val h = size.height
            val r = h / 2

            drawRoundRect(
                color = trackColor,
                size = Size(w, h),
                cornerRadius = CornerRadius(r, r)
            )
            val clip = Path().apply {
                addRoundRect(RoundRect(0f, 0f, w, h, CornerRadius(r, r)))
            }
            val reachedW = w * anim.value
            clipPath(clip) {
                drawRoundRect(
                    color = progressColor,
                    size = Size(reachedW, h),
                    cornerRadius = CornerRadius(r, r)
                )
            }
        }
    }
}
