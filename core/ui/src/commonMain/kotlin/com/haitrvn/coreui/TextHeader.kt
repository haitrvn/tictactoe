package com.haitrvn.coreui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import coil3.compose.rememberAsyncImagePainter
import com.haitrvn.coreui.theme.CookTheme

@Composable
fun HeaderText(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Left,
    color: Color = Color.Black,
    fontSize: TextUnit = 30.sp
) {
    Text(
        text = text,
        modifier = modifier.clickable{},
        fontSize = fontSize,
        textAlign = textAlign,
        color = color,
        fontFamily = CookTheme.typography.header.fontFamily,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
    )
}

@Composable
fun TextTitle2(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Left,
    color: Color = Color.Black
) {
    Text(text = text, modifier = modifier, fontSize = 20.sp, textAlign = textAlign, color = color)
}

@Composable
fun TextParagraph2(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Left,
    color: Color = Color.Black
) {
    Text(text = text, modifier = modifier, fontSize = 16.sp, textAlign = textAlign, color = color)
}

@Composable
fun ImageRecipe(
    modifier: Modifier = Modifier,
    source: Any,
    contentScale: ContentScale = ContentScale.Crop,
) {
    val painter = rememberAsyncImagePainter(source)
    Image(
        modifier = modifier,
        painter = painter,
        contentDescription = null,
        contentScale = contentScale,
    )
}