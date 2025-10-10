package com.haitrvn.coreui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Shape as ComposeShape

data class Shape(
    val rounded: ComposeShape = RoundedCornerShape(10.dp),
)

internal val LocalShape = staticCompositionLocalOf { Shape() }