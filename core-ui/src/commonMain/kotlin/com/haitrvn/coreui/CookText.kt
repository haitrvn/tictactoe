package com.haitrvn.coreui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.haitrvn.coreui.theme.CookTheme
import com.haitrvn.coreui.base.CookText as BaseCookText

@Composable
fun TextApp(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = CookTheme.colors.primary,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = CookTheme.typography.app,
        textAlign = TextAlign.Center,
        color = color
    )
}

@Composable
fun HeaderText(
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Start,
    text: String,
    color: Color = CookTheme.colors.paragraph,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = CookTheme.typography.header,
        textAlign = textAlign,
        color = color
    )
}

@Composable
fun TextTitle(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Start,
    color: Color = CookTheme.colors.paragraph,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = CookTheme.typography.title,
        textAlign = textAlign,
        color = color
    )
}

@Composable
fun TextSmallTitle(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Start,
    color: Color = CookTheme.colors.paragraph,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = CookTheme.typography.smallTitle,
        textAlign = textAlign,
        color = color
    )
}

@Composable
fun TextBigTitle(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Start,
    color: Color = CookTheme.colors.paragraph,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = CookTheme.typography.bigTitle,
        textAlign = textAlign,
        color = color
    )
}

@Composable
fun TextParagraph(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Start,
    color: Color = CookTheme.colors.paragraph,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = CookTheme.typography.paragraph,
        textAlign = textAlign,
        color = color
    )
}

@Composable
fun TextError(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Start,
    color: Color = CookTheme.colors.error,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = CookTheme.typography.error,
        textAlign = textAlign,
        color = color
    )
}


@Composable
fun TextSmall(
    modifier: Modifier = Modifier,
    text: AnnotatedString,
    textAlign: TextAlign = TextAlign.Start,
    color: Color = CookTheme.colors.secondParagraph,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = CookTheme.typography.small,
        textAlign = textAlign,
        color = color
    )
}

@Composable
fun TextSmall(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Start,
    color: Color = CookTheme.colors.secondParagraph,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = CookTheme.typography.small,
        textAlign = textAlign,
        color = color
    )
}

@Composable
fun TextTiny(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Start,
    color: Color = CookTheme.colors.secondParagraph,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = CookTheme.typography.tiny,
        textAlign = textAlign,
        color = color
    )
}

