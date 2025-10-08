package com.haitrvn.coreui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.haitrvn.coreui.CookSpaceDimensions
import com.haitrvn.coreui.LocalSpace

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
        Box(modifier = Modifier.background(Colors.background1)) {
            content()
        }
    }
}

val Colors: Color
    @Composable
    @ReadOnlyComposable
    get() = LocalColors.current

val Typo: Typography
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

val Space: CookSpaceDimensions
    @Composable
    @ReadOnlyComposable
    get() = LocalSpace.current