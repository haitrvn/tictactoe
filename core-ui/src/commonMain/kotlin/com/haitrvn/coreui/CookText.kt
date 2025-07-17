package com.haitrvn.coreui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withLink
import com.haitrvn.coreui.theme.CookTheme
import com.haitrvn.coreui.base.CookText as BaseCookText

@Composable
fun CookHeaderText(
    modifier: Modifier = Modifier,
    text: String,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = CookTheme.typography.header,
        textAlign = TextAlign.Center,
        color = CookTheme.colors.primary
    )
}

@Composable
fun CookTitleText(
    modifier: Modifier = Modifier,
    text: String,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = CookTheme.typography.title,
        textAlign = TextAlign.Center,
        color = CookTheme.colors.textPrimary
    )
}

@Composable
fun CookSubTitleText(
    modifier: Modifier = Modifier,
    text: String,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        textAlign = TextAlign.Center,
        color = CookTheme.colors.textPrimary,
        style = CookTheme.typography.subtitle,
    )
}

@Composable
fun CookLabel1Text(
    modifier: Modifier = Modifier,
    text: String,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = CookTheme.typography.label,
        textAlign = TextAlign.Center,
        color = CookTheme.colors.textPrimary
    )
}

@Composable
fun CookParagraphText(
    modifier: Modifier = Modifier,
    text: String,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = CookTheme.typography.paragraph,
        textAlign = TextAlign.Center,
        color = CookTheme.colors.textPrimary
    )
}

@Composable
fun CookSmallText(
    modifier: Modifier = Modifier,
    text: String,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = CookTheme.typography.small,
        textAlign = TextAlign.Center,
        color = CookTheme.colors.textPrimary
    )
}

@Composable
fun CookSmallText(
    modifier: Modifier = Modifier,
    text: AnnotatedString,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = CookTheme.typography.small,
        textAlign = TextAlign.Center,
        color = CookTheme.colors.textPrimary
    )
}

@Composable
fun CookLabel2Text(
    modifier: Modifier = Modifier,
    text: String,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = CookTheme.typography.smallBold,
        textAlign = TextAlign.Center,
        color = CookTheme.colors.textPrimary
    )
}

@Composable
fun CookTinyText(
    modifier: Modifier = Modifier,
    text: String,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = CookTheme.typography.tiny,
        textAlign = TextAlign.Center,
        color = CookTheme.colors.textPrimary
    )
}