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
                    CookDisplayText(text = "CookDisplayText")
                    CookTitleText(text = "CookTitleText")
                    CookBodyText(text = "CookBodyText")
                    CookLabelText(text = "CookLabelText")
                    CookCaptionText(text = "CookCaptionText")
                    CookBigPrimaryButton(text = "CookBigPrimaryButton") {}
                    CookSmallPrimaryButton(text = "CookSmallPrimaryButton") {}
                    CookBigSecondaryButton(text = "CookBigSecondaryButton") {}
                    CookSmallSecondaryButton(text = "CookSmallSecondaryButton") {}
                }
            }
        }

        CookTheme(systemIsDark = false) {
            CookSurface {
                Column {
                    CookDisplayText(text = "CookDisplayText")
                    CookTitleText(text = "CookTitleText")
                    CookBodyText(text = "CookBodyText")
                    CookLabelText(text = "CookLabelText")
                    CookCaptionText(text = "CookCaptionText")
                    CookBigPrimaryButton(text = "CookBigPrimaryButton") {}
                    CookSmallPrimaryButton(text = "CookSmallPrimaryButton") {}
                    CookBigSecondaryButton(text = "CookSecondaryButton") {}
                    CookSmallSecondaryButton(text = "CookSmallSecondaryButton") {}
                }
            }
        }
    }
}
