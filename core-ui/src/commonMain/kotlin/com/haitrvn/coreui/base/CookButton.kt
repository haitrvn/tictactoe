package com.haitrvn.coreui.base

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.theme.CookTheme

@Composable
fun BaseButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    backgroundColor: Color = CookTheme.colors.primary,
    disabledBackgroundColor: Color = CookTheme.colors.primary,
    cornerRadius: Dp = 12.dp,
    content: @Composable () -> Unit,
) {
    val shape = RoundedCornerShape(cornerRadius)
    val bgColor = if (enabled) backgroundColor else disabledBackgroundColor

    Box(
        modifier = modifier
            .defaultShadow()
            .clip(shape)
            .background(bgColor)
            .clickableWithRipple(onClick = onClick, enabled = enabled)
            .padding(horizontal = 30.dp, vertical = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}

@Composable
fun SecondaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    borderColor: Color = CookTheme.colors.primary,
    disabledBorderColor: Color = CookTheme.colors.primary,
    cornerRadius: Dp = 12.dp,
    borderWidth: Dp = 2.dp,
    content: @Composable () -> Unit,
) {
    val shape = RoundedCornerShape(cornerRadius)
    val color = if (enabled) borderColor else disabledBorderColor

    Box(
        modifier = modifier
            .clip(shape)
            .background(Color.Transparent)
            .border(BorderStroke(borderWidth, color), shape)
            .then(
                if (enabled) {
                    Modifier.clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() }
                    ) { onClick() }
                } else {
                    Modifier
                }
            )
            .padding(horizontal = 16.dp, vertical = 10.dp)
    ) {
        content()
    }
}

@Composable
fun Modifier.defaultShadow(
    shape: Shape = CookTheme.shapes.large,
    elevation: Dp = 6.dp,
    isClip: Boolean = false
): Modifier {
    if (elevation <= 0.dp) return this
    return this.shadow(
        elevation = elevation,
        shape = shape,
        isClip,
    )
}

@Composable
fun Modifier.clickableWithRipple(
    enabled: Boolean,
    contentColor: Color = CookTheme.colors.onPrimary,
    onClick: () -> Unit,
): Modifier {
    val interactionSource = remember { MutableInteractionSource() }
    return if (enabled) {
        this.clickable(
            interactionSource = interactionSource,
            indication = ripple(color = contentColor.copy(alpha = 0.24f)),
            onClick = onClick
        )
    } else {
        this
    }
}