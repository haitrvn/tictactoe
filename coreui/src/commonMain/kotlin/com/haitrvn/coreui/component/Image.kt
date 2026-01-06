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
    placeholder: DrawableResource? = null,
    contentScale: ContentScale = ContentScale.Crop,
) {
    val painter = if (source is DrawableResource) {
        painterResource(source)
    } else {
        val placeholderPainter = placeholder?.let { painterResource(it) }
        rememberAsyncImagePainter(
            model = source,
            placeholder = placeholderPainter,
            error = placeholderPainter,
            fallback = placeholderPainter
        )
    }
    Image(
        modifier = modifier,
        painter = painter,
        contentDescription = null,
        contentScale = contentScale,
    )
}

@Composable
fun Image.Circle(
    modifier: Modifier = Modifier,
    source: Any,
    placeholder: DrawableResource? = null
) {
    Image.Normal(
        modifier = modifier.clip(Shapes.circle),
        source = source,
        placeholder = placeholder
    )
}