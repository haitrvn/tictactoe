package com.haitrvn.coreui.base

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.theme.CookTheme

@Composable
internal fun CookTextInput(
    modifier: Modifier = Modifier,
    value: String,
    isPassword: Boolean = false,
    enabled: Boolean = true,
    singleLine: Boolean = true,
    onValueChange: (String) -> Unit,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth(),
        enabled = enabled,
        singleLine = singleLine,
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        shape = RoundedCornerShape(8.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = CookTheme.colors.textPrimary,
            unfocusedBorderColor = CookTheme.colors.textPrimary,
            disabledBorderColor = CookTheme.colors.textPrimary,
            cursorColor = CookTheme.colors.textPrimary,
            focusedTextColor = CookTheme.colors.textPrimary,
            unfocusedTextColor = CookTheme.colors.textPrimary,
        )
    )
}