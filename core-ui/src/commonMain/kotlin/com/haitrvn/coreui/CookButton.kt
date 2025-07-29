package com.haitrvn.coreui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.haitrvn.coreui.base.BaseButton
import com.haitrvn.coreui.theme.CookTheme
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import com.haitrvn.coreui.base.CookText as BaseCookText

@Composable
fun CookPrimaryButton(
    text: String,
    modifier: Modifier = Modifier.fillMaxWidth(),
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    BaseButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
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
fun SocialButton(
    modifier: Modifier = Modifier,
    text: String,
    icon: DrawableResource,
    onClick: () -> Unit,
) {
    BaseButton(modifier = modifier, onClick = onClick) {
        Row(
            modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min),
            horizontalArrangement = Arrangement.Center,
        ) {
            CookImage(painter = painterResource(icon))
            CookSpace(SpaceSize.MEDIUM)
            BaseCookText(
                text = text,
                style = CookTheme.typography.title,
                textAlign = TextAlign.Center,
                color = CookTheme.colors.onPrimary
            )
        }
    }
}