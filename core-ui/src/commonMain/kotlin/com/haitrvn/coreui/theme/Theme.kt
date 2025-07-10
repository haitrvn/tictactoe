package com.haitrvn.coreui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import com.haitrvn.coreui.CookSurface

val LightColors = CookColor(
    primary = lightPrimary,
    background = lightBackground,
    textPrimary = lightTextPrimary,
    onPrimary = lightOnPrimary,
    onBackground = lightOnBackground,
)

val DarkColors = CookColor(
    primary = darkPrimary,
    background = darkBackground,
    textPrimary = darkTextPrimary,
    onPrimary = darkOnPrimary,
    onBackground = darkOnBackground,
)

@Composable
fun CookTheme(
    typography: CookTypography = CookTheme.typography,
    shapes: Shapes = CookTheme.shapes,
    systemIsDark: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colors = if (systemIsDark) DarkColors else LightColors
    val rememberedColors = remember { colors.copy() }.apply { updateColorsFrom(colors) }
    CompositionLocalProvider(
        LocalColors provides rememberedColors,
        LocalShapes provides shapes,
        LocalTypography provides typography,
    ) {
        CookSurface {
            content()
        }
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