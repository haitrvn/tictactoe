package com.haitrvn.coreui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import com.haitrvn.coreui.CookSpaceDimensions
import com.haitrvn.coreui.CookSurface
import com.haitrvn.coreui.LocalSpace

@Composable
fun CookTheme(
    typography: CookTypography = CookTypography.withFontFamily(),
    contentPadding: ContentPadding = CookTheme.contentPadding,
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
        LocalContentPadding provides contentPadding,
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

    val contentPadding: ContentPadding
        @ReadOnlyComposable
        @Composable
        get() = LocalContentPadding.current

    val space: CookSpaceDimensions
        @ReadOnlyComposable
        @Composable
        get() = LocalSpace.current
}