package com.haitrvn.coreui.imageloader

import androidx.compose.runtime.Composable
import coil3.ImageLoader
import coil3.PlatformContext
import coil3.compose.setSingletonImageLoaderFactory
import coil3.disk.DiskCache
import coil3.memory.MemoryCache
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
            .logger(LoggerImpl())
            .build()
    }
}

expect object CoilDiskCache {
    fun path(context: PlatformContext): Path
}