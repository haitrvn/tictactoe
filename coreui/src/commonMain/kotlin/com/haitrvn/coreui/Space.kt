package com.haitrvn.coreui

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.theme.Dimensions

internal val LocalDimensions = staticCompositionLocalOf {
    CookSpaceDimensions()
}

data class CookSpaceDimensions(
    val screenPadding: Dp = 16.dp,
    val tiny: Dp = 4.dp,
    val small: Dp = 8.dp,
    val medium: Dp = 16.dp,
    val large: Dp = 32.dp,
    val extraLarge: Dp = 64.dp,
)

@Composable
fun TinySpace(modifier: Modifier = Modifier) {
    Spacer(modifier.size(Dimensions.tiny))
}

@Composable
fun SmallSpace(modifier: Modifier = Modifier) {
    Spacer(modifier.size(Dimensions.small))
}

@Composable
fun MediumSpace(modifier: Modifier = Modifier) {
    Spacer(modifier.size(Dimensions.medium))
}

@Composable
fun LargeSpace(modifier: Modifier = Modifier) {
    Spacer(modifier.size(Dimensions.large))
}

@Composable
fun CustomSpace(size: Dp, modifier: Modifier = Modifier) {
    Spacer(modifier.size(size))
}