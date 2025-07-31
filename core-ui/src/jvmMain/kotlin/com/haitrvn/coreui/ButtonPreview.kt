package com.haitrvn.coreui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.haitrvn.coreui.theme.CookTheme


@Composable
@Preview
fun ButtonPreview() {
    Column {
        CookTheme(systemIsDark = false) {
            Column {
                CookPrimaryButton("CookPrimaryButton") {}
                CookSecondaryButton("CookSecondaryButton") {}
            }
        }
        CookTheme(systemIsDark = true) {
            Column {
                CookPrimaryButton("CookPrimaryButton") {}
                CookSecondaryButton("CookSecondaryButton") {}
            }
        }
    }
}
