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
    primary = DesignColorsLight.Blue.Blue500,
    onPrimary = DesignColorsLight.BlackAndWhite.White,
    primaryContainer = DesignColorsLight.Blue.Blue100,
    onPrimaryContainer = DesignColorsLight.Blue.Blue900,

    secondary = DesignColorsLight.Turquoise.Turquoise500,
    onSecondary = DesignColorsLight.BlackAndWhite.White,
    secondaryContainer = DesignColorsLight.Turquoise.Turquoise100,
    onSecondaryContainer = DesignColorsLight.Turquoise.Turquoise900,

    tertiary = DesignColorsLight.Purple.Purple500,
    onTertiary = DesignColorsLight.BlackAndWhite.White,
    tertiaryContainer = DesignColorsLight.Purple.Purple100,
    onTertiaryContainer = DesignColorsLight.Purple.Purple900,

    background = DesignColorsLight.BlackAndWhite.White,
    onBackground = DesignColorsLight.BlackAndWhite.Black900,

    surface = DesignColorsLight.BlackAndWhite.White,
    onSurface = DesignColorsLight.BlackAndWhite.Black900,

    error = DesignColorsLight.Error.Red500,
    onError = DesignColorsLight.BlackAndWhite.White,
    errorContainer = DesignColorsLight.Error.Red200,
    onErrorContainer = DesignColorsLight.Error.Red700,

    success = DesignColorsLight.Success.Green500,
    onSuccess = DesignColorsLight.BlackAndWhite.White,
    successContainer = DesignColorsLight.Success.Green200,
    onSuccessContainer = DesignColorsLight.Success.Green800,

    outline = DesignColorsLight.BlackAndWhite.Grey400,
)

val colorPrimary = Color(0xFFFC5C7D)
val colorPrimaryDark = Color(0xFFCE1CFF)
val colorAccent = Color(0xFF9AB3FF)
val colorSoundbound = Color(0xFF4b9fff)
val colorAccentVariant = Color(0xFF3457D5)
val colorRedError = Color(0xFFFF9494)
val colorSuccessGreen = Color(0xFF59C351)
val darkBackgroundColor = Color(0xFF000000)
val colorOffWhite = Color(0xFFE7E7E7)
val transparent = Color(0x00000000)
val black = Color(0xFF000000)
val lightGray = Color(0xFFCCCCCC)



val DarkColors = Color(
    primary = DesignColorsDark.Blue.Blue500,
    onPrimary = DesignColorsDark.BlackAndWhite.White,
    primaryContainer = DesignColorsDark.Blue.Blue900,
    onPrimaryContainer = DesignColorsDark.Blue.Blue100,

    secondary = DesignColorsDark.Turquoise.Turquoise500,
    onSecondary = DesignColorsDark.BlackAndWhite.Black900,
    secondaryContainer = DesignColorsDark.Turquoise.Turquoise900,
    onSecondaryContainer = DesignColorsDark.Turquoise.Turquoise100,

    tertiary = DesignColorsDark.Purple.Purple500,
    onTertiary = DesignColorsDark.BlackAndWhite.Black900,
    tertiaryContainer = DesignColorsDark.Purple.Purple900,
    onTertiaryContainer = DesignColorsDark.Purple.Purple100,

    background = DesignColorsDark.BlackAndWhite.Black900,
    onBackground = DesignColorsDark.BlackAndWhite.Grey100,

    surface = DesignColorsDark.BlackAndWhite.Grey100,
    onSurface = DesignColorsDark.BlackAndWhite.White,

    error = DesignColorsDark.Error.Red500,
    onError = DesignColorsDark.BlackAndWhite.Black900,
    errorContainer = DesignColorsDark.Error.Red800,
    onErrorContainer = DesignColorsDark.Error.Red200,

    success = DesignColorsDark.Success.Green500,
    onSuccess = DesignColorsDark.BlackAndWhite.Black900,
    successContainer = DesignColorsDark.Success.Green800,
    onSuccessContainer = DesignColorsDark.Success.Green200,

    outline = DesignColorsDark.BlackAndWhite.Grey600,
)

internal val LocalColors = staticCompositionLocalOf { LightColors }