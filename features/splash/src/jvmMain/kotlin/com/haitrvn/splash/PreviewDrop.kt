package com.haitrvn.splash

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.imageloader.initPreviewImageLoader

@Preview
@Composable
fun PreviewDrop() {
    initPreviewImageLoader()
    Drop(
        modifier = Modifier.fillMaxSize(),
        padding = 30.dp
    )
}