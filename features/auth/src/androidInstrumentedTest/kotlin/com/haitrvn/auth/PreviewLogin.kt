package com.haitrvn.auth

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.haitrvn.coreui.imageloader.initPreviewImageLoader
import com.haitrvn.coreui.theme.CookTheme
import kotlinx.collections.immutable.persistentListOf

@Composable
@Preview(device = "id:Nexus 4", showBackground = false)
@Preview(device = "id:pixel_9_pro")
@Preview(
    device = "id:pixel_9_pro", showSystemUi = false, showBackground = false,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
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
