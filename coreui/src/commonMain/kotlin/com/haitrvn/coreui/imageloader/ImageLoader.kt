@file:Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING", "ComposableNaming")

package com.haitrvn.coreui.imageloader

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.toArgb
import coil3.ColorImage
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.SingletonImageLoader
import coil3.compose.setSingletonImageLoaderFactory
import coil3.disk.DiskCache
import coil3.memory.MemoryCache
import com.haitrvn.coreui.theme.DarkColors
import okio.Path

@Composable
fun initImageLoader() {
    setSingletonImageLoaderFactory { context ->
        ImageLoader.Builder(context)
            .memoryCache {
                MemoryCache.Builder()
                    .maxSizePercent(context, 0.25)
                    .build()
            }
            .diskCache {
                DiskCache.Builder()
                    .directory(CoilDiskCache.path(context))
                    .maxSizePercent(0.02)
                    .build()
            }
            .logger(ImageLoggerImpl())
            .build()
    }
}

expect object CoilDiskCache {
    fun path(context: PlatformContext): Path
}

@Composable
fun initPreviewImageLoader() {
    val color = DarkColors.link.toArgb()
    SingletonImageLoader.setSafe {
        ImageLoader.Builder(it)
            .placeholder(ColorImage(color = color))
            .error(ColorImage(color = color))
            .fallback(ColorImage(color = color))
            .build()
    }
}