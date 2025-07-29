package com.haitrvn.coreui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.haitrvn.coreui.theme.CookTheme
import cookapp.resources.coreui.Res
import cookapp.resources.coreui.core_ui_icon_back
import org.jetbrains.compose.resources.vectorResource
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

@Composable
fun EmailInputField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    isValid: Boolean = false,
    textStyle: TextStyle = CookTheme.typography.paragraph
) {
    val shape = RoundedCornerShape(50) // bo góc oval
    val background = Color(0xFFF5F5F5) // màu xám nhạt

    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        textStyle = textStyle,
        modifier = modifier
            .clip(shape)
            .background(background)
            .padding(CookTheme.contentPadding.medium),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    TextSmall(text = "Email address")
                    innerTextField()
                }

                if (isValid) {
                    Icon(
                        imageVector = vectorResource(Res.drawable.core_ui_icon_back),
                        contentDescription = "Valid",
                        tint = Color(0xFF4CAF50),
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .size(20.dp)
                    )
                }
            }
        }
    )
}
