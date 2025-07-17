package com.haitrvn.coreui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val darkPrimary = Color(0xFFFF6A00)
val darkBackground = Color(0xcc000000)

val darkSecondaryBackground = Color(0xff707070)
val darkTextPrimary = Color(0xffffffff)
val darkOnPrimary = Color(0xFF000000)
val darkOnBackground = Color(0xffffffff)

val darkLink = Color(0xff0048ff)

val lightPrimary = Color(0xFFFF6A00)
val lightBackground = Color(0xfffefefe)

val lightSecondaryBackground = Color(0xff7f7f7f)
val lightTextPrimary = Color(0xcc000000)
val lightOnPrimary = Color(0xccffffff)
val lightOnBackground = Color(0xFF000000)

val lightLink = Color(0xff0048ff)

class CookColor(
    primary: Color,
    background: Color,
    secondaryBackground: Color,
    textPrimary: Color,
    onPrimary: Color,
    onBackground: Color,
    link: Color,
) {

    var primary by mutableStateOf(primary)
        private set
    var background by mutableStateOf(background)
        private set
    var secondaryBackground by mutableStateOf(secondaryBackground)
        private set
    var textPrimary by mutableStateOf(textPrimary)
        private set
    var onPrimary by mutableStateOf(onPrimary)
        private set
    var onBackground by mutableStateOf(onBackground)
        private set

    var link by mutableStateOf(link)
        private set

    fun copy(
        primary: Color = this.primary,
        background: Color = this.background,
        secondaryBackground: Color = this.secondaryBackground,
        textPrimary: Color = this.textPrimary,
        onPrimary: Color = this.onPrimary,
        onBackground: Color = this.onBackground,
        link: Color = this.link,
    ): CookColor = CookColor(
        primary,
        background,
        secondaryBackground,
        textPrimary,
        onPrimary,
        onBackground,
        link
    )

    fun updateColorsFrom(other: CookColor) {
        primary = other.primary
        background = other.background
        secondaryBackground = other.secondaryBackground
        textPrimary = other.textPrimary
        onPrimary = other.onPrimary
        onBackground = other.onBackground
        link = other.link
    }
}

internal val LocalColors = staticCompositionLocalOf { LightColors }