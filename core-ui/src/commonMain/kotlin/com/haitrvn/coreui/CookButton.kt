package com.haitrvn.coreui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.base.BaseButton
import com.haitrvn.coreui.base.BaseSecondaryButton
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
fun CookSecondaryButton(
    text: String,
    modifier: Modifier = Modifier.fillMaxWidth(),
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    BaseSecondaryButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
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

@Composable
fun SocialButton(
    modifier: Modifier = Modifier,
    text: String,
    icon: DrawableResource,
    textColor: Color = CookTheme.colors.onPrimary,
    background: Color = CookTheme.colors.primary,
    onClick: () -> Unit,
) {
    BaseButton(modifier = modifier, onClick = onClick, backgroundColor = background) {
        Row(
            modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Min),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CookImage(
                modifier = Modifier.heightIn(max = CookTheme.typography.title.fontSize.value.dp * 1.2f),
                painter = painterResource(icon),
                contentScale = ContentScale.Fit
            )
            CookSpace(SpaceSize.SMALL)
            BaseCookText(
                text = text,
                style = CookTheme.typography.title,
                textAlign = TextAlign.Center,
                color = textColor
            )
        }
    }
}