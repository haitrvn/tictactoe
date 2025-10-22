package com.haitrvn.coreui.preview

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.haitrvn.coreui.component.Button
import com.haitrvn.coreui.component.Filled
import com.haitrvn.coreui.component.Outlined
import com.haitrvn.coreui.component.Text
import com.haitrvn.coreui.imageloader.DevicesPreview
import com.haitrvn.coreui.theme.CookTheme

@DevicesPreview
@Composable
fun PreviewButton() {
    CookTheme {
        Column {
            Button.Filled(text = "Sample button") { }
            Button.Outlined(text = "Sample button") { }
            Button.Text(text = "Sample button") { }
        }
    }
}