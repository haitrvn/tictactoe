package com.haitrvn.coreui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.theme.CookTheme

@Composable
fun CookSurface(
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    color: Color = CookTheme.colors.background1,
    shadowElevation: Dp = 0.dp,
    background: @Composable () -> Unit = {},
    content: @Composable () -> Unit,
) {
    Box(
        modifier = modifier
            .shadow(elevation = shadowElevation, shape = shape, clip = true)
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        background()
        Box(
            modifier = Modifier.padding(CookTheme.contentPadding.medium),
            contentAlignment = Alignment.Center
        ) {
            content()
        }
    }
}

@Composable
fun CookRoundSurface(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(10.dp),
    color: Color = CookTheme.colors.background1,
    shadowElevation: Dp = 10.dp,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .shadow(elevation = shadowElevation, shape = shape, clip = true)
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        Box(modifier = Modifier.padding(CookTheme.contentPadding.medium)) {
            content()
        }
    }
}