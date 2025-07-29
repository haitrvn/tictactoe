package com.haitrvn.coreui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.haitrvn.coreui.theme.CookTheme

@Composable
@Preview
fun PreviewText() {
    Column(modifier = Modifier.background(Color.DarkGray).fillMaxSize()) {
        CookTheme(systemIsDark = true) {
            CookSurface {
                Column {
                    TextApp(text = "TextApp")
                    TextHeader(text = "TextHeader")
                    TextSubHeader(text = "TextSubHeader")
                    TextBigTitle(text = "TextBigTitle")
                    TextTitle(text = "TextTitle")
                    TextSmallTitle(text = "TextSmallTitle")
                    TextParagraph(text = "TextParagraph")
                    TextError(text = "TextError")
                    TextSmall(text = "TextSmall")
                    TextTiny(text = "TextTiny")
                }
            }
        }

        CookTheme(systemIsDark = false) {
            CookSurface {
                Column {
                    TextApp(text = "TextApp")
                    TextHeader(text = "TextHeader")
                    TextSubHeader(text = "TextSubHeader")
                    TextBigTitle(text = "TextBigTitle")
                    TextTitle(text = "TextTitle")
                    TextSmallTitle(text = "TextSmallTitle")
                    TextParagraph(text = "TextParagraph")
                    TextError(text = "TextError")
                    TextSmall(text = "TextSmall")
                    TextTiny(text = "TextTiny")
                }
            }
        }
    }
}