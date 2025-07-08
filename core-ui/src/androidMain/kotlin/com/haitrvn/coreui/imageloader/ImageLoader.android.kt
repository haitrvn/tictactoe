package com.haitrvn.coreui.imageloader

import coil3.PlatformContext
import okio.Path
import okio.Path.Companion.toOkioPath

actual object CoilDiskCache {
    private const val FOLDER_NAME = "image_cache"

    @Synchronized
    actual fun path(context: PlatformContext): Path {
        val safeCacheDir = context.cacheDir.apply { mkdirs() }
        return safeCacheDir.resolve(FOLDER_NAME).toOkioPath()
    }
}