package com.haitrvn.coreui

import androidx.compose.foundation.Image
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.sp
import coil3.compose.rememberAsyncImagePainter

@Composable
fun TextHeader(
    modifier: Modifier = Modifier,
    text: String,
) {
    Text(text, fontSize = 30.sp)
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