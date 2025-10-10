package com.haitrvn.coreui.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
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

fun Modifier.conditionalClickable(
    onClick: (() -> Unit)?,
    enabled: Boolean = true
) = composed {
    if (onClick != null) {
        clickable(enabled = enabled, onClick = onClick)
    } else {
        this
    }
}