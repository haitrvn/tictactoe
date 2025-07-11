package com.haitrvn.coreui.theme

import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.takeOrElse

val darkPrimary = Color(0xFFFF6A00)
val darkBackground = Color(0xcc000000)
val darkTextPrimary = Color(0xffffffff)
val darkOnPrimary = Color(0xFF000000)
val darkOnBackground = Color(0xffffffff)

val lightPrimary = Color(0xFFFF6A00)
val lightBackground = Color(0xfffefefe)
val lightTextPrimary = Color(0xcc000000)
val lightOnPrimary = Color(0xccffffff)
val lightOnBackground = Color(0xFF000000)

class CookColor(
    primary: Color,
    background: Color,
    textPrimary: Color,
    onPrimary: Color,
    onBackground: Color,
) {

    var primary by mutableStateOf(primary)
        private set
    var background by mutableStateOf(background)
        private set
    var textPrimary by mutableStateOf(textPrimary)
        private set
    var onPrimary by mutableStateOf(onPrimary)
        private set
    var onBackground by mutableStateOf(onBackground)
        private set

    fun copy(
        primary: Color = this.primary,
        background: Color = this.background,
        textPrimary: Color = this.textPrimary,
        onPrimary: Color = this.onPrimary,
        onBackground: Color = this.onBackground,
    ): CookColor = CookColor(
        primary,
        background,
        textPrimary,
        onPrimary,
        onBackground,
    )

    fun updateColorsFrom(other: CookColor) {
        primary = other.primary
        background = other.background
        textPrimary = other.textPrimary
        onPrimary = other.onPrimary
        onBackground = other.onBackground
    }
}

internal val LocalColors = staticCompositionLocalOf { LightColors }