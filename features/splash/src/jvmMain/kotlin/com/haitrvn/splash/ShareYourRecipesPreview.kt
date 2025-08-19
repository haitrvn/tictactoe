package com.haitrvn.splash

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import com.haitrvn.coreui.imageloader.initPreviewImageLoader

@Preview
@Composable
private fun ShareYourRecipesPreview() {
    initPreviewImageLoader()
    SharedYourRecipesScreen()
}