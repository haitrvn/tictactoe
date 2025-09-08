package com.haitrvn.coreui.theme

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

internal val LocalShapes = staticCompositionLocalOf {
    Shapes(
        small = RoundedCornerShape(size = 15.dp),
        medium = RoundedCornerShape(size = 30.dp),
        large = RoundedCornerShape(size = 40.dp)
    )
}

internal val LocalContentPadding = staticCompositionLocalOf {
    ContentPadding()
}

data class ContentPadding(
    val default: PaddingValues = PaddingValues(
        all = 2.dp
    ),
    val small: PaddingValues = PaddingValues(
        horizontal = 16.dp,
        vertical = 8.dp
    ),
    val medium: PaddingValues = PaddingValues(
        horizontal = 24.dp,
        vertical = 10.dp
    ),
    val large: PaddingValues = PaddingValues(
        horizontal = 40.dp,
        vertical = 20.dp
    ),
)