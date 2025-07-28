package com.haitrvn.coreui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.haitrvn.coreui.theme.CookTheme
import cookapp.resources.coreui.Res
import cookapp.resources.coreui.core_ui_icon_back
import org.jetbrains.compose.resources.vectorResource

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
                    CookPrimaryButton("CookPrimaryButton") {
                    }
                    CookSecondaryButton("CookSecondaryButton") {
                    }
                    CookSpace(SpaceSize.MEDIUM)
                    BaseButton(onClick = {}) {
                        TextSmallTitle(text = "TextSmallTitle")
                    }
                    CookSpace(SpaceSize.MEDIUM)
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
                    CookPrimaryButton("CookPrimaryButton") {
                    }
                    CookSecondaryButton("CookSecondaryButton") {
                    }
                    CookSpace(SpaceSize.MEDIUM)
                    BaseButton(onClick = {}) {
                        TextSmallTitle(text = "TextSmallTitle")
                    }
                    CookSpace(SpaceSize.MEDIUM)
                    IconTextButton(
                        text = "ALo",
                        textStyle = TextStyle(fontSize = 40.sp),
                        icon = vectorResource(Res.drawable.core_ui_icon_back)
                    ) {

                    }
                }
            }
        }
    }
}
