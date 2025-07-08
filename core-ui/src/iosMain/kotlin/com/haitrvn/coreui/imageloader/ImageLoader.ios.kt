package com.haitrvn.coreui.imageloader

import coil3.PlatformContext
import coil3.disk.DiskCache
import kotlinx.cinterop.ExperimentalForeignApi
import okio.Path
import okio.Path.Companion.toPath
import platform.Foundation.NSCachesDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask

actual object CoilDiskCache {
    private const val FOLDER_NAME = "image_cache"

    @OptIn(ExperimentalForeignApi::class)
    actual fun path(context: PlatformContext): Path {
        val safeCacheDir = NSFileManager.defaultManager.URLForDirectory(
            directory = NSCachesDirectory,
            inDomain = NSUserDomainMask,
            appropriateForURL = null,
            create = false,
            error = null,
        )?.path ?: ""
        return safeCacheDir.toPath() / FOLDER_NAME
    }
}