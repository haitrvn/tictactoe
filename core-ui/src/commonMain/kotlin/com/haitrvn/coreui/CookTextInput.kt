package com.haitrvn.coreui

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import com.haitrvn.coreui.theme.CookTheme
import cookapp.resources.coreui.Res
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
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
        modifier = modifier.background(background),
        cursorBrush = SolidColor(textStyle.color),
    )
}

@Composable
fun AuthInput(
    modifier: Modifier = Modifier.fillMaxWidth(),
    value: String,
    label: String,
    onValueChange: (String) -> Unit,
) {
    val focusRequester = remember { FocusRequester() }
    var isFocused by remember { mutableStateOf(false) }

    CookRoundSurface(
        modifier = modifier.clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null
        ) {
            focusRequester.requestFocus()
        },
        color = CookTheme.colors.background2,
        paddingValues = CookTheme.contentPadding.medium,
    ) {
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Column {
                TextSmall(text = label)
                CookBasicTextField(
                    value = value, onValueChange = onValueChange,
                    modifier = Modifier.focusRequester(focusRequester)
                )
            }
            Icon(
                imageVector = vectorResource(Res.drawable.core_ui_icon_back),
                contentDescription = null
            )
        }
    }
}