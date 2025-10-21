package com.haitrvn.coreui.component

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import coil3.compose.rememberAsyncImagePainter
import com.haitrvn.coreui.theme.Shapes
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

object Image

@Composable
fun Image.Normal(
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

@Composable
fun Image.Circle(modifier: Modifier = Modifier, source: Any) {
    Image.Normal(modifier.clip(Shapes.circle), source = source)
}