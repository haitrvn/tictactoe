package com.haitrvn.coreui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.theme.CookTheme

internal val LocalSpace = staticCompositionLocalOf {
    CookSpaceDimensions()
}

data class CookSpaceDimensions(
    val small: Dp = 8.dp,
    val medium: Dp = 16.dp,
    val large: Dp = 24.dp
)

enum class SpaceSize {
    SMALL,
    MEDIUM,
    LARGE
}

@Composable
fun CookSpace(modifier: Modifier = Modifier) {
    Spacer(modifier)
}

@Composable
fun CookSpace(size: SpaceSize) {
    val height = when (size) {
        SpaceSize.SMALL -> CookTheme.space.small
        SpaceSize.MEDIUM -> CookTheme.space.medium
        SpaceSize.LARGE -> CookTheme.space.large
    }
    Spacer(Modifier.height(height))
}

