package com.haitrvn.saved

import cookapp.resources.saved.Res
import cookapp.resources.saved.saved_tab_recipes
import cookapp.resources.saved.saved_tab_videos
import org.jetbrains.compose.resources.StringResource

internal enum class SavedType {
    VIDEOS,
    RECIPES,
}

internal val SavedType.title: StringResource
    get() = when (this) {
        SavedType.VIDEOS -> Res.string.saved_tab_videos
        SavedType.RECIPES -> Res.string.saved_tab_recipes
    }