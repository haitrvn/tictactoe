package com.haitrvn.coreui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.haitrvn.coreui.base.SecondaryButton
import com.haitrvn.coreui.theme.CookTheme


@Composable
@Preview
fun ButtonPreview() {
    Column(modifier = Modifier.background(Color.DarkGray).fillMaxSize()) {
        CookTheme(systemIsDark = true) {
            CookSurface {
                Column(
                    modifier = Modifier.height(IntrinsicSize.Max),
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    CookPrimaryButton("CookPrimaryButton") {}
                    SecondaryButton(onClick = {}) {
                        TextSmallTitle(text = "SecondaryButton")
                    }
                }
            }
        }

        CookTheme(systemIsDark = false) {
            CookSurface {
                Column(
                    modifier = Modifier.height(IntrinsicSize.Max),
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    CookPrimaryButton("CookPrimaryButton") {}

                    SecondaryButton(onClick = {}) {
                        TextSmallTitle(text = "SecondaryButton")
                    }
                }
            }
        }
    }
}
