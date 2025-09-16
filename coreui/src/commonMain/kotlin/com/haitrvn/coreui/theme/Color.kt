package com.haitrvn.coreui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

class CookColor(
    primary: Color,
    onPrimary: Color,
    paragraph: Color,
    secondParagraph: Color,
    error: Color,
    link: Color,
    background1: Color,
    background2: Color,
    background3: Color
) {
    var primary by mutableStateOf(primary)
        private set
    var onPrimary by mutableStateOf(onPrimary)
        private set
    var paragraph by mutableStateOf(paragraph)
        private set
    var secondParagraph by mutableStateOf(secondParagraph)
        private set
    var error by mutableStateOf(error)
        private set
    var link by mutableStateOf(link)
        private set
    var background1 by mutableStateOf(background1)
        private set
    var background2 by mutableStateOf(background2)
        private set
    var background3 by mutableStateOf(background3)
        private set

    fun copy(
        primary: Color = this.primary,
        onPrimary: Color = this.onPrimary,
        paragraph: Color = this.paragraph,
        secondParagraph: Color = this.secondParagraph,
        error: Color = this.error,
        link: Color = this.link,
        background1: Color = this.background1,
        background2: Color = this.background2,
        background3: Color = this.background3
    ): CookColor = CookColor(
        primary = primary,
        onPrimary = onPrimary,
        paragraph = paragraph,
        secondParagraph = secondParagraph,
        error = error,
        link = link,
        background1 = background1,
        background2 = background2,
        background3 = background3
    )

    fun updateColorsFrom(other: CookColor) {
        primary = other.primary
        onPrimary = other.onPrimary
        paragraph = other.paragraph
        secondParagraph = other.secondParagraph
        error = other.error
        link = other.link
        background1 = other.background1
        background2 = other.background2
        background3 = other.background3
    }
}

val appleLoginBackground: Color = Color(0xFF1a1a1a)
val facebookLoginBackground: Color = Color(0xFF0866ff)
val googleLoginBackground: Color = Color(0xFFf0f4f8)
val googleLoginText: Color = Color(0xff000000)

val lightPrimary: Color = Color(0xFFff6e41)
val lightOnPrimary: Color = Color(0xFFFFFFFF)
val lightParagraph: Color = Color(0xff000000)
val lightSecondParagraph: Color = Color(0xff292929)
val lightError: Color = Color(0xfffb0909)
val lightLink: Color = Color(0xccff6e41)
val lightBackground1: Color = Color(0xFFFFFFFF)
val lightBackground2: Color = Color(0xFFf5f5f5)
val lightBackground3: Color = Color(0xFFfff2eb)

val darkPrimary: Color = Color(0xFFff6e41)
val darkOnPrimary: Color = Color(0xFFFFFFFF)
val darkParagraph: Color = Color(0xFFFFFFFF)
val darkSecondParagraph: Color = Color(0xffd6d6d6)
val darkError: Color = Color(0xffe40303)
val darkLink: Color = Color(0xccff6e41)
val darkBackground1: Color = Color(0xFF090d19)
val darkBackground2: Color = Color(0xFF161c2c)
val darkBackground3: Color = Color(0xFF161c2c)

internal val LocalColors = staticCompositionLocalOf { LightColors }

val LightColors = CookColor(
    primary = lightPrimary,
    onPrimary = lightOnPrimary,
    paragraph = lightParagraph,
    secondParagraph = lightSecondParagraph,
    error = lightError,
    link = lightLink,
    background1 = lightBackground1,
    background2 = lightBackground2,
    background3 = lightBackground3
)

val DarkColors = CookColor(
    primary = darkPrimary,
    onPrimary = darkOnPrimary,
    paragraph = darkParagraph,
    secondParagraph = darkSecondParagraph,
    error = darkError,
    link = darkLink,
    background1 = darkBackground1,
    background2 = darkBackground2,
    background3 = darkBackground3
)