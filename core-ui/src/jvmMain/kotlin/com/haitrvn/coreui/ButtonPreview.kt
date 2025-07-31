package com.haitrvn.coreui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.haitrvn.coreui.base.SecondaryButton
import com.haitrvn.coreui.theme.CookTheme


@Composable
@Preview
fun ButtonPreview() {
    Column {
        CookTheme(systemIsDark = false) {
            Column {
                CookPrimaryButton("CookPrimaryButtonSystemDark") {}
                SecondaryButton(onClick = {}) {
                    TextSmallTitle(text = "SecondaryButton")
                }
            }
        }
        CookTheme(systemIsDark = false) {
            Column {
                CookPrimaryButton("CookPrimaryButtonSystemLight") {}
                SecondaryButton(onClick = {}) {
                    TextSmallTitle(text = "SecondaryButton")
                }
            }
        }
    }
}
