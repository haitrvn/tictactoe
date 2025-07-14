package com.haitrvn.coreui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.haitrvn.coreui.theme.CookTheme
import com.haitrvn.coreui.base.CookText as BaseCookText

@Composable
fun CookDisplayText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = CookTheme.colors.primary,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = CookTheme.typography.display,
        textAlign = TextAlign.Center,
        color = color
    )
}

@Composable
fun CookTitleText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = CookTheme.colors.textPrimary,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = CookTheme.typography.title,
        textAlign = TextAlign.Center,
        color = color
    )
}

@Composable
fun CookBodyText(
    modifier: Modifier = Modifier,
    text: String,
    bold: Boolean = false,
    color: Color = CookTheme.colors.textPrimary,
) {
    val style = if (bold) CookTheme.typography.bodyBold else CookTheme.typography.body
    BaseCookText(
        modifier = modifier,
        text = text,
        style = style,
        textAlign = TextAlign.Center,
        color = color
    )
}

@Composable
fun CookLabelText(
    modifier: Modifier = Modifier,
    text: String,
    bold: Boolean = false,
    color: Color = CookTheme.colors.textPrimary,
) {
    val style = if (bold) CookTheme.typography.labelBold else CookTheme.typography.label
    BaseCookText(
        modifier = modifier,
        text = text,
        style = style,
        textAlign = TextAlign.Center,
        color = color
    )
}

@Composable
fun CookCaptionText(
    modifier: Modifier = Modifier,
    text: String,
    bold: Boolean = false,
    color: Color = CookTheme.colors.textPrimary,
) {
    val style = if (bold) CookTheme.typography.captionBold else CookTheme.typography.caption
    BaseCookText(
        modifier = modifier,
        text = text,
        style = style,
        textAlign = TextAlign.Center,
        color = color
    )
}