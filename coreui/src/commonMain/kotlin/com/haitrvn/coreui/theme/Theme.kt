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
    typography: CookTypography = CreateCookTypography(),
    contentPadding: ContentPadding = ContentsPadding,
    shapes: Shapes = Shapes,
    systemIsDark: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colors = if (systemIsDark) DarkColors else LightColors
    val rememberedColors = remember(systemIsDark) { colors }
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

val Colors: CookColor
    @Composable
    @ReadOnlyComposable
    get() = LocalColors.current

val Typo: CookTypography
    @Composable
    @ReadOnlyComposable
    get() = LocalTypography.current

val Shapes: Shapes
    @Composable
    @ReadOnlyComposable
    get() = LocalShapes.current

val ContentsPadding: ContentPadding
    @Composable
    @ReadOnlyComposable
    get() = LocalContentPadding.current

val Space: CookSpaceDimensions
    @Composable
    @ReadOnlyComposable
    get() = LocalSpace.current