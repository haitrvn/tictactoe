package com.haitrvn.coreui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.theme.AppColors

@Composable
fun VerticalDivider(
    modifier: Modifier = Modifier,
    color: Color = AppColors.secondary,
    thickness: Dp = 1.dp
) {
    Box(
        modifier
            .fillMaxHeight()
            .width(thickness)
            .background(color = color)
    )
}

@Composable
fun HorizontalDivider(
    modifier: Modifier = Modifier,
    color: Color = AppColors.secondary,
    thickness: Dp = 1.dp
) {
    Box(
        modifier
            .height(thickness)
            .background(color = color)
    )
}
