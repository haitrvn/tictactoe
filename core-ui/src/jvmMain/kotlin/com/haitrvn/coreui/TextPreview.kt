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
                    TextApp(text = "Abcdefghiklmn (TextApp)")
                    TextHeader(text = "Abcdefghiklmn (TextHeader)")
                    TextBigTitle(text = "Abcdefghiklmn (TextBigTitle)")
                    TextTitle(text = "Abcdefghiklmn (TextTitle)")
                    TextSmallTitle(text = "Abcdefghiklmn (TextSmallTitle)")
                    TextParagraph(text = "Abcdefghiklmn (TextParagraph)")
                    TextError(text = "Abcdefghiklmn (TextError)")
                    TextSmall(text = "Abcdefghiklmn (TextSmall)")
                    TextTiny(text = "Abcdefghiklmn (TextTiny)")
                }
            }
        }

        CookTheme(systemIsDark = false) {
            CookSurface {
                Column {
                    TextApp(text = "Abcdefghiklmn (TextApp)")
                    TextHeader(text = "Abcdefghiklmn (TextHeader)")
                    TextBigTitle(text = "Abcdefghiklmn (TextBigTitle)")
                    TextTitle(text = "Abcdefghiklmn (TextTitle)")
                    TextSmallTitle(text = "Abcdefghiklmn (TextSmallTitle)")
                    TextParagraph(text = "Abcdefghiklmn (TextParagraph)")
                    TextError(text = "Abcdefghiklmn (TextError)")
                    TextSmall(text = "Abcdefghiklmn (TextSmall)")
                    TextTiny(text = "Abcdefghiklmn (TextTiny)")
                }
            }
        }
    }
}