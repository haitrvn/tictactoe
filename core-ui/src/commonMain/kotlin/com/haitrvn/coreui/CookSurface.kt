package com.haitrvn.coreui

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.theme.CookTheme
import com.haitrvn.coreui.theme.defaultContentColorFor
import com.haitrvn.coreui.base.CookSurface as BaseCookSurface

@Composable
fun CookSurface(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(10.dp),
    color: Color = CookTheme.colors.background,
    contentColor: Color = defaultContentColorFor(color),
    content: @Composable () -> Unit
) {
    BaseCookSurface(
        modifier = modifier,
        shape = shape,
        color = color,
        contentColor = contentColor,
    ) {
        content()
    }
}

@Composable
fun Card(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(10.dp),
    color: Color = CookTheme.colors.background,
    contentColor: Color = defaultContentColorFor(color),
    content: @Composable () -> Unit
) {
    BaseCookSurface(
        modifier = modifier,
        shape = shape,
        color = color,
        contentColor = contentColor,
    ) {
        content()
    }
}