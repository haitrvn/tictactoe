package com.haitrvn.splash

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.haitrvn.coreui.imageloader.initPreviewImageLoader

@Preview
@Composable
fun PreviewSplashScreen() {
    initPreviewImageLoader()
    SplashScreen()
}