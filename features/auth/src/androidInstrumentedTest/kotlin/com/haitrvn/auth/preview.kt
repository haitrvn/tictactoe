package com.haitrvn.auth

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.haitrvn.coreui.theme.CookTheme
import kotlinx.collections.immutable.persistentListOf

@Composable
@Preview(device = "id:4in WVGA (Nexus S)")
@Preview(device = "id:pixel_9_pro")
fun PreviewWelcomeScreen() {
    CookTheme {
        val welcomeUiState = WelcomeUiState(
            login = WelcomePageUi(
                title = "title",
                description = "description",
                imageUrl = "https://ichef.bbci.co.uk/ace/standard/3840/cpsprodpb/2700/live/0cfb5290-6460-11ef-a7d8-61cd67f3fb31.jpg"
            ),
            pages = persistentListOf(
                WelcomePageUi(
                    title = "title",
                    description = "description",
                    imageUrl = "https://ichef.bbci.co.uk/ace/standard/3840/cpsprodpb/2700/live/0cfb5290-6460-11ef-a7d8-61cd67f3fb31.jpg"
                )
            )
        )
        WelcomeScreen(modifier = Modifier.fillMaxSize(), welcomeUiState = welcomeUiState)
    }
}
