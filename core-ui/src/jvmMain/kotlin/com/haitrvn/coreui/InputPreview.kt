package com.haitrvn.coreui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.theme.CookTheme

@Composable
@Preview
fun PreviewInput() {
    Column(modifier = Modifier.background(Color.DarkGray).fillMaxSize()) {
        CookTheme(systemIsDark = true) {
            CookSurface {
                Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                    AuthInput(value = "ahdh", label = "label") {

                    }
                }
            }
        }

        CookTheme(systemIsDark = false) {
            CookSurface {
                Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
                    AuthInput(value = "ahdh", label = "label") {

                    }
                }
            }
        }
    }
}
