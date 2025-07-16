package com.haitrvn.coreui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import com.haitrvn.coreui.theme.CookTheme
import com.haitrvn.coreui.base.CookText as BaseCookText

@Composable
fun CookHeaderText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = CookTheme.colors.primary,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = CookTheme.typography.header,
        textAlign = TextAlign.Center,
        color = color
    )
}

@Composable
fun CookTitleText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = CookTheme.colors.textPrimary,
    style: TextStyle = CookTheme.typography.title,
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
fun CookSubTitleText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = CookTheme.colors.textPrimary,
    style: TextStyle = CookTheme.typography.subtitle,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        textAlign = TextAlign.Center,
        color = color,
        style = style,
    )
}

@Composable
fun CookLabel1Text(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = CookTheme.colors.textPrimary,
    style: TextStyle = CookTheme.typography.label,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = style,
        textAlign = TextAlign.Center,
        color = color
    )
}

@Composable
fun CookParagraphText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = CookTheme.colors.textPrimary,
    style: TextStyle = CookTheme.typography.paragraph,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = style,
        textAlign = TextAlign.Center,
        color = color
    )
}

@Composable
fun CookSmallText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = CookTheme.colors.textPrimary,
    style: TextStyle = CookTheme.typography.small,
    ) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = style,
        textAlign = TextAlign.Center,
        color = color
    )
}

@Composable
fun CookLabel2Text(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = CookTheme.colors.textPrimary,
    style: TextStyle = CookTheme.typography.smallBold,
    ) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = style,
        textAlign = TextAlign.Center,
        color = color
    )
}

@Composable
fun CookTinyText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = CookTheme.colors.textPrimary,
    style: TextStyle = CookTheme.typography.tiny,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = style,
        textAlign = TextAlign.Center,
        color = color
    )
}