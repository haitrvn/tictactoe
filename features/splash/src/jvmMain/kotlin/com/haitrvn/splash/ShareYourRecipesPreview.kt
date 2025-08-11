package com.haitrvn.splash

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.haitrvn.coreui.imageloader.initPreviewImageLoader
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun ShareYourRecipesPreview(modifier: Modifier = Modifier) {
    initPreviewImageLoader()
    SharedYourRecipesScreen(modifier = modifier)
}