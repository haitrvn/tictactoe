package com.haitrvn.coreui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withLink
import com.haitrvn.coreui.base.DebouncedClickable

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
                    DebouncedClickable.preform { onClick(segment.tag) }
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