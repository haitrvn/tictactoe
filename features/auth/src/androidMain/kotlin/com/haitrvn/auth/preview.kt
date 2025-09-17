package com.haitrvn.auth

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.collections.immutable.persistentListOf

@Composable
@Preview
fun PreviewWelcomeScreen() {
    val welcomeUiState = WelcomeUiState(
        login = WelcomePageUi(title = "title", description = "description", imageUrl = ""),
        pages = persistentListOf(
            WelcomePageUi(
                title = "title",
                description = "description",
                imageUrl = ""
            )
        )
    )
    WelcomeScreen(modifier = Modifier.fillMaxSize(), welcomeUiState = welcomeUiState)
}