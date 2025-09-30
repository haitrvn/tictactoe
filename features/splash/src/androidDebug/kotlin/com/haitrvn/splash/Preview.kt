package com.haitrvn.splash

import androidx.compose.runtime.Composable
import com.haitrvn.coreui.imageloader.initPreviewImageLoader
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun PreviewSplashScreen() {
    initPreviewImageLoader()
    SplashScreen()
}