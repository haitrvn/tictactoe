package com.haitrvn.coreui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withLink
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.haitrvn.coreui.theme.Colors
import com.haitrvn.coreui.theme.Typo

object Text

@Composable
fun Text.Header(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Left,
    color: Color = Colors.paragraph,
    fontSize: TextUnit = 60.sp,
    fontFamily: FontFamily? = Typo.headingBold.fontFamily
) {
    Text(
        text = text,
        modifier = modifier,
        fontSize = fontSize,
        textAlign = textAlign,
        color = color,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Normal,
    )
}

@Composable
fun Text.Title(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Left,
    color: Color = Color.Black
) {
    Text(text = text, modifier = modifier, fontSize = 20.sp, textAlign = textAlign, color = color)
}

@Composable
fun Text.Title(
    modifier: Modifier = Modifier,
    string: AnnotatedString,
    textAlign: TextAlign = TextAlign.Left,
    color: Color = Color.Black
) {
    Text(text = string, modifier = modifier, fontSize = 20.sp, textAlign = textAlign, color = color)
}

@Composable
fun Text.Paragraph(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Left,
    color: Color = Colors.paragraph
) {
    Text(text = text, modifier = modifier, fontSize = 20.sp, textAlign = textAlign, color = color)
}

@Composable
fun Text.Error(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Left,
    color: Color = Color.Black
) {
    Text(text = text, modifier = modifier, fontSize = 16.sp, textAlign = textAlign, color = color)
}

@Composable
fun MultiClickableText(
    modifier: Modifier = Modifier,
    textSegments: List<SegmentText>,
    onClick: (tag: String) -> Unit,
    content: @Composable (modifier: Modifier, text: AnnotatedString) -> Unit
) {
    val annotatedString = buildAnnotatedString {
        textSegments.forEach { segment ->
            if (segment.isClickable) {
                val link = LinkAnnotation.Clickable(
                    tag = segment.tag,
                    styles = TextLinkStyles(style = SpanStyle(color = Color.Blue))
                ) {
                    onClick(segment.tag)
                }
                withLink(link = link) {
                    append(segment.text)
                }
            } else {
                append(segment.text)
            }
        }
    }
    content(modifier, annotatedString)
}

data class SegmentText(
    val text: String,
    val tag: String = "",
    val isClickable: Boolean = false,
)