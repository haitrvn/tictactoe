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
import cookapp.resources.core.ui.Res
import cookapp.resources.core.ui.nunito_italic
import cookapp.resources.core.ui.nunito_normal
import org.jetbrains.compose.resources.Font

@Immutable
class Typography(
    val headingBold: TextStyle = CookTypographyTokens.headingBold,
    val h4Bold: TextStyle = CookTypographyTokens.h4Bold,
    val h5Bold: TextStyle = CookTypographyTokens.h5Bold,
    val paragraphBold: TextStyle = CookTypographyTokens.paragraphBold,
    val paragraphRegular: TextStyle = CookTypographyTokens.paragraphRegular,
    val labelBold: TextStyle = CookTypographyTokens.labelBold,
    val labelRegular: TextStyle = CookTypographyTokens.labelRegular,
    val smallBold: TextStyle = CookTypographyTokens.smallBold,
    val smallRegular: TextStyle = CookTypographyTokens.smallRegular,
    val tinyRegular: TextStyle = CookTypographyTokens.tinyRegular,
    val timeStatusBar: TextStyle = CookTypographyTokens.timeStatusBar,
) {
    fun copy(
        headingBold: TextStyle = this.headingBold,
        h4Bold: TextStyle = this.h4Bold,
        h5Bold: TextStyle = this.h5Bold,
        paragraphBold: TextStyle = this.paragraphBold,
        paragraphRegular: TextStyle = this.paragraphRegular,
        labelBold: TextStyle = this.labelBold,
        labelRegular: TextStyle = this.labelRegular,
        smallBold: TextStyle = this.smallBold,
        smallRegular: TextStyle = this.smallRegular,
        tinyRegular: TextStyle = this.tinyRegular,
        timeStatusBar: TextStyle = this.timeStatusBar,
    ): Typography = Typography(
        headingBold,
        h4Bold,
        h5Bold,
        paragraphBold,
        paragraphRegular,
        labelBold,
        labelRegular,
        smallBold,
        smallRegular,
        tinyRegular,
        timeStatusBar
    )
}

@Composable
fun CreateCookTypography(
    defaultColor: Color = AppColors.onPrimary,
    poppinsFontFamily: FontFamily = FontFamily(
        Font(Res.font.nunito_italic, weight = FontWeight.W400, style = FontStyle.Normal),
        Font(Res.font.nunito_normal, weight = FontWeight.W600, style = FontStyle.Normal),
        Font(Res.font.nunito_normal, weight = FontWeight.W700, style = FontStyle.Normal),
    ),
    sfProTextFontFamily: FontFamily = FontFamily.Default // fallback, hoặc thêm nếu có file
): Typography = Typography(
    headingBold = CookTypographyTokens.headingBold.copy(
        color = defaultColor,
        fontFamily = poppinsFontFamily
    ),
    h4Bold = CookTypographyTokens.h4Bold.copy(color = defaultColor, fontFamily = poppinsFontFamily),
    h5Bold = CookTypographyTokens.h5Bold.copy(color = defaultColor, fontFamily = poppinsFontFamily),
    paragraphBold = CookTypographyTokens.paragraphBold.copy(
        color = defaultColor,
        fontFamily = poppinsFontFamily
    ),
    paragraphRegular = CookTypographyTokens.paragraphRegular.copy(
        color = defaultColor,
        fontFamily = poppinsFontFamily
    ),
    labelBold = CookTypographyTokens.labelBold.copy(
        color = defaultColor,
        fontFamily = poppinsFontFamily
    ),
    labelRegular = CookTypographyTokens.labelRegular.copy(
        color = defaultColor,
        fontFamily = poppinsFontFamily
    ),
    smallBold = CookTypographyTokens.smallBold.copy(
        color = defaultColor,
        fontFamily = poppinsFontFamily
    ),
    smallRegular = CookTypographyTokens.smallRegular.copy(
        color = defaultColor,
        fontFamily = poppinsFontFamily
    ),
    tinyRegular = CookTypographyTokens.tinyRegular.copy(
        color = defaultColor,
        fontFamily = poppinsFontFamily
    ),
    timeStatusBar = CookTypographyTokens.timeStatusBar.copy(
        color = defaultColor,
        fontFamily = sfProTextFontFamily
    ),
)

object CookTypographyTokens {
    val headingBold = TextStyle(
        fontWeight = FontWeight.W600,
        fontSize = 56.sp,
        lineHeight = (56 * 1.2).sp,
        fontStyle = FontStyle.Normal,
    )
    val h4Bold = TextStyle(
        fontWeight = FontWeight.W600,
        fontSize = 24.sp,
        lineHeight = (24 * 1.2).sp,
        fontStyle = FontStyle.Normal,
    )
    val h5Bold = TextStyle(
        fontWeight = FontWeight.W600,
        fontSize = 20.sp,
        lineHeight = (20 * 1.4).sp,
        fontStyle = FontStyle.Normal,
    )
    val paragraphBold = TextStyle(
        fontWeight = FontWeight.W600,
        fontSize = 16.sp,
        lineHeight = (16 * 1.4).sp,
        fontStyle = FontStyle.Normal,
    )
    val paragraphRegular = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 16.sp,
        lineHeight = (16 * 1.4).sp,
        fontStyle = FontStyle.Normal,
    )
    val labelBold = TextStyle(
        fontWeight = FontWeight.W600,
        fontSize = 14.sp,
        lineHeight = (14 * 1.4).sp,
        fontStyle = FontStyle.Normal,
    )
    val labelRegular = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 14.sp,
        lineHeight = (14 * 1.4).sp,
        fontStyle = FontStyle.Normal,
    )
    val smallBold = TextStyle(
        fontWeight = FontWeight.W600,
        fontSize = 12.sp,
        lineHeight = (12 * 1.5).sp,
        fontStyle = FontStyle.Normal,
    )
    val smallRegular = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 12.sp,
        lineHeight = (12 * 1.5).sp,
        fontStyle = FontStyle.Normal,
    )
    val tinyRegular = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 10.sp,
        lineHeight = (10 * 1.5).sp,
        fontStyle = FontStyle.Normal,
    )
    val timeStatusBar = TextStyle(
        fontWeight = FontWeight.W600,
        fontSize = 15.sp,
        lineHeight = (15 * 1.19).sp,
        fontStyle = FontStyle.Normal,
    )
}

internal val LocalTypography = staticCompositionLocalOf { Typography() }