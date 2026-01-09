package com.haitrvn.coreui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
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
    style: TextStyle = Typography.textMediumSmallRegular,
    color: Color = AppColors.onBackground,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    fontSize: TextUnit = TextUnit.Unspecified,
) {
    BasicText(
        text = text,
        modifier = modifier,
        style = style.copy(
            color = color,
            textAlign = textAlign ?: TextAlign.Unspecified,
            fontSize = fontSize
        ),
        overflow = overflow,
        maxLines = maxLines,
    )
}

@Composable
fun OnPrimaryText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = Typography.textLargeRegular,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    fontSize: TextUnit = TextUnit.Unspecified,
) {
    AppText(
        text = text,
        modifier = modifier,
        style = style,
        color = AppColors.onPrimary,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        fontSize = fontSize,
    )
}

@Composable
fun OnPrimaryContainerText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = Typography.textMediumSmallRegular,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    fontSize: TextUnit = TextUnit.Unspecified,
) {
    AppText(
        text = text,
        modifier = modifier,
        style = style,
        color = AppColors.onPrimaryContainer,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        fontSize = fontSize,
    )
}

@Composable
fun OnSecondaryText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = Typography.textMediumSmallRegular,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    fontSize: TextUnit = TextUnit.Unspecified,
) {
    AppText(
        text = text,
        modifier = modifier,
        style = style,
        color = AppColors.onSecondary,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        fontSize = fontSize,
    )
}

@Composable
fun OnSecondaryContainerText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = Typography.textMediumSmallRegular,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    fontSize: TextUnit = TextUnit.Unspecified,
) {
    AppText(
        text = text,
        modifier = modifier,
        style = style,
        color = AppColors.onSecondaryContainer,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        fontSize = fontSize,
    )
}

@Composable
fun OnTertiaryText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = Typography.textMediumSmallRegular,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    fontSize: TextUnit = TextUnit.Unspecified,
) {
    AppText(
        text = text,
        modifier = modifier,
        style = style,
        color = AppColors.onTertiary,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        fontSize = fontSize,
    )
}

@Composable
fun OnTertiaryContainerText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = Typography.textMediumSmallRegular,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    fontSize: TextUnit = TextUnit.Unspecified,
) {
    AppText(
        text = text,
        modifier = modifier,
        style = style,
        color = AppColors.onTertiaryContainer,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        fontSize = fontSize,
    )
}

@Composable
fun OnBackgroundText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = Typography.textMediumSmallRegular,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    fontSize: TextUnit = TextUnit.Unspecified,
) {
    AppText(
        text = text,
        modifier = modifier,
        style = style,
        color = AppColors.onBackground,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        fontSize = fontSize,
    )
}

@Composable
fun OnSurfaceText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = Typography.textMediumSmallRegular,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    fontSize: TextUnit = TextUnit.Unspecified,
) {
    AppText(
        text = text,
        modifier = modifier,
        style = style,
        color = AppColors.onSurface,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        fontSize = fontSize,
    )
}

@Composable
fun OnErrorText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = Typography.textMediumSmallRegular,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    fontSize: TextUnit = TextUnit.Unspecified,
) {
    AppText(
        text = text,
        modifier = modifier,
        style = style,
        color = AppColors.onError,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        fontSize = fontSize,
    )
}

@Composable
fun OnErrorContainerText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = Typography.textMediumSmallRegular,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    fontSize: TextUnit = TextUnit.Unspecified,
) {
    AppText(
        text = text,
        modifier = modifier,
        style = style,
        color = AppColors.onErrorContainer,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        fontSize = fontSize,
    )
}

@Composable
fun OnSuccessText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = Typography.textMediumSmallRegular,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    fontSize: TextUnit = TextUnit.Unspecified,
) {
    AppText(
        text = text,
        modifier = modifier,
        style = style,
        color = AppColors.onSuccess,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        fontSize = fontSize,
    )
}

@Composable
fun OnSuccessContainerText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = Typography.textMediumSmallRegular,
    textAlign: TextAlign? = null,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE,
    fontSize: TextUnit = TextUnit.Unspecified,
) {
    AppText(
        text = text,
        modifier = modifier,
        style = style,
        color = AppColors.onSuccessContainer,
        textAlign = textAlign,
        overflow = overflow,
        maxLines = maxLines,
        fontSize = fontSize,
    )
}

@Composable
@Preview
fun PreviewSpecializedTextsLight() {
    CookTheme(systemIsDark = false) {
        Column(modifier = Modifier.padding(16.dp)) {
            OnPrimaryText(text = "OnPrimaryText")
            OnPrimaryContainerText(text = "OnPrimaryContainerText")
            OnSecondaryText(text = "OnSecondaryText")
            OnSecondaryContainerText(text = "OnSecondaryContainerText")
            OnTertiaryText(text = "OnTertiaryText")
            OnTertiaryContainerText(text = "OnTertiaryContainerText")
            OnBackgroundText(text = "OnBackgroundText")
            OnSurfaceText(text = "OnSurfaceText")
            OnErrorText(text = "OnErrorText")
            OnErrorContainerText(text = "OnErrorContainerText")
            OnSuccessText(text = "OnSuccessText")
            OnSuccessContainerText(text = "OnSuccessContainerText")
        }
    }
}

@Composable
@Preview
fun PreviewSpecializedTextsDark() {
    CookTheme(systemIsDark = true) {
        Column(modifier = Modifier.padding(16.dp)) {
            OnPrimaryText(text = "OnPrimaryText")
            OnPrimaryContainerText(text = "OnPrimaryContainerText")
            OnSecondaryText(text = "OnSecondaryText")
            OnSecondaryContainerText(text = "OnSecondaryContainerText")
            OnTertiaryText(text = "OnTertiaryText")
            OnTertiaryContainerText(text = "OnTertiaryContainerText")
            OnBackgroundText(text = "OnBackgroundText")
            OnSurfaceText(text = "OnSurfaceText")
            OnErrorText(text = "OnErrorText")
            OnErrorContainerText(text = "OnErrorContainerText")
            OnSuccessText(text = "OnSuccessText")
            OnSuccessContainerText(text = "OnSuccessContainerText")
        }
    }
}
