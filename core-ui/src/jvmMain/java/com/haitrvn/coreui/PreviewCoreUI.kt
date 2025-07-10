package com.haitrvn.coreui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.haitrvn.coreui.theme.CookTheme

@Composable
@Preview
fun PreviewApp() {
    Column(modifier = Modifier.fillMaxSize()) {
        CookTheme(systemIsDark = true) {
            CookSurface {
                Column {
                    CookBigHeadTitle(text = "ABaC")
                    CookHeadTitle(text = "ABaC")
                    CookParagraphText(text = "ABaC")
                    CookLabelText(text = "ABaC")
                    CookBodyBoldText(text = "ABaC")
                }
            }
        }

        CookTheme(systemIsDark = false) {
            CookSurface {
                Column {
                    CookBigHeadTitle(text = "ABaC")
                    CookHeadTitle(text = "ABaC")
                    CookParagraphText(text = "ABaC")
                    CookLabelText(text = "ABaC")
                    CookBodyBoldText(text = "ABaC")
                }
            }
        }
    }
}
