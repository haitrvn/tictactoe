package com.haitrvn.auth

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import com.haitrvn.coreui.imageloader.initPreviewImageLoader
import kotlinx.collections.immutable.persistentListOf

@Preview
@Composable
private fun PreviewWelcome() {
    initPreviewImageLoader()
    val welcomeUiState = WelcomeUiState(
        login = WelcomePageUi(
            title = "Abc",
            description = "description",
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSudTsDqMa_OimGOwDvB5veN7NQ3lyWuhGSVw&s"
        ),
        pages = persistentListOf(
            WelcomePageUi(
                title = "Abc",
                description = "description",
                imageUrl = ""
            )
        )
    )
    WelcomeScreen(welcomeUiState = welcomeUiState)
}