package com.haitrvn.coreui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CommonTextField(
    modifier: Modifier = Modifier,
    value: String,
    placeholder: String = "",
    isPassword: Boolean = false,
    enabled: Boolean = true,
    singleLine: Boolean = true,
    onValueChange: (String) -> Unit,
) {
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
            .background(Color.White, RoundedCornerShape(8.dp))
            .padding(12.dp),
        enabled = enabled,
        singleLine = singleLine,
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        decorationBox = { innerTextField ->
            Box(Modifier.fillMaxWidth()) {
                if (value.isEmpty()) {
                    CommonText(text = placeholder, color = Color.Gray)
                }
                innerTextField()
            }
        }
    )
}

@Composable
fun CommonTextField(
    value: String,
    placeholder: String = "",
    isPassword: Boolean = false,
    enabled: Boolean = true,
    singleLine: Boolean = true,
    onValueChange: (String) -> Unit,
) {
    CommonTextField(
        modifier = Modifier,
        value = value,
        placeholder = placeholder,
        isPassword = isPassword,
        enabled = enabled,
        singleLine = singleLine,
        onValueChange = onValueChange
    )
}


@Composable
fun CommonText(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: TextUnit = 16.sp,
    fontWeight: FontWeight = FontWeight.Normal,
    color: Color = Color.Black,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
) {
    Text(
        text = text,
        modifier = modifier,
        fontSize = fontSize,
        fontWeight = fontWeight,
        color = color,
        textAlign = textAlign,
        maxLines = maxLines,
    )
}

@Composable
fun CommonText(
    text: String,
    fontSize: TextUnit = 16.sp,
    fontWeight: FontWeight = FontWeight.Normal,
    color: Color = Color.Black,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
) {
    CommonText(
        modifier = Modifier,
        text = text,
        fontSize = fontSize,
        fontWeight = fontWeight,
        color = color,
        textAlign = textAlign,
        maxLines = maxLines)
}

@Composable
fun CommonButton(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: String,
    onClick: () -> Unit,
) {
    // Dùng Box và clickable thay cho Button Material
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(if (enabled) Color(0xFF4682B4) else Color.Gray)
            .clickable(enabled = enabled, onClick = onClick)
            .padding(vertical = 12.dp, horizontal = 20.dp),
        contentAlignment = Alignment.Center
    ) {
        CommonText(
            text = text,
            color = Color.White,
            fontWeight = FontWeight.Bold,
        )
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
