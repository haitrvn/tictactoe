package com.haitrvn.coreui.preview

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.haitrvn.coreui.Button
import com.haitrvn.coreui.Primary
import com.haitrvn.coreui.Secondary
import com.haitrvn.coreui.Tertiary
import com.haitrvn.coreui.imageloader.DevicesPreview
import com.haitrvn.coreui.theme.CookTheme

@DevicesPreview
@Composable
fun PreviewButton() {
    CookTheme {
        Column {
            Button.Primary(text = "Sample button") { }
            Button.Secondary(text = "Sample button") { }
            Button.Tertiary(text = "Sample button") { }
        }
    }
}