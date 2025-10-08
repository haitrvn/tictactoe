package com.haitrvn.coreui.utils

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.haitrvn.coreui.theme.AppColors

@Composable
@Stable
fun Modifier.appBackground(
    color: Color = AppColors.background
): Modifier {
    return this.then(
        background(color)
    )
}