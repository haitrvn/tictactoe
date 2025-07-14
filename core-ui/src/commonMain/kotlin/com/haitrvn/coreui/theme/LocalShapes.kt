package com.haitrvn.coreui.theme

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

internal val LocalShapes = staticCompositionLocalOf {
    Shapes(
        small = RoundedCornerShape(size = 15.dp),
        medium = RoundedCornerShape(size = 20.dp),
        large = RoundedCornerShape(size = 20.dp)
    )
}

internal val LocalContentPadding = staticCompositionLocalOf {
    ContentPadding()
}

data class ContentPadding(
    val small: PaddingValues = PaddingValues(
        horizontal = 10.dp,
        vertical = 1.dp
    ),
    val medium: PaddingValues = PaddingValues(
        horizontal = 25.dp,
        vertical = 5.dp
    ),
    val large: PaddingValues = PaddingValues(
        horizontal = 30.dp,
        vertical = 6.dp
    ),
    val extraLarge: PaddingValues = PaddingValues(
        horizontal = 40.dp,
        vertical = 8.dp
    )
)