package com.haitrvn.coreui.component

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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.theme.AppColors
import com.haitrvn.coreui.theme.Dimensions
import com.haitrvn.coreui.theme.Shapes

object Button

@Composable
fun Button.Filled(
    modifier: Modifier = Modifier,
    text: String,
    backgroundColor: Color = AppColors.primary,
    verticalPadding: Dp = Dimensions.small,
    horizontalPadding: Dp = Dimensions.small * 1.5f,
    content: @Composable () -> Unit = { Text.ParagraphBold(text = text, color = AppColors.onPrimary) },
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier.clip(Shapes.rounded)
            .background(backgroundColor).then(modifier)
            .padding(horizontal = horizontalPadding, vertical = verticalPadding)
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
fun Button.Outlined(
    modifier: Modifier = Modifier,
    text: String,
    outline: Color = AppColors.outline,
    verticalPadding: Dp = Dimensions.small,
    horizontalPadding: Dp = Dimensions.small * 1.5f,
    content: @Composable () -> Unit = { Text.ParagraphBold(text = text, color = AppColors.primary) },
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier.clip(Shapes.rounded)
            .border(2.dp, outline, Shapes.rounded)
            .padding(horizontal = horizontalPadding, vertical = verticalPadding)
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
fun Button.Text(
    modifier: Modifier = Modifier,
    text: String,
    backgroundColor: Color = AppColors.primary,
    verticalPadding: Dp = Dimensions.small,
    horizontalPadding: Dp = Dimensions.small * 1.5f,
    content: @Composable () -> Unit = { Text.ParagraphBold(text = text, color = backgroundColor) },
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier.clip(Shapes.rounded)
            .padding(horizontal = horizontalPadding, vertical = verticalPadding)
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