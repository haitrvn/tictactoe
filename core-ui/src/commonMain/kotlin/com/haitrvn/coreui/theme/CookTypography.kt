package com.haitrvn.coreui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import cookapp.resources.coreui.Res
import cookapp.resources.coreui.nunito_italic
import cookapp.resources.coreui.nunito_normal
import org.jetbrains.compose.resources.Font

@Immutable
data class CookTypography(
    val app: TextStyle = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 36.sp,
        lineHeight = 40.sp,
        fontStyle = FontStyle.Normal,
    ),
    val header: TextStyle = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        lineHeight = 26.sp,
        fontStyle = FontStyle.Normal,
    ),
    val subHeader: TextStyle = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        lineHeight = 20.sp,
        fontStyle = FontStyle.Normal,
    ),
    val bigTitle: TextStyle = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        lineHeight = 22.sp,
        fontStyle = FontStyle.Normal,
    ),
    val title: TextStyle = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        lineHeight = 20.sp,
        fontStyle = FontStyle.Normal,
    ),
    val smallTitle: TextStyle = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 18.sp,
        fontStyle = FontStyle.Normal,
    ),
    val paragraph: TextStyle = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 18.sp,
        fontStyle = FontStyle.Normal,
    ),
    val error: TextStyle = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 16.sp,
        fontStyle = FontStyle.Normal,
    ),
    val small: TextStyle = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 16.sp,
        fontStyle = FontStyle.Normal,
    ),
    val tiny: TextStyle = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        lineHeight = 16.sp,
        fontStyle = FontStyle.Normal,
    )
) {
    private val fontFamilyNormal: FontFamily
        @Composable
        get() = FontFamily(
            Font(Res.font.nunito_normal, FontWeight.Normal),
            Font(Res.font.nunito_italic, FontWeight.Normal),
        )

    companion object {
        @Composable
        fun withFontFamily(): CookTypography {
            return CookTypography().run {
                copy(
//                    app = app.copy(fontFamily = fontFamilyNormal),
//                    header = header.copy(fontFamily = fontFamilyNormal),
//                    subHeader = subHeader.copy(fontFamily = fontFamilyNormal),
//                    title = title.copy(fontFamily = fontFamilyNormal),
//                    smallTitle = smallTitle.copy(fontFamily = fontFamilyNormal),
//                    bigTitle = bigTitle.copy(fontFamily = fontFamilyNormal),
//                    paragraph = paragraph.copy(fontFamily = fontFamilyNormal),
//                    description = description.copy(fontFamily = fontFamilyNormal),
//                    error = error.copy(fontFamily = fontFamilyNormal),
//                    small = small.copy(fontFamily = fontFamilyNormal),
//                    tiny = tiny.copy(fontFamily = fontFamilyNormal),
                )
            }
        }
    }
}

internal val LocalTypography = staticCompositionLocalOf { CookTypography() }