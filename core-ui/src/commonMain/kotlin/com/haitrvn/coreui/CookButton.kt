package com.haitrvn.coreui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.haitrvn.coreui.base.CookButton
import com.haitrvn.coreui.base.CookOutlineButton
import com.haitrvn.coreui.theme.CookTheme
import com.haitrvn.coreui.base.CookText as BaseCookText

@Composable
fun CookBigPrimaryButton(
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
            style = CookTheme.typography.subtitle,
            textAlign = TextAlign.Center,
            color = CookTheme.colors.onPrimary
        )
    }
}

@Composable
fun CookSmallPrimaryButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    CookButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
    ) {
        BaseCookText(
            modifier = modifier,
            text = text,
            style = CookTheme.typography.label,
            textAlign = TextAlign.Center,
            color = CookTheme.colors.onPrimary
        )
    }
}

@Composable
fun CookBigSecondaryButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    CookOutlineButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        contentPadding = CookTheme.contentPadding.medium,
        shape = CookTheme.shapes.medium,
    ) {
        BaseCookText(
            modifier = modifier,
            text = text,
            style = CookTheme.typography.subtitle,
            textAlign = TextAlign.Center,
            color = CookTheme.colors.primary
        )
    }
}

@Composable
fun CookSmallSecondaryButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    CookOutlineButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
    ) {
        BaseCookText(
            modifier = modifier,
            text = text,
            style = CookTheme.typography.label,
            textAlign = TextAlign.Center,
            color = CookTheme.colors.primary
        )
    }
}