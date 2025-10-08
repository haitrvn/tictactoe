package com.haitrvn.coreui.theme

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.dp

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

internal val LocalContentPadding = staticCompositionLocalOf {
    ContentPadding()
}