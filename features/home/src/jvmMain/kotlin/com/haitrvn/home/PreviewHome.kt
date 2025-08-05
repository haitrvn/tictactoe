package com.haitrvn.home

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import com.haitrvn.coreui.imageloader.initPreviewImageLoader

@Preview
@Composable
fun PreviewHome() {
    initPreviewImageLoader()
    HomeWrapper()
}