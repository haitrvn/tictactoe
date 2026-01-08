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
    success: Color,
    onSuccess: Color,
    successContainer: Color,
    onSuccessContainer: Color,
    outline: Color,
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

    var success by mutableStateOf(success)
        private set
    var onSuccess by mutableStateOf(onSuccess)
        private set
    var successContainer by mutableStateOf(successContainer)
        private set
    var onSuccessContainer by mutableStateOf(onSuccessContainer)
        private set

    var outline by mutableStateOf(outline)
        private set
}

val LightColors = Color(
    primary = DesignColors.Primary100,
    onPrimary = DesignColors.White100,
    primaryContainer = DesignColors.Primary50,
    onPrimaryContainer = DesignColors.Primary100,

    secondary = DesignColors.Blue,
    onSecondary = DesignColors.White100,
    secondaryContainer = DesignColors.Blue,
    onSecondaryContainer = DesignColors.White100,

    tertiary = DesignColors.Orange,
    onTertiary = DesignColors.White100,
    tertiaryContainer = DesignColors.Orange,
    onTertiaryContainer = DesignColors.White100,

    background = DesignColors.BgLight1,
    onBackground = DesignColors.Black100,

    surface = DesignColors.BgLight2,
    onSurface = DesignColors.Black100,

    error = DesignColors.Red,
    onError = DesignColors.White100,
    errorContainer = DesignColors.Red,
    onErrorContainer = DesignColors.White100,

    success = DesignColors.Green,
    onSuccess = DesignColors.White100,
    successContainer = DesignColors.Green,
    onSuccessContainer = DesignColors.White100,

    outline = DesignColors.Black50,
)

val DarkColors = Color(
    primary = DesignColors.DarkPrimary100,
    onPrimary = DesignColors.White100,
    primaryContainer = DesignColors.Primary50,
    onPrimaryContainer = DesignColors.Primary100,

    secondary = DesignColors.Blue,
    onSecondary = DesignColors.White100,
    secondaryContainer = DesignColors.Blue,
    onSecondaryContainer = DesignColors.White100,

    tertiary = DesignColors.Orange,
    onTertiary = DesignColors.White100,
    tertiaryContainer = DesignColors.Orange,
    onTertiaryContainer = DesignColors.White100,

    background = DesignColors.BgDark1,
    onBackground = DesignColors.White100,

    surface = DesignColors.BgDark2,
    onSurface = DesignColors.White100,

    error = DesignColors.Red,
    onError = DesignColors.White100,
    errorContainer = DesignColors.Red,
    onErrorContainer = DesignColors.White100,

    success = DesignColors.Green,
    onSuccess = DesignColors.White100,
    successContainer = DesignColors.Green,
    onSuccessContainer = DesignColors.White100,

    outline = DesignColors.White50,
)

internal val LocalColors = staticCompositionLocalOf { LightColors }