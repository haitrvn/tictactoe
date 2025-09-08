package com.haitrvn.coreui.imageloader

import coil3.PlatformContext
import okio.Path
import okio.Path.Companion.toOkioPath
import java.io.File

actual object CoilDiskCache {
    private const val IMAGE_CACHE_SUBDIRECTORY = "image_cache"
    actual fun path(context: PlatformContext): Path {
        return File(System.getProperty("java.io.tmpdir"), IMAGE_CACHE_SUBDIRECTORY).toOkioPath()
    }
}