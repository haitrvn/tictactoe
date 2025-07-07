package com.haitrvn.coreui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.haitrvn.coreui.theme.CookTheme
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

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
            .border(1.dp, CookTheme.colors.textPrimary, RoundedCornerShape(8.dp))
            .background(CookTheme.colors.textPrimary, RoundedCornerShape(8.dp))
            .padding(12.dp),
        enabled = enabled,
        singleLine = singleLine,
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        decorationBox = { innerTextField ->
            Box(Modifier.fillMaxWidth()) {
                if (value.isEmpty()) {
                    CommonText(text = placeholder, color = CookTheme.colors.textPrimary)
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
    color: Color = CookTheme.colors.textPrimary,
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
    color: Color = CookTheme.colors.textPrimary,
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
        maxLines = maxLines
    )
}

@Composable
fun CommonImage(
    modifier: Modifier = Modifier,
    imageResId: DrawableResource,
    contentDescription: String? = null,
    contentScale: ContentScale = ContentScale.Crop
) {
    Image(
        painter = painterResource(imageResId),
        contentDescription = contentDescription,
        modifier = modifier,
        contentScale = contentScale
    )
}

@Composable
fun CommonBackground(
    modifier: Modifier = Modifier,
    imageResId: DrawableResource,
    contentDescription: String? = null,
    contentScale: ContentScale = ContentScale.Crop,
    content: @Composable BoxScope.() -> Unit
) {
    Box(modifier = modifier) {
        CommonImage(
            imageResId = imageResId,
            contentDescription = contentDescription,
            modifier = Modifier.matchParentSize(),
            contentScale = contentScale
        )
        content()
    }
}