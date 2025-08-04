package com.haitrvn.coreui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import com.haitrvn.coreui.theme.CookTheme
import com.haitrvn.coreui.base.CookText as BaseCookText

@Composable
fun TextApp(
    modifier: Modifier = Modifier,
    text: String,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = CookTheme.typography.app,
        textAlign = TextAlign.Center,
        color = CookTheme.colors.primary
    )
}

@Composable
fun TextHeader(
    modifier: Modifier = Modifier,
    text: String,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = CookTheme.typography.header,
        textAlign = TextAlign.Center,
        color = CookTheme.colors.paragraph
    )
}

@Composable
fun TextTitle(
    modifier: Modifier = Modifier,
    text: String,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = CookTheme.typography.title,
        textAlign = TextAlign.Center,
        color = CookTheme.colors.paragraph
    )
}

@Composable
fun TextSmallTitle(
    modifier: Modifier = Modifier,
    text: String,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = CookTheme.typography.smallTitle,
        textAlign = TextAlign.Center,
        color = CookTheme.colors.paragraph
    )
}

@Composable
fun TextBigTitle(
    modifier: Modifier = Modifier,
    text: String,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = CookTheme.typography.bigTitle,
        textAlign = TextAlign.Center,
        color = CookTheme.colors.paragraph
    )
}

@Composable
fun TextParagraph(
    modifier: Modifier = Modifier,
    text: String,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = CookTheme.typography.paragraph,
        textAlign = TextAlign.Center,
        color = CookTheme.colors.paragraph
    )
}

@Composable
fun TextError(
    modifier: Modifier = Modifier,
    text: String,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = CookTheme.typography.error,
        textAlign = TextAlign.Center,
        color = CookTheme.colors.error
    )
}


@Composable
fun TextSmall(
    modifier: Modifier = Modifier,
    text: AnnotatedString,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = CookTheme.typography.small,
        textAlign = TextAlign.Center,
        color = CookTheme.colors.secondParagraph
    )
}

@Composable
fun TextSmall(
    modifier: Modifier = Modifier,
    text: String,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = CookTheme.typography.small,
        textAlign = TextAlign.Center,
        color = CookTheme.colors.secondParagraph
    )
}

@Composable
fun TextTiny(
    modifier: Modifier = Modifier,
    text: String,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = CookTheme.typography.tiny,
        textAlign = TextAlign.Center,
        color = CookTheme.colors.secondParagraph
    )
}

