package com.haitrvn.coreui

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.theme.CookTheme

@Composable
fun CommonButton(
    modifier: Modifier = Modifier,
    shape: Shape = CookTheme.shapes.small,
    backgroundColor: Color = CookTheme.colors.primary,
    contentColor: Color = CookTheme.colors.onPrimary,
    elevation: ButtonElevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 0.dp),
    colors: ButtonColors = buttonColors(
        containerColor = backgroundColor,
        contentColor = contentColor,
        disabledContainerColor = backgroundColor.copy(alpha = 0.20f),
        disabledContentColor = contentColor,
    ),
    enabled: Boolean = true,
    text: String,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
        shape = shape,
        elevation = elevation,
        colors = colors
    ) {
        ProvideTextStyle(value = CookTheme.typography.captionBold) {
            Text(text = text, color = contentColor)
        }
    }
}

@Composable
fun CommonButton(
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    CommonButton(
        modifier = Modifier,
        enabled = enabled,
        text = text,
        onClick = onClick
    )
}

