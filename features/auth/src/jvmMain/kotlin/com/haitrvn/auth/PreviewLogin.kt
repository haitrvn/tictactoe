package com.haitrvn.auth

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import com.haitrvn.coreui.imageloader.initPreviewImageLoader
import kotlinx.collections.immutable.persistentListOf

@Preview
@Composable
private fun PreviewLogin() {
    initPreviewImageLoader()
    val welcomeUiState = WelcomeUiState(
        login = WelcomePageUi(title = "Title", description = "Description", imageUrl = ""),
        pages = persistentListOf()
    )
    LoginScreen(welcomeUiState = welcomeUiState)
}