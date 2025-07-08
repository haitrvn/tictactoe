package com.haitrvn.coreui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.haitrvn.coreui.base.CookTextInput as BaseCookTextInput

@Composable
fun CookTextInput(
    modifier: Modifier = Modifier,
    value: String,
    isPassword: Boolean = false,
    enabled: Boolean = true,
    singleLine: Boolean = true,
    onValueChange: (String) -> Unit,
) {
    BaseCookTextInput(
        modifier = modifier,
        value = value,
        isPassword = isPassword,
        enabled = enabled,
        singleLine = singleLine,
        onValueChange = onValueChange,
    )
}