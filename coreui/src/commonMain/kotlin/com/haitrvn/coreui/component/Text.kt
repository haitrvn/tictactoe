package com.haitrvn.coreui.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withLink
import com.haitrvn.coreui.theme.AppColors
import com.haitrvn.coreui.theme.Typography

object Text

@Composable
fun Text.Heading(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Left,
    color: Color = AppColors.onPrimary,
) {
    Text(
        text = text,
        modifier = modifier,
        textAlign = textAlign,
        color = color,
        style = Typography.text3ExtraLargeBold,
    )
}

@Composable
fun Text.H4(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Left,
    color: Color = AppColors.onPrimaryContainer
) {
    Text(
        text = text,
        modifier = modifier,
        textAlign = textAlign,
        color = color,
        style = Typography.textExtraLargeBold,
    )
}

@Composable
fun Text.H5(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Left,
    color: Color = AppColors.onPrimaryContainer
) {
    Text(
        text = text,
        modifier = modifier,
        textAlign = textAlign,
        color = color,
        style = Typography.textLargeBold,
    )
}

@Composable
fun Text.Paragraph(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Left,
    color: Color = AppColors.onPrimaryContainer
) {
    Text(
        text = text,
        modifier = modifier,
        textAlign = textAlign,
        color = color,
        style = Typography.textBaseRegular,
    )
}

@Composable
fun Text.ParagraphBold(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Left,
    color: Color = AppColors.onPrimaryContainer
) {
    Text(
        text = text,
        modifier = modifier,
        textAlign = textAlign,
        color = color,
        style = Typography.textBaseBold,
    )
}

@Composable
fun Text.Label(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Left,
    color: Color = AppColors.onPrimaryContainer
) {
    Text(
        text = text,
        modifier = modifier,
        textAlign = textAlign,
        color = color,
        style = Typography.textMediumSmallRegular,
    )
}

@Composable
fun Text.LabelBold(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Left,
    color: Color = AppColors.onPrimaryContainer
) {
    Text(
        text = text,
        modifier = modifier,
        textAlign = textAlign,
        color = color,
        style = Typography.textMediumSmallBold,
    )
}

@Composable
fun Text.Small(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Left,
    color: Color = AppColors.onPrimaryContainer
) {
    Text(
        text = text,
        modifier = modifier,
        textAlign = textAlign,
        color = color,
        style = Typography.textSmallRegular,
    )
}

@Composable
fun Text.SmallBold(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Left,
    color: Color = AppColors.onPrimaryContainer
) {
    Text(
        text = text,
        modifier = modifier,
        textAlign = textAlign,
        color = color,
        style = Typography.textSmallBold,
    )
}

@Composable
fun Text.Tiny(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Left,
    color: Color = AppColors.onPrimaryContainer
) {
    Text(
        text = text,
        modifier = modifier,
        textAlign = textAlign,
        color = color,
        style = Typography.textExtraSmallRegular,
    )
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