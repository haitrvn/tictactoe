package com.haitrvn.coreui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.haitrvn.coreui.base.CookButton
import com.haitrvn.coreui.theme.CookTheme
import com.haitrvn.coreui.base.CookText as BaseCookText

@Composable
fun Modifier.defaultShadow(
    shape: Shape = CookTheme.shapes.large,
    elevation: Dp = 4.dp,
    isClip: Boolean = true
): Modifier {
    if (elevation == 0.dp) return this
    return this.shadow(elevation = elevation, shape = shape, isClip)
}

@Composable
fun BaseButton(
    modifier: Modifier = Modifier,
    shape: Shape = CookTheme.shapes.large,
    backgroundColor: Color = CookTheme.colors.primary,
    elevation: Dp = 4.dp,
    contentColor: Color = Color.White,
    contentPadding: PaddingValues = PaddingValues(horizontal = 24.dp, vertical = 12.dp),
    enabled: Boolean = true,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = modifier
            .defaultShadow()
            .clip(shape)
            .background(
                color = if (enabled) backgroundColor else backgroundColor.copy(alpha = 0.6f)
            )
            .then(
                if (enabled) {
                    Modifier.clickable(
                        interactionSource = interactionSource,
                        indication = ripple(color = contentColor.copy(alpha = 0.24f)),
                        onClick = onClick
                    )
                } else Modifier
            )
            .padding(contentPadding),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}

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
fun IconTextButton(
    text: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(fontSize = 16.sp),
    iconSpacing: Dp = 8.dp,
    backgroundColor: Color = Color.Blue,
    contentColor: Color = Color.White,
    elevation: Dp = 4.dp,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    BaseButton(
        modifier = modifier,
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        elevation = elevation,
        enabled = enabled,
        onClick = onClick
    ) {
        Row(
            modifier = Modifier.height(IntrinsicSize.Min),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.fillMaxHeight().aspectRatio(1f),
                tint = contentColor
            )
            Spacer(modifier = Modifier.width(iconSpacing))
            Text(
                text = text,
                style = textStyle,
                color = contentColor
            )
        }
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