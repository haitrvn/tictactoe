package com.haitrvn.coreui

import androidx.compose.foundation.Indication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import com.haitrvn.coreui.theme.CookTheme

object Button

@Composable
internal fun BaseButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    shape: Shape,
    backgroundColor: Color = CookTheme.colors.primary,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    indication: Indication? = null,
    content: @Composable () -> Unit,
) {
    Box(
        modifier = Modifier.clip(shape).background(backgroundColor).then(modifier).clickable(
            interactionSource = interactionSource, indication = indication, onClick = onClick
        ),
        contentAlignment = Alignment.Center,
    ) {
        content()
    }
}

@Composable
fun Button.Float(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    content: @Composable () -> Unit,
) {
    BaseButton(
        modifier = modifier,
        shape = CircleShape,
        onClick = onClick,
    ) {
        content()
    }
}

@Composable
fun Button.Float(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit = {},
) {
    BaseButton(
        modifier = modifier,
        shape = CircleShape,
        onClick = onClick,
    ) {
        Text.Title(text = text)
    }
}

@Composable
fun Button.Curved(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    backgroundColor: Color = CookTheme.colors.primary,
    content: @Composable () -> Unit,
) {
    BaseButton(
        modifier = modifier.wrapContentSize().padding(CookTheme.space.medium),
        shape = CookTheme.shapes.medium,
        onClick = onClick,
        backgroundColor = backgroundColor,
    ) {
        content()
    }
}

@Composable
fun Button.Curved(
    modifier: Modifier = Modifier,
    backgroundColor: Color = CookTheme.colors.primary,
    text: String,
    onClick: () -> Unit,
) {
    BaseButton(
        modifier = modifier.padding(CookTheme.space.medium),
        shape = CookTheme.shapes.medium,
        onClick = onClick,
        backgroundColor = backgroundColor,
    ) {
        Text.Title(text = text)
    }
}