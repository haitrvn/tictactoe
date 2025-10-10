package com.haitrvn.coreui.preview

import androidx.compose.runtime.Composable
import com.haitrvn.coreui.Input
import com.haitrvn.coreui.Text
import com.haitrvn.coreui.imageloader.DevicesPreview
import com.haitrvn.coreui.theme.CookTheme
import cookapp.resources.core.ui.Res
import cookapp.resources.core.ui.core_ui_icon_back

@DevicesPreview
@Composable
fun PreviewButton() {
    CookTheme {
        Input.Text(prefixIcon = Res.drawable.core_ui_icon_back, value = "This is sample input", onValueChange = {}, error = "Error")
    }
}