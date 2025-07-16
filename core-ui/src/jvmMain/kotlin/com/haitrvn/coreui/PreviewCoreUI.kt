package com.haitrvn.coreui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.theme.CookTheme

@Composable
@Preview
fun PreviewHeader() {
    Column {
        Header(title = "Sample header")
        Header(title = "Sample header", isBackable = true)
    }
}

@Composable
@Preview
fun PreviewCoreUi() {
    Column(modifier = Modifier.background(Color.DarkGray).fillMaxSize()) {
        CookTheme(systemIsDark = true) {
            CookSurface {
                Column {
                    CookHeaderText(text = "CookHeaderText")
                    CookTitleText(text = "CookTitleText")
                    CookSubTitleText(text = "CookSubTitleText")
                    CookLabel1Text(text = "CookLabelText")
                    CookLabel2Text(text = "CookSmallBodyText")
                    CookParagraphText(text = "CookParagraphText")
                    CookSmallText(text = "CookSmallText")
                    CookTinyText(text = "CookTinyText")
                    CookBigPrimaryButton(text = "CookBigPrimaryButton") {}
                    CookSmallPrimaryButton(text = "CookSmallPrimaryButton") {}
                    CookBigSecondaryButton(text = "CookSecondaryButton") {}
                    CookSmallSecondaryButton(text = "CookSmallSecondaryButton") {}
                    Card(modifier = Modifier.size(50.dp)) { }
                }
            }
        }

        CookTheme(systemIsDark = false) {
            CookSurface {
                Column {
                    CookHeaderText(text = "CookHeaderText")
                    CookTitleText(text = "CookTitleText")
                    CookSubTitleText(text = "CookSubTitleText")
                    CookLabel1Text(text = "CookLabelText")
                    CookLabel2Text(text = "CookSmallBodyText")
                    CookParagraphText(text = "CookParagraphText")
                    CookSmallText(text = "CookSmallText")
                    CookTinyText(text = "CookTinyText")
                    CookBigPrimaryButton(text = "CookBigPrimaryButton") {}
                    CookSmallPrimaryButton(text = "CookSmallPrimaryButton") {}
                    CookBigSecondaryButton(text = "CookSecondaryButton") {}
                    CookSmallSecondaryButton(text = "CookSmallSecondaryButton") {}
                    Card(modifier = Modifier.size(50.dp)) { }
                }
            }
        }
    }
}
