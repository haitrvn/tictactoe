package com.haitrvn.coreui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.theme.AppColors
import com.haitrvn.coreui.theme.CookTheme
import com.haitrvn.coreui.theme.Typography
import androidx.compose.ui.graphics.painter.BitmapPainter
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun PreviewAppButton() {
    CookTheme(systemIsDark = false) {
        AppButton(
            text = "Register using email",
            onClick = {}
        )
    }
}

@Composable
@Preview
fun PreviewAppIconButton() {
    CookTheme(systemIsDark = false) {
        AppIconButton(
            icon = ColorPainter(AppColors.primary), // Placeholder
            modifier = Modifier.fillMaxWidth(),
            onClick = {}
        )
    }
}


@Composable
fun AppButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: Painter? = null,
    enabled: Boolean = true,
    containerColor: Color = AppColors.tertiary,
    contentColor: Color = AppColors.onTertiary,
    shape: Shape = RoundedCornerShape(18.dp),
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(52.dp)
            .clip(shape)
            .background(if (enabled) containerColor else containerColor.copy(alpha = 0.5f))
            .clickable(enabled = enabled, onClick = onClick)
            .padding(horizontal = 24.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            if (icon != null) {
                Image(
                    painter = icon,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    colorFilter = ColorFilter.tint(if (enabled) contentColor else contentColor.copy(alpha = 0.5f))
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
            AppText(
                text = text,
                style = Typography.textMediumSmallMedium,
                color = if (enabled) contentColor else contentColor.copy(alpha = 0.5f)
            )
        }
    }
}

@Composable
fun AppIconButton(
    icon: Painter,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    containerColor: Color = AppColors.surface,
    contentColor: Color = AppColors.onSurface,
    shape: Shape = RoundedCornerShape(18.dp),
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(52.dp)
            .clip(shape)
            .background(if (enabled) containerColor else containerColor.copy(alpha = 0.5f))
            .clickable(enabled = enabled, onClick = onClick)
            .padding(horizontal = 24.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = icon,
            contentDescription = null,
            modifier = Modifier.size(30.dp),
            colorFilter = ColorFilter.tint(if (enabled) contentColor else contentColor.copy(alpha = 0.5f))
        )
    }
}
