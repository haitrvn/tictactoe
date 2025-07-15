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
    val header: TextStyle = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp,
        lineHeight = 67.sp,
        fontStyle = FontStyle.Normal,
    ),
    val title: TextStyle = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 28.sp,
        fontStyle = FontStyle.Normal,
    ),
    val subtitle: TextStyle = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = 24.sp,
        fontStyle = FontStyle.Normal,
    ),
    val label: TextStyle = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        lineHeight = 16.sp,
        fontStyle = FontStyle.Normal,
    ),
    val paragraph: TextStyle = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 16.sp,
        fontStyle = FontStyle.Normal,
    ),
    val small: TextStyle = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 14.sp,
        fontStyle = FontStyle.Normal,
    ),
    val smallBold: TextStyle = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        lineHeight = 14.sp,
        fontStyle = FontStyle.Normal,
    ),
    val tiny: TextStyle = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        lineHeight = 12.sp,
        fontStyle = FontStyle.Italic,
    ),
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
                    header = header.copy(fontFamily = fontFamilyNormal),
                    title = title.copy(fontFamily = fontFamilyNormal),
                    subtitle = subtitle.copy(fontFamily = fontFamilyNormal),
                    label = label.copy(fontFamily = fontFamilyNormal),
                    paragraph = paragraph.copy(fontFamily = fontFamilyNormal),
                    small = small.copy(fontFamily = fontFamilyNormal),
                    smallBold = smallBold.copy(fontFamily = fontFamilyNormal),
                    tiny = tiny.copy(fontFamily = fontFamilyNormal),
                )
            }
        }
    }
}

internal val LocalTypography = staticCompositionLocalOf { CookTypography() }