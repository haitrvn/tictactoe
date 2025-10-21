package com.haitrvn.coreui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

class Color(
    primary: Color,
    onPrimary: Color,
    primaryContainer: Color,
    onPrimaryContainer: Color,
    secondary: Color,
    onSecondary: Color,
    secondaryContainer: Color,
    onSecondaryContainer: Color,
    tertiary: Color,
    onTertiary: Color,
    tertiaryContainer: Color,
    onTertiaryContainer: Color,
    background: Color,
    onBackground: Color,
    surface: Color,
    onSurface: Color,
    error: Color,
    onError: Color,
    errorContainer: Color,
    onErrorContainer: Color,
) {
    var primary by mutableStateOf(primary)
        private set
    var onPrimary by mutableStateOf(onPrimary)
        private set
    var primaryContainer by mutableStateOf(primaryContainer)
        private set
    var onPrimaryContainer by mutableStateOf(onPrimaryContainer)
        private set

    var secondary by mutableStateOf(secondary)
        private set
    var onSecondary by mutableStateOf(onSecondary)
        private set
    var secondaryContainer by mutableStateOf(secondaryContainer)
        private set
    var onSecondaryContainer by mutableStateOf(onSecondaryContainer)
        private set

    var tertiary by mutableStateOf(tertiary)
        private set
    var onTertiary by mutableStateOf(onTertiary)
        private set
    var tertiaryContainer by mutableStateOf(tertiaryContainer)
        private set
    var onTertiaryContainer by mutableStateOf(onTertiaryContainer)
        private set

    var background by mutableStateOf(background)
        private set
    var onBackground by mutableStateOf(onBackground)
        private set

    var surface by mutableStateOf(surface)
        private set
    var onSurface by mutableStateOf(onSurface)
        private set

    var error by mutableStateOf(error)
        private set
    var onError by mutableStateOf(onError)
        private set
    var errorContainer by mutableStateOf(errorContainer)
        private set
    var onErrorContainer by mutableStateOf(onErrorContainer)
        private set
}

val LightColors = Color(
    primary = Color(0xffff6b00),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xffe5dfec),
    onPrimaryContainer = Color(0xff0e0e0e),

    secondary = Color(0x4dffffff),
    onSecondary = Color(0xFF000000),
    secondaryContainer = Color(0xffffffff),
    onSecondaryContainer = Color(0xFF000000),

    tertiary = Color(0xFFB00020),
    onTertiary = Color(0xFFFFFFFF),
    tertiaryContainer = Color(0xFF370617),
    onTertiaryContainer = Color(0xFFFFFFFF),

    background = Color(0xffffffff),
    onBackground = Color(0xffa3a3a3),

    surface = Color(0xFFFFFFFF),
    onSurface = Color(0xFF000000),

    error = Color(0xffff0000),
    onError = Color(0xffffffff),
    errorContainer = Color(0xffffffff),
    onErrorContainer = Color(0xffff0000),
)

val DarkColors = Color(
    primary = Color(0xffd16110),
    onPrimary = Color(0xffffffff),
    primaryContainer = Color(0xffe5dfec),
    onPrimaryContainer = Color(0xff1c1b1b),

    secondary = Color(0xFF03DAC6),
    onSecondary = Color(0xFF000000),
    secondaryContainer = Color(0xffffffff),
    onSecondaryContainer = Color(0xFF000000),

    tertiary = Color(0xFFCF6679),
    onTertiary = Color(0xFF000000),
    tertiaryContainer = Color(0xFFB00020),
    onTertiaryContainer = Color(0xFFFFFFFF),

    background = Color(0xff000000),
    onBackground = Color(0xff535353),

    surface = Color(0xFF121212),
    onSurface = Color(0xFFFFFFFF),

    error = Color(0xffff0000),
    onError = Color(0xffffffff),
    errorContainer = Color(0xffffffff),
    onErrorContainer = Color(0xffff0000),
)

internal val LocalColors = staticCompositionLocalOf { LightColors }