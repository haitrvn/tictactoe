package com.haitrvn.coreui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Shape as ComposeShape

data class Shape(
    val small: ComposeShape = RoundedCornerShape(4.dp),
    val medium: ComposeShape = RoundedCornerShape(8.dp),
    val large: ComposeShape = RoundedCornerShape(16.dp),
)

internal val LocalShape = staticCompositionLocalOf { Shape() }