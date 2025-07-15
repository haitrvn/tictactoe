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
                    CookHeaderText(text = "CookHeaderText")
                    CookTitleText(text = "CookTitleText")
                    CookSubTitleText(text = "CookSubTitleText")
                    CookLabelText(text = "CookLabelText")
                    CookParagraphText(text = "CookParagraphText")
                    CookSmallText(text = "CookSmallText")
                    CookSmallBodyText(text = "CookSmallBodyText")
                    CookTinyText(text = "CookTinyText")
                    CookBigPrimaryButton(text = "CookBigPrimaryButton") {}
                    CookSmallPrimaryButton(text = "CookSmallPrimaryButton") {}
                    CookBigSecondaryButton(text = "CookSecondaryButton") {}
                    CookSmallSecondaryButton(text = "CookSmallSecondaryButton") {}
                }
            }
        }

        CookTheme(systemIsDark = false) {
            CookSurface {
                Column {
                    CookHeaderText(text = "CookHeaderText")
                    CookTitleText(text = "CookTitleText")
                    CookSubTitleText(text = "CookSubTitleText")
                    CookLabelText(text = "CookLabelText")
                    CookParagraphText(text = "CookParagraphText")
                    CookSmallText(text = "CookSmallText")
                    CookSmallBodyText(text = "CookSmallBodyText")
                    CookTinyText(text = "CookTinyText")
                    CookBigPrimaryButton(text = "CookBigPrimaryButton") {}
                    CookSmallPrimaryButton(text = "CookSmallPrimaryButton") {}
                    CookBigSecondaryButton(text = "CookSecondaryButton") {}
                    CookSmallSecondaryButton(text = "CookSmallSecondaryButton") {}
                }
            }
        }
    }
}
