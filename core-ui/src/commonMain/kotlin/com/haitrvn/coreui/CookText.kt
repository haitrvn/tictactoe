package com.haitrvn.coreui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import com.haitrvn.coreui.theme.CookTheme
import com.haitrvn.coreui.base.CookText as BaseCookText

@Composable
fun CookTitleText(
    modifier: Modifier = Modifier,
    text: String,
    fontStyle: TextStyle = CookTheme.typography.title1,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = fontStyle,
        textAlign = TextAlign.Center,
    )
}

@Composable
fun CookBodyText(
    modifier: Modifier = Modifier,
    text: String,
    fontStyle: TextStyle = CookTheme.typography.body1,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = fontStyle,
        textAlign = TextAlign.Center,
    )
}

@Composable
fun CookBodyBoldText(
    modifier: Modifier = Modifier,
    text: String,
    fontStyle: TextStyle = CookTheme.typography.body1Bold,
) {
    BaseCookText(
        modifier = modifier,
        text = text,
        style = fontStyle,
        textAlign = TextAlign.Center,
    )
}