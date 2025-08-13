package com.haitrvn.coreui

import androidx.compose.foundation.Image
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import coil3.compose.rememberAsyncImagePainter

@Composable
fun TextHeader2(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Left,
    color: Color = Color.Black
) {
    Text(text = text, modifier = modifier, fontSize = 30.sp, textAlign = textAlign, color = color)
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