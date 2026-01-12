package com.haitrvn.coreui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.theme.AppColors
import com.haitrvn.coreui.theme.CookTheme
import com.haitrvn.coreui.theme.Typography
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
internal fun AppText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = LocalTextStyle.current,
    color: Color = Color.Unspecified,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    fontSize: TextUnit? = null,
) {
    BasicText(
        text = text,
        modifier = modifier,
        style = style.copy(
            color = if (color != Color.Unspecified) color else style.color,
            textAlign = textAlign ?: style.textAlign,
            fontSize = fontSize ?: style.fontSize
        ),
        overflow = overflow,
        maxLines = maxLines,
    )
}

@Composable
fun Heading(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = AppColors.onBackground,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = Typography.text2ExtraLargeBold,
    fontSize: TextUnit? = null,
) {
    AppText(
        text = text,
        modifier = modifier,
        style = style,
        color = color,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        fontSize = fontSize,
    )
}

@Composable
fun Title(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = AppColors.onBackground,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = Typography.textLargeBold,
    fontSize: TextUnit? = null,
) {
    AppText(
        text = text,
        modifier = modifier,
        style = style,
        color = color,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        fontSize = fontSize,
    )
}

@Composable
fun Body(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = AppColors.onSurface,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = Typography.textBaseRegular,
    fontSize: TextUnit? = null,
) {
    AppText(
        text = text,
        modifier = modifier,
        style = style,
        color = color,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        fontSize = fontSize,
    )
}

@Composable
fun Label(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = AppColors.onSurface,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = Typography.textSmallMedium,
    fontSize: TextUnit? = null,
) {
    AppText(
        text = text,
        modifier = modifier,
        style = style,
        color = color,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        fontSize = fontSize,
    )
}

@Composable
fun Caption(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = AppColors.onSurface,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle = Typography.textExtraSmallRegular,
    fontSize: TextUnit? = null,
) {
    AppText(
        text = text,
        modifier = modifier,
        style = style,
        color = color,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        fontSize = fontSize,
    )
}

@Composable
@Preview
fun PreviewHierarchicalTextLight() {
    CookTheme(systemIsDark = false) {
        Column(modifier = Modifier.padding(16.dp)) {
            Heading(text = "Heading")
            Title(text = "Title")
            Body(text = "Body")
            Label(text = "Label")
            Caption(text = "Caption")
        }
    }
}

@Composable
@Preview
fun PreviewHierarchicalTextDark() {
    CookTheme(systemIsDark = true) {
        Column(modifier = Modifier.padding(16.dp)) {
            Heading(text = "Heading")
            Title(text = "Title")
            Body(text = "Body")
            Label(text = "Label")
            Caption(text = "Caption")
        }
    }
}
