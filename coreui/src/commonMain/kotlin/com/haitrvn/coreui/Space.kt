package com.haitrvn.coreui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.theme.CookTheme

internal val LocalSpace = staticCompositionLocalOf {
    CookSpaceDimensions()
}

/**
 * Data class defining the standard spacing dimensions used in CookTheme.
 *
 * @property small The smallest spacing dimension.
 * @property medium The medium spacing dimension.
 * @property large The largest spacing dimension.
 */
data class CookSpaceDimensions(
    val screenPadding: Dp = 16.dp,
    val small: Dp = 8.dp,
    val medium: Dp = 16.dp,
    val large: Dp = 32.dp,
    val extraLarge: Dp = 50.dp,
)

/**
 * Composable function to create a spacer with a "small" dimension (height for Column, width for Row),
 * as defined in [CookTheme.space].
 *
 * @param modifier Optional [Modifier] to be applied to the spacer.
 */
@Composable
fun SmallSpace(modifier: Modifier = Modifier) {
    Spacer(modifier.size(CookTheme.space.small))
}

/**
 * Composable function to create a spacer with a "medium" dimension (height for Column, width for Row),
 * as defined in [CookTheme.space].
 *
 * @param modifier Optional [Modifier] to be applied to the spacer.
 */
@Composable
fun MediumSpace(modifier: Modifier = Modifier) {
    Spacer(modifier.size(CookTheme.space.medium))
}

/**
 * Composable function to create a spacer with a "large" dimension (height for Column, width for Row),
 * as defined in [CookTheme.space].
 *
 * @param modifier Optional [Modifier] to be applied to the spacer.
 */
@Composable
fun LargeSpace(modifier: Modifier = Modifier) {
    Spacer(modifier.size(CookTheme.space.large))
}

/**
 * Composable function to create a custom-sized spacer.
 *
 * @param size The desired size (height and width) of the spacer.
 * @param modifier Optional [Modifier] to be applied to the spacer.
 */
@Composable
fun CustomSpace(size: Dp, modifier: Modifier = Modifier) {
    Spacer(modifier.size(size))
}