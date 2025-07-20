package com.haitrvn.coreui.base

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.theme.CookTheme

@Composable
internal fun CookButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = CookTheme.shapes.small,
    backgroundColor: Color = CookTheme.colors.primary,
    contentColor: Color = CookTheme.colors.onPrimary,
    elevation: ButtonElevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 0.dp),
    colors: ButtonColors = buttonColors(
        containerColor = backgroundColor,
        contentColor = contentColor,
        disabledContainerColor = backgroundColor.copy(alpha = 0.2f),
        disabledContentColor = contentColor,
    ),
    contentPadding: PaddingValues = CookTheme.contentPadding.small,
    enabled: Boolean = true,
    content: @Composable RowScope.() -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    Box(
        modifier = modifier
            .padding(CookTheme.contentPadding.default)
            .clip(shape)
            .background(backgroundColor)
            .then(
                if (enabled) {
                    Modifier
                        .clickable(
                            interactionSource = interactionSource,
                            indication = ripple(),
                            onClick = onClick
                        )
                } else Modifier
            )
            .padding(contentPadding),
        contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            content = content
        )
    }
}