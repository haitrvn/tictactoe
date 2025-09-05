package com.haitrvn.coreui

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import com.haitrvn.coreui.theme.CookTheme

@Composable
fun SmoothLinearProgressBar(
    progress: Float,
    modifier: Modifier = Modifier,
    trackColor: Color = CookTheme.colors.background2,
    progressColor: Color = CookTheme.colors.primary,
    animate: Boolean = true,
    animationSpec: AnimationSpec<Float> = tween(durationMillis = 600, easing = FastOutSlowInEasing),
) {
    val coerced = progress.coerceIn(0f, 1f)
    val animated by animateFloatAsState(
        targetValue = coerced,
        animationSpec = if (animate) animationSpec else snap(),
    )
    Box(modifier = modifier) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val w = size.width
            val h = size.height
            val r = h/2

            drawRoundRect(
                color = trackColor,
                size = Size(w, h),
                cornerRadius = CornerRadius(r, r)
            )
            val clip = Path().apply {
                addRoundRect(RoundRect(0f, 0f, w, h, CornerRadius(r, r)))
            }
            val reachedW = w * animated
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