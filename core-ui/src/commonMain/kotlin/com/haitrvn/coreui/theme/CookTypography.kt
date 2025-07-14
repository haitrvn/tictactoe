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
    val display: TextStyle = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 56.sp,
        lineHeight = 67.sp, // 120%
    ),
    val title: TextStyle = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 38.sp, // 120%
    ),
    val body: TextStyle = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 22.sp, // 140%
    ),
    val bodyBold: TextStyle = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 22.sp, // 140%
    ),
    val label: TextStyle = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp, // 140%
    ),
    val labelBold: TextStyle = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        lineHeight = 20.sp, // 140%
    ),
    val caption: TextStyle = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 18.sp, // 150%
    ),
    val captionBold: TextStyle = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        lineHeight = 18.sp, // 150%
    ),
) {
    private val fontFamilyNormal: FontFamily
        @Composable
        get() = FontFamily(
            Font(Res.font.nunito_normal, FontWeight.Normal),
        )
    private val fontFamilyItalic: FontFamily
        @Composable
        get() = FontFamily(
            Font(Res.font.nunito_italic, FontWeight.Bold),
        )

    companion object {
        @Composable
        fun withFontFamily(): CookTypography {
            return CookTypography().run {
                copy(
                    display = display.copy(fontFamily = fontFamilyNormal),
                    title = title.copy(fontFamily = fontFamilyNormal),
                    body = body.copy(fontFamily = fontFamilyNormal),
                    bodyBold = bodyBold.copy(fontFamily = fontFamilyNormal),
                    label = label.copy(fontFamily = fontFamilyItalic),
                    labelBold = labelBold.copy(fontFamily = fontFamilyItalic),
                    caption = caption.copy(fontFamily = fontFamilyItalic),
                    captionBold = captionBold.copy(fontFamily = fontFamilyItalic),
                )
            }
        }
    }
}

internal val LocalTypography = staticCompositionLocalOf { CookTypography() }