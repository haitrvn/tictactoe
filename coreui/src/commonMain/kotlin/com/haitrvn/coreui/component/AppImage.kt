package com.haitrvn.coreui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.haitrvn.coreui.imageloader.initImageLoader
import com.haitrvn.coreui.imageloader.initPreviewImageLoader
import com.haitrvn.coreui.theme.CookTheme
import cookapp.resources.core.ui.Res
import cookapp.resources.core.ui.icon_star
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun AppImage(
    painter: Painter,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
    placeholder: Painter? = null,
    error: Painter? = null,
) {
    AsyncImage(
        model = painter,
        contentDescription = contentDescription,
        modifier = modifier,
        alignment = alignment,
        contentScale = contentScale,
        alpha = alpha,
        colorFilter = colorFilter,
        placeholder = placeholder,
        error = error
    )
}

@Composable
fun AppImage(
    imageVector: ImageVector,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
    placeholder: Painter? = null,
    error: Painter? = null,
) {
    AsyncImage(
        model = imageVector,
        contentDescription = contentDescription,
        modifier = modifier,
        alignment = alignment,
        contentScale = contentScale,
        alpha = alpha,
        colorFilter = colorFilter,
        placeholder = placeholder,
        error = error
    )
}

@Composable
fun AppImage(
    bitmap: ImageBitmap,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
    placeholder: Painter? = null,
    error: Painter? = null,
) {
    AsyncImage(
        model = bitmap,
        contentDescription = contentDescription,
        modifier = modifier,
        alignment = alignment,
        contentScale = contentScale,
        alpha = alpha,
        colorFilter = colorFilter,
        placeholder = placeholder,
        error = error
    )
}

@Composable
fun AppImage(
    url: String?,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
    placeholder: Painter? = null,
    error: Painter? = null,
) {
    AsyncImage(
        model = url,
        contentDescription = contentDescription,
        modifier = modifier,
        alignment = alignment,
        contentScale = contentScale,
        alpha = alpha,
        colorFilter = colorFilter,
        placeholder = placeholder,
        error = error
    )
}

@Composable
fun AppImage(
    resource: DrawableResource,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    alignment: Alignment = Alignment.Center,
    contentScale: ContentScale = ContentScale.Fit,
    alpha: Float = DefaultAlpha,
    colorFilter: ColorFilter? = null,
    placeholder: Painter? = null,
    error: Painter? = null,
) {
    AsyncImage(
        model = resource,
        contentDescription = contentDescription,
        modifier = modifier,
        alignment = alignment,
        contentScale = contentScale,
        alpha = alpha,
        colorFilter = colorFilter,
        placeholder = placeholder,
        error = error
    )
}

@Composable
@Preview
fun PreviewAppImageLight() {
    CookTheme(systemIsDark = false) {
        initPreviewImageLoader()
        Column(modifier = Modifier.padding(16.dp)) {
            AppImage(
                resource = Res.drawable.icon_star,
                contentDescription = "Favorite Icon",
                modifier = Modifier.size(64.dp)
            )
        }
    }
}

@Composable
@Preview
fun PreviewAppImageDark() {
    CookTheme(systemIsDark = true) {
        initPreviewImageLoader()
        Column(modifier = Modifier.padding(16.dp)) {
            AppImage(
                resource = Res.drawable.icon_star,
                contentDescription = "Favorite Icon",
                modifier = Modifier.size(64.dp)
            )
        }
    }
}
