package com.haitrvn.coreui

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil3.compose.rememberAsyncImagePainter
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun CookImage(
    modifier: Modifier = Modifier,
    source: Any,
    contentScale: ContentScale = ContentScale.Crop,
) {
    val painter = if (source is DrawableResource) {
        painterResource(source)
    } else {
        rememberAsyncImagePainter(source)
    }
    Image(
        modifier = modifier,
        painter = painter,
        contentDescription = null,
        contentScale = contentScale,
    )
}