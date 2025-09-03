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
        side = Side.LEFT,
        modifier = Modifier.fillMaxSize(),
        offset = 100.dp
    )
}