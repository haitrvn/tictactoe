package com.haitrvn.coreui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import com.haitrvn.coreui.CookSpaceDimensions
import com.haitrvn.coreui.LocalDimensions

@Composable
fun CookTheme(
    typography: Typography = CreateCookTypography(),
    contentPadding: ContentPadding = ContentsPadding,
    shapes: Shape = Shapes,
    systemIsDark: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colors = if (systemIsDark) DarkColors else LightColors
    val rememberedColors = remember(systemIsDark) { colors }
    CompositionLocalProvider(
        LocalColors provides rememberedColors,
        LocalShape provides shapes,
        LocalTypography provides typography,
        LocalContentPadding provides contentPadding,
    ) {
        content()
    }
}

val AppColors: Color
    @Composable
    @ReadOnlyComposable
    get() = LocalColors.current

internal val Typographies: Typography
    @Composable
    @ReadOnlyComposable
    get() = LocalTypography.current

val Shapes: Shape
    @Composable
    @ReadOnlyComposable
    get() = LocalShape.current

val ContentsPadding: ContentPadding
    @Composable
    @ReadOnlyComposable
    get() = LocalContentPadding.current

val Dimensions: CookSpaceDimensions
    @Composable
    @ReadOnlyComposable
    get() = LocalDimensions.current