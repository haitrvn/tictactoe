package com.haitrvn.auth

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.haitrvn.coreui.imageloader.DevicesPreview
import com.haitrvn.coreui.imageloader.initPreviewImageLoader
import com.haitrvn.coreui.theme.CookTheme
import com.haitrvn.features.setting.Setting

@DevicesPreview
@Composable
fun PreviewLogin() {
    initPreviewImageLoader()
    CookTheme {
        Setting(modifier = Modifier)
    }
}
