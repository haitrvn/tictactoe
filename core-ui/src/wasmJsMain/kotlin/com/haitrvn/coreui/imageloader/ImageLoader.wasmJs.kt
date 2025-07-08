package com.haitrvn.coreui.imageloader

import coil3.PlatformContext
import okio.Path
import okio.Path.Companion.toPath

actual object CoilDiskCache {
    actual fun path(context: PlatformContext): Path {
        return "coil_cache".toPath()
    }
}