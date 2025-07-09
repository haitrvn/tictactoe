package com.haitrvn.coreui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.haitrvn.coreui.base.CookButton
import com.haitrvn.coreui.theme.CookTheme
import com.haitrvn.coreui.theme.bold
import com.haitrvn.coreui.base.CookText as BaseCookText

@Composable
fun CookTextButton(
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
            style = CookTheme.typography.paragraph.bold(),
            textAlign = TextAlign.Center,
            color = CookTheme.colors.onPrimary
        )
    }
}