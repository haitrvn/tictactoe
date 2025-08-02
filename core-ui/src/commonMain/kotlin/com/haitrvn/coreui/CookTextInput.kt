package com.haitrvn.coreui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.haitrvn.coreui.theme.CookTheme
import cookapp.resources.coreui.Res
import cookapp.resources.coreui.core_ui_icon_back
import org.jetbrains.compose.resources.vectorResource


@Composable
fun CookBasicTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "",
    textStyle: TextStyle = CookTheme.typography.paragraph,
    background: Color = CookTheme.colors.background2,
    singleLine: Boolean = true,
    enabled: Boolean = true,
) {
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = singleLine,
        textStyle = textStyle,
        enabled = enabled,
        modifier = modifier.background(background)
    )
}

@Composable
fun AuthInput(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
) {
    CookRoundSurface(
        color = Color.Red,
        modifier = modifier, paddingValues = CookTheme.contentPadding.medium
    ) {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Column {
                TextSmall(text = "label")
                CookBasicTextField(value = value, onValueChange = onValueChange)
            }
            Icon(
                imageVector = vectorResource(Res.drawable.core_ui_icon_back),
                contentDescription = null
            )
        }
    }
}