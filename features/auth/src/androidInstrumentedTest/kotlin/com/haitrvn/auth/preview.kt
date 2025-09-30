package com.haitrvn.auth

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.haitrvn.coreui.theme.CookTheme
import kotlinx.collections.immutable.persistentListOf

@Composable
@Preview(device = "id:4in WVGA (Nexus S)")
@Preview(device = "id:pixel_9_pro")
@Preview(
    device = "id:4in WVGA (Nexus S)",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Preview(
    device = "id:pixel_9_pro", showSystemUi = false, showBackground = false,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
fun PreviewWelcomeScreen() {
    CookTheme {
        val welcomeUiState = WelcomeUiState(
            login = WelcomePageUi(
                title = "Become A Master Chef",
                description = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.",
                imageUrl = "https://ichef.bbci.co.uk/ace/standard/3840/cpsprodpb/2700/live/0cfb5290-6460-11ef-a7d8-61cd67f3fb31.jpg"
            ),
            pages = persistentListOf(
                WelcomePageUi(
                    title = "Become A Master Chef",
                    description = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.",
                    imageUrl = "https://ichef.bbci.co.uk/ace/standard/3840/cpsprodpb/2700/live/0cfb5290-6460-11ef-a7d8-61cd67f3fb31.jpg"
                )
            )
        )
        WelcomeScreen(modifier = Modifier.fillMaxSize(), welcomeUiState = welcomeUiState)
    }
}
