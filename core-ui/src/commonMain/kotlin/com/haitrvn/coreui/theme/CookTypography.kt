package com.haitrvn.coreui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is CookTypography) return false
        if (app != other.app) return false
        if (header != other.header) return false
        if (bigTitle != other.bigTitle) return false
        if (title != other.title) return false
        if (smallTitle != other.smallTitle) return false
        if (paragraph != other.paragraph) return false
        if (error != other.error) return false
        if (small != other.small) return false
        if (tiny != other.tiny) return false
        return true
    }

    override fun hashCode(): Int {
        var result = app.hashCode()
        result = 31 * result + header.hashCode()
        result = 31 * result + bigTitle.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + smallTitle.hashCode()
        result = 31 * result + paragraph.hashCode()
        result = 31 * result + error.hashCode()
        result = 31 * result + small.hashCode()
        result = 31 * result + tiny.hashCode()
        return result
    }

    override fun toString(): String {
        return "CookTypography(app=$app, header=$header, bigTitle=$bigTitle, title=$title, smallTitle=$smallTitle, paragraph=$paragraph, error=$error, small=$small, tiny=$tiny)"
    }

    fun fromColors(
        defaultColor: androidx.compose.ui.graphics.Color,
        app: TextStyle = CookTypographyTokens.app.copy(color = defaultColor),
        header: TextStyle = CookTypographyTokens.header.copy(color = defaultColor),
        bigTitle: TextStyle = CookTypographyTokens.bigTitle.copy(color = defaultColor),
        title: TextStyle = CookTypographyTokens.title.copy(color = defaultColor),
        smallTitle: TextStyle = CookTypographyTokens.smallTitle.copy(color = defaultColor),
        paragraph: TextStyle = CookTypographyTokens.paragraph.copy(color = defaultColor),
        error: TextStyle = CookTypographyTokens.error.copy(color = defaultColor),
        small: TextStyle = CookTypographyTokens.small.copy(color = defaultColor),
        tiny: TextStyle = CookTypographyTokens.tiny.copy(color = defaultColor),
    ): CookTypography = CookTypography(
        app = app,
        header = header,
        bigTitle = bigTitle,
        title = title,
        smallTitle = smallTitle,
        paragraph = paragraph,
        error = error,
        small = small,
        tiny = tiny,
    )
}

internal val LocalTypography = staticCompositionLocalOf { CookTypography() }


object CookTypographyTokens {
    val app = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,        // từ 40 → 32
        lineHeight = 40.sp,      // từ 44 → 40
        fontStyle = FontStyle.Normal,
    )

    val header = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,        // từ 26 → 24
        lineHeight = 32.sp,
        fontStyle = FontStyle.Normal,
    )

    val bigTitle = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,        // từ 24 → 20
        lineHeight = 28.sp,      // giữ nguyên
        fontStyle = FontStyle.Normal,
    )

    val title = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,        // từ 20 → 18
        lineHeight = 24.sp,
        fontStyle = FontStyle.Normal,
    )

    val smallTitle = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,        // giữ nguyên
        lineHeight = 24.sp,      // từ 18 → 24
        fontStyle = FontStyle.Normal,
    )

    val paragraph = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,      // từ 16 → 20 (giúp dễ đọc hơn)
        fontStyle = FontStyle.Normal,
    )

    val error = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,        // từ 10 → 12
        lineHeight = 16.sp,      // từ 12 → 16
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
        lineHeight = 14.sp,      // từ 16 → 14 (cho cân đối hơn)
        fontStyle = FontStyle.Normal,
    )
}