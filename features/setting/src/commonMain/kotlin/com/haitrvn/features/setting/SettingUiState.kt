package com.haitrvn.features.setting

import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf

data class SettingUiState(
    val userName: String,
    val userAvatar: String,
    val aboutMe: String,
    val recipe: Int,
    val followers: Int,
    val following: Int,
    val featuredPhotos: PersistentList<String>,
) {
    companion object {
        val Empty = SettingUiState(
            userName = "...",
            userAvatar = "",
            aboutMe = "...",
            recipe = 0,
            followers = 0,
            following = 0,
            featuredPhotos = persistentListOf()
        )
    }
}