package com.haitrvn.auth

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.haitrvn.coreui.imageloader.DevicesPreview
import com.haitrvn.coreui.imageloader.initPreviewImageLoader
import com.haitrvn.coreui.theme.CookTheme
import kotlinx.collections.immutable.persistentListOf

@DevicesPreview
@Composable
fun PreviewLogin() {
    initPreviewImageLoader()
    val welcomeUiState = WelcomeUiState(
        login = WelcomePageUi(title = "Title", description = "Description", imageUrl = ""),
        pages = persistentListOf()
    )
    CookTheme {
        LoginScreen(modifier = Modifier.fillMaxSize(), welcomeUiState)
    }
}
