@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.haitrvn.auth

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import com.haitrvn.coreui.imageloader.initPreviewImageLoader

@Preview
@Composable
private fun PreviewLogin() {
    initPreviewImageLoader()
    LoginWrapper()
}