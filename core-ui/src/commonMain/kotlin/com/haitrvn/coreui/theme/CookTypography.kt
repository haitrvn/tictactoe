package com.haitrvn.coreui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import cookapp.resources.coreui.Res
import cookapp.resources.coreui.nunito_italic
import cookapp.resources.coreui.nunito_normal
import cookapp.resources.coreui.oleo_script_bold
import cookapp.resources.coreui.oleo_script_regular
import org.jetbrains.compose.resources.Font

@Immutable
class CookTypography(
    val app: TextStyle = CookTypographyTokens.app,
    val header: TextStyle = CookTypographyTokens.header,
    val bigTitle: TextStyle = CookTypographyTokens.bigTitle,
    val title: TextStyle = CookTypographyTokens.title,
    val smallTitle: TextStyle = CookTypographyTokens.smallTitle,
    val paragraph: TextStyle = CookTypographyTokens.paragraph,
    val error: TextStyle = CookTypographyTokens.error,
    val small: TextStyle = CookTypographyTokens.small,
    val tiny: TextStyle = CookTypographyTokens.tiny,
) {
    fun copy(
        app: TextStyle = this.app,
        header: TextStyle = this.header,
        bigTitle: TextStyle = this.bigTitle,
        title: TextStyle = this.title,
        smallTitle: TextStyle = this.smallTitle,
        paragraph: TextStyle = this.paragraph,
        error: TextStyle = this.error,
        small: TextStyle = this.small,
        tiny: TextStyle = this.tiny,
    ): CookTypography = CookTypography(
        app, header, bigTitle, title, smallTitle, paragraph, error, small, tiny
    )
}

@Composable
fun CreateCookTypography(
    defaultColor: Color = CookTheme.colors.paragraph,
    nunitoFontFamily: FontFamily = FontFamily(
        Font(Res.font.nunito_italic),
        Font(Res.font.nunito_normal),
    ),
    oleoscriptFontFamily: FontFamily = FontFamily(
        Font(Res.font.oleo_script_bold),
        Font(Res.font.oleo_script_regular),
    ),
): CookTypography = CookTypography(
    app = CookTypographyTokens.app.copy(
        color = defaultColor,
        fontFamily = oleoscriptFontFamily
    ),
    header = CookTypographyTokens.header.copy(
        color = defaultColor,
        fontFamily = nunitoFontFamily
    ),
    bigTitle = CookTypographyTokens.bigTitle.copy(
        color = defaultColor,
        fontFamily = nunitoFontFamily
    ),
    title = CookTypographyTokens.title.copy(
        color = defaultColor,
        fontFamily = nunitoFontFamily
    ),
    smallTitle = CookTypographyTokens.smallTitle.copy(
        color = defaultColor,
        fontFamily = nunitoFontFamily
    ),
    paragraph = CookTypographyTokens.paragraph.copy(
        color = defaultColor,
        fontFamily = nunitoFontFamily
    ),
    error = CookTypographyTokens.error.copy(
        color = defaultColor,
        fontFamily = nunitoFontFamily
    ),
    small = CookTypographyTokens.small.copy(
        color = defaultColor,
        fontFamily = nunitoFontFamily
    ),
    tiny = CookTypographyTokens.tiny.copy(color = defaultColor, fontFamily = nunitoFontFamily),
)

internal val LocalTypography = staticCompositionLocalOf { CookTypography() }


object CookTypographyTokens {
    val app = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        fontStyle = FontStyle.Normal,
    )

    val header = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        fontStyle = FontStyle.Normal,
    )

    val bigTitle = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        lineHeight = 28.sp,
        fontStyle = FontStyle.Normal,
    )

    val title = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        lineHeight = 24.sp,
        fontStyle = FontStyle.Normal,
    )

    val smallTitle = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontStyle = FontStyle.Normal,
    )

    val paragraph = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontStyle = FontStyle.Normal,
    )

    val error = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        fontStyle = FontStyle.Normal,
    )

    val small = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        fontStyle = FontStyle.Normal,
    )

    val tiny = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        lineHeight = 14.sp,
        fontStyle = FontStyle.Normal,
    )
}