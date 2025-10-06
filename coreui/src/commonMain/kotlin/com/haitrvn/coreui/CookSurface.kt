package com.haitrvn.coreui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
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
    paddingValues: PaddingValues = PaddingValues(0.dp),
    content: @Composable BoxScope.() -> Unit = {},
) {
    Box(
        modifier = modifier
            .shadow(elevation = shadowElevation, shape = shape, clip = true)
            .background(color),
    ) {
        Box(
            modifier = Modifier.wrapContentSize().padding(paddingValues),
        ) {
            content()
        }
    }
}