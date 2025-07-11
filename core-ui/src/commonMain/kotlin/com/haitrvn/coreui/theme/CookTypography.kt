package com.haitrvn.coreui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import cookapp.resources.coreui.Res
import cookapp.resources.coreui.nunito_italic
import cookapp.resources.coreui.nunito_normal
import org.jetbrains.compose.resources.Font

@Immutable
data class CookTypography(
    val heading: TextStyle = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 56.sp,
        lineHeight = 62.sp,
    ),
    val h1: TextStyle = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 46.sp,
        lineHeight = 51.sp,
    ),
    val h2: TextStyle = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp,
        lineHeight = 44.sp,
    ),
    val h3: TextStyle = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 36.sp,
    ),
    val h4: TextStyle = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = 27.sp,
    ),
    val h5: TextStyle = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = 22.sp,
    ),
    val paragraph: TextStyle = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 18.sp,
    ),
    val label: TextStyle = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 16.sp,
    ),
    val small: TextStyle = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 14.sp,
    ),
    val tiny: TextStyle = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp,
        lineHeight = 12.sp,
    ),
) {
    private val fontFamily: FontFamily
        @Composable
        get() = FontFamily(
            Font(Res.font.nunito_normal, FontWeight.Bold),
            Font(Res.font.nunito_italic, FontWeight.Normal),
        )

    companion object {
        @Composable
        fun withFontFamily(): CookTypography {
            return CookTypography().run {
                copy(
                    heading = heading.copy(fontFamily = fontFamily),
                    h1 = h1.copy(fontFamily = fontFamily),
                    h2 = h2.copy(fontFamily = fontFamily),
                    h3 = h3.copy(fontFamily = fontFamily),
                    h4 = h4.copy(fontFamily = fontFamily),
                    h5 = h5.copy(fontFamily = fontFamily),
                    paragraph = paragraph.copy(fontFamily = fontFamily),
                    label = label.copy(fontFamily = fontFamily),
                    small = small.copy(fontFamily = fontFamily),
                    tiny = tiny.copy(fontFamily = fontFamily),
                )
            }
        }
    }
}

fun TextStyle.bold() = copy(fontWeight = FontWeight.Bold)
fun TextStyle.light() = copy(fontWeight = FontWeight.Light)

internal val LocalTypography = staticCompositionLocalOf { CookTypography() }