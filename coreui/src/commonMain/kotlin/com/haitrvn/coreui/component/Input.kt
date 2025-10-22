package com.haitrvn.coreui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.theme.AppColors
import com.haitrvn.coreui.theme.Dimensions
import com.haitrvn.coreui.theme.Shapes
import com.haitrvn.coreui.theme.Typographies
import com.haitrvn.coreui.utils.conditionalClickable
import org.jetbrains.compose.resources.DrawableResource

object Input

@Composable
fun Input.Text(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    enabled: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    maxLines: Int = 1,
    interactionSource: MutableInteractionSource? = null,
    prefixIcon: DrawableResource? = null,
    prefixIconClickable: (() -> Unit)? = null,
    suffixIcon: DrawableResource? = null,
    suffixIconClickable: (() -> Unit)? = null,
    error: String? = null
) {
    Column(modifier = modifier) {
        Box(
            modifier = modifier.border(
                width = 1.dp, color = AppColors.outline, shape = Shapes.rounded
            ).clip(Shapes.rounded).background(AppColors.surface)
                .padding(Dimensions.medium),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (prefixIcon != null) {
                    Image.Normal(
                        modifier = Modifier.size(24.dp).conditionalClickable(prefixIconClickable),
                        source = prefixIcon
                    )
                    TinySpace()
                }
                BasicTextField(
                    modifier = Modifier.weight(1f).fillMaxWidth(),
                    value = value,
                    textStyle = Typographies.paragraphBold.copy(color = AppColors.onSurface),
                    onValueChange = onValueChange,
                    enabled = enabled,
                    keyboardOptions = keyboardOptions,
                    keyboardActions = keyboardActions,
                    visualTransformation = visualTransformation,
                    maxLines = maxLines,
                    interactionSource = interactionSource
                )
                if (suffixIcon != null) {
                    Image.Normal(
                        modifier = Modifier.size(24.dp).conditionalClickable(suffixIconClickable),
                        source = suffixIcon
                    )
                }
            }
        }
        if (error != null) {
            Text.Small(text = error)
        }
    }
}
