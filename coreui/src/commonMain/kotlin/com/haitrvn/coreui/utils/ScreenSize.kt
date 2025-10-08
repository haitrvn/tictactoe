package com.haitrvn.coreui.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.dp
import com.haitrvn.core.Log

@Composable
fun rememberScreenSizeType(): ScreenSizeType {
    val configuration = LocalWindowInfo.current
    val screenWidth = configuration.containerSize.width
    Log.d("ScreenSizeType", "screenWidth: $screenWidth")

    return when {
        screenWidth < 600 -> ScreenSizeType.Small
        screenWidth < 840 -> ScreenSizeType.Medium
        else -> ScreenSizeType.Large
    }
}

enum class ScreenSizeType {
    Small,
    Medium,
    Large
}