package com.haitrvn.coreui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember

val LightColors = CookColor(
    primary = darkPrimary,
    background = darkBackground,
    textPrimary = darkTextPrimary,
    onPrimary = darkOnPrimary,
    onBackground = darkOnBackground,
)

val DarkColors = CookColor(
    primary = lightPrimary,
    background = lightBackground,
    textPrimary = lightTextPrimary,
    onPrimary = lightOnPrimary,
    onBackground = lightOnBackground,
)

@Composable
fun CookTheme(
    typography: CookTypography = CookTheme.typography,
    shapes: Shapes = CookTheme.shapes,
    content: @Composable () -> Unit
) {
    val systemIsDark = isSystemInDarkTheme()
    val colors = if (systemIsDark) DarkColors else LightColors
    val rememberedColors = remember { colors.copy() }.apply { updateColorsFrom(colors) }
    CompositionLocalProvider(
        LocalColors provides rememberedColors,
        LocalShapes provides shapes,
        LocalTypography provides typography,
    ) {
        ProvideTextStyle(value = typography.paragraph, content = content)
    }
}

object CookTheme {

    val colors: CookColor
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val typography: CookTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    // We use the default material shapes
    val shapes: Shapes
        @ReadOnlyComposable
        @Composable
        get() = LocalShapes.current
}