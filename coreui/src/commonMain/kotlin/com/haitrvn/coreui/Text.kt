package com.haitrvn.coreui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.haitrvn.coreui.theme.CookTheme

object Text

@Composable
fun Text.Header(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Left,
    color: Color = CookTheme.colors.paragraph,
    fontSize: TextUnit = 60.sp,
    fontFamily: FontFamily? = CookTheme.typography.header.fontFamily
) {
    Text(
        text = text,
        modifier = modifier,
        fontSize = fontSize,
        textAlign = textAlign,
        color = color,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
    )
}

@Composable
fun Text.Title(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Left,
    color: Color = Color.Black
) {
    Text(text = text, modifier = modifier, fontSize = 20.sp, textAlign = textAlign, color = color)
}

@Composable
fun Text.Title(
    modifier: Modifier = Modifier,
    string: AnnotatedString,
    textAlign: TextAlign = TextAlign.Left,
    color: Color = Color.Black
) {
    Text(text = string, modifier = modifier, fontSize = 20.sp, textAlign = textAlign, color = color)
}

@Composable
fun Text.Paragraph(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Left,
    color: Color = CookTheme.colors.paragraph
) {
    Text(text = text, modifier = modifier, fontSize = 20.sp, textAlign = textAlign, color = color)
}

@Composable
fun Text.Error(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Left,
    color: Color = Color.Black
) {
    Text(text = text, modifier = modifier, fontSize = 16.sp, textAlign = textAlign, color = color)
}

