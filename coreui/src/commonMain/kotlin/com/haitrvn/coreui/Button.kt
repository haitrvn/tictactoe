package com.haitrvn.coreui

import androidx.compose.foundation.Indication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.theme.AppColors
import com.haitrvn.coreui.theme.Shapes
import com.haitrvn.coreui.theme.Space

object Button

@Composable
internal fun BaseButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    shape: Shape,
    backgroundColor: Color = AppColors.primary,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    indication: Indication? = null,
    content: @Composable () -> Unit,
) {

}

@Composable
fun Button.Primary(
    modifier: Modifier = Modifier,
    text: String,
    backgroundColor: Color = AppColors.primary,
    padding: Dp = Space.small,
    content: @Composable () -> Unit = { Text.ParagraphBold(text = text) },
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier.clip(Shapes.rounded)
            .background(backgroundColor).then(modifier)
            .padding(padding)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center,
    ) {
        content()
    }
}

@Composable
fun Button.Secondary(
    modifier: Modifier = Modifier,
    text: String,
    backgroundColor: Color = AppColors.primary,
    padding: Dp = Space.small,
    content: @Composable () -> Unit = { Text.ParagraphBold(text = text, color = backgroundColor) },
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier.clip(Shapes.rounded)
            .border(2.dp, backgroundColor, Shapes.rounded)
            .padding(padding)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center,
    ) {
        content()
    }
}

@Composable
fun Button.Tertiary(
    modifier: Modifier = Modifier,
    text: String,
    backgroundColor: Color = AppColors.tertiary,
    padding: Dp = Space.small,
    content: @Composable () -> Unit = { Text.ParagraphBold(text = text, color = backgroundColor) },
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier.clip(Shapes.rounded)
            .padding(padding)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center,
    ) {
        content()
    }
}