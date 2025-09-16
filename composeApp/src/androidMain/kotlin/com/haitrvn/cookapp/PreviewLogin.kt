package com.haitrvn.cookapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.haitrvn.auth.LoginScreen
import com.haitrvn.auth.WelcomePageUi
import com.haitrvn.auth.WelcomeUiState
import kotlinx.collections.immutable.persistentListOf

@Preview
@Composable
private fun PreviewLogin() {
    val welcomeUiState = WelcomeUiState(
        login = WelcomePageUi(title = "Title", description = "Description", imageUrl = ""),
        pages = persistentListOf()
    )
    LoginScreen(welcomeUiState = welcomeUiState)
}