package com.haitrvn.features.setting

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Setting(modifier: Modifier = Modifier) {

}

@Composable
fun Setting(
    modifier: Modifier = Modifier,
    uiState: SettingUiState
) {

}

data class SettingUiState(
    val userName: String,
    val aboutMe: String,
    val recipe: Int,
    val followers: Int,
    val following: Int,
    val featuredPhotos: List<String>,
)