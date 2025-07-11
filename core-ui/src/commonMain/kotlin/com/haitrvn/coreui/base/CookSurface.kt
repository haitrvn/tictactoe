package com.haitrvn.coreui.base

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.theme.CookTheme

@Composable
internal fun CookSurface(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(10.dp),
    color: Color = CookTheme.colors.background,
    content: @Composable () -> Unit
) {
    Surface(
        modifier = modifier,
        shape = shape,
        color = color,
    ) {
        content()
    }
}