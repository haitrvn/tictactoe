package com.haitrvn.coreui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.haitrvn.coreui.base.CookButton
import com.haitrvn.coreui.theme.CookTheme
import com.haitrvn.coreui.base.CookText as BaseCookText

@Composable
fun CookPrimaryButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    CookButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        contentPadding = CookTheme.contentPadding.medium,
        shape = CookTheme.shapes.medium,
    ) {
        BaseCookText(
            modifier = modifier,
            text = text,
            style = CookTheme.typography.title,
            textAlign = TextAlign.Center,
            color = CookTheme.colors.onPrimary
        )
    }
}

@Composable
fun CookSecondaryButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {

    CookButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        contentPadding = CookTheme.contentPadding.medium,
        shape = CookTheme.shapes.medium,
        backgroundColor = Color.Transparent
    ) {
        BaseCookText(
            modifier = modifier,
            text = text,
            style = CookTheme.typography.title,
            textAlign = TextAlign.Center,
            color = CookTheme.colors.paragraph
        )
    }
}