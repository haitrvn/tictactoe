package com.haitrvn.splash

import org.jetbrains.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import com.haitrvn.coreui.imageloader.initPreviewImageLoader

@Preview
@Composable
private fun ShareYourRecipesPreview() {
    initPreviewImageLoader()
    SharedYourRecipesScreen()
}