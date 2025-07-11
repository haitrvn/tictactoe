package com.haitrvn.coreui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import com.haitrvn.coreui.theme.CookTheme
import com.haitrvn.coreui.base.CookText as BaseCookText

@Composable
fun CookBigHeadTitle(
    modifier: Modifier = Modifier,
    text: String,
    fontStyle: TextStyle = CookTheme.typography.heading,
    color: Color = CookTheme.colors.primary,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = fontStyle,
        textAlign = TextAlign.Center,
        color = color
    )
}

@Composable
fun CookHeadTitle(
    modifier: Modifier = Modifier,
    text: String,
    fontStyle: TextStyle = CookTheme.typography.h4,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = fontStyle,
        textAlign = TextAlign.Center,
    )
}

@Composable
fun CookParagraphText(
    modifier: Modifier = Modifier,
    text: String,
    fontStyle: TextStyle = CookTheme.typography.paragraph,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = fontStyle,
        textAlign = TextAlign.Center,
    )
}

@Composable
fun CookLabelText(
    modifier: Modifier = Modifier,
    text: String,
    fontStyle: TextStyle = CookTheme.typography.label,
    color: Color = CookTheme.colors.textPrimary,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = fontStyle,
        textAlign = TextAlign.Center,
        color = color
    )
}

@Composable
fun CookBodyBoldText(
    modifier: Modifier = Modifier,
    text: String,
    fontStyle: TextStyle = CookTheme.typography.h4,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = fontStyle,
        textAlign = TextAlign.Center,
    )
}