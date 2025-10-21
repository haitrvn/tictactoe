package com.haitrvn.coreui.DevicesPreview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.component.H4
import com.haitrvn.coreui.component.H5
import com.haitrvn.coreui.component.Heading
import com.haitrvn.coreui.component.Label
import com.haitrvn.coreui.component.LabelBold
import com.haitrvn.coreui.component.MultiClickableText
import com.haitrvn.coreui.component.Paragraph
import com.haitrvn.coreui.component.ParagraphBold
import com.haitrvn.coreui.component.SegmentText
import com.haitrvn.coreui.component.Small
import com.haitrvn.coreui.component.Text
import com.haitrvn.coreui.component.Tiny
import com.haitrvn.coreui.imageloader.DevicesPreview
import com.haitrvn.coreui.theme.CookTheme

@DevicesPreview
@Composable
private fun TextHeadingDevicesPreview() {
    CookTheme {
        Text.Heading(text = "This is a Heading")
    }
}

@DevicesPreview
@Composable
private fun TextH4DevicesPreview() {
    CookTheme {
        Text.H4(text = "This is H4")
    }
}

@DevicesPreview
@Composable
private fun TextH5DevicesPreview() {
    CookTheme {
        Text.H5(text = "This is H5")
    }
}

@DevicesPreview
@Composable
private fun TextParagraphDevicesPreview() {
    CookTheme {
        Text.Paragraph(text = "This is a paragraph.")
    }
}

@DevicesPreview
@Composable
private fun TextParagraphBoldDevicesPreview() {
    CookTheme {
        Text.ParagraphBold(text = "This is a bold paragraph.")
    }
}

@DevicesPreview
@Composable
private fun TextLabelDevicesPreview() {
    CookTheme {
        Text.Label(text = "This is a label.")
    }
}

@DevicesPreview
@Composable
private fun TextLabelBoldDevicesPreview() {
    CookTheme {
        Text.LabelBold(text = "This is a bold label.")
    }
}

@DevicesPreview
@Composable
private fun TextSmallDevicesPreview() {
    CookTheme {
        Text.Small(text = "This is small text.")
    }
}

@DevicesPreview
@Composable
private fun TextTinyDevicesPreview() {
    CookTheme {
        Text.Tiny(text = "This is tiny text.")
    }
}

@DevicesPreview
@Composable
private fun MultiClickableTextDevicesPreview() {
    CookTheme {
        val segments = listOf(
            SegmentText("By signing up, you agree to our "),
            SegmentText("Terms of Service", tag = "terms", isClickable = true),
            SegmentText(" and "),
            SegmentText("Privacy Policy", tag = "privacy", isClickable = true),
            SegmentText(".")
        )
        MultiClickableText(
            textSegments = segments,
            onClick = {}
        ) { modifier, text ->
            Text.Paragraph(modifier = modifier, text = text.toString())
        }
    }
}

@DevicesPreview()
@Composable
private fun AllTextStylesDevicesPreview() {
    CookTheme {
        Column(modifier = Modifier.padding(16.dp)) {
            Text.Heading(text = "Heading Text")
            Text.H4(text = "H4 Text")
            Text.H5(text = "H5 Text")
            Text.Paragraph(text = "Paragraph Regular")
            Text.ParagraphBold(text = "Paragraph Bold")
            Text.Label(text = "Label Regular")
            Text.LabelBold(text = "Label Bold")
            Text.Small(text = "Small Regular")
            Text.Tiny(text = "Tiny Regular")
        }
    }
}