@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.haitrvn.auth

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withLink
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.CookImage
import com.haitrvn.coreui.CookSmallText
import com.haitrvn.coreui.CookSpace
import com.haitrvn.coreui.CookTitleText
import com.haitrvn.coreui.SpaceSize
import com.haitrvn.coreui.theme.CookTheme
import cookapp.resources.auth.Res
import cookapp.resources.auth.ic_cyclone1
import cookapp.resources.auth.login_button_login_with_apple
import cookapp.resources.auth.login_button_login_with_email
import cookapp.resources.auth.login_button_login_with_facebook
import cookapp.resources.auth.login_button_login_with_google
import cookapp.resources.auth.login_text_no_account
import cookapp.resources.auth.login_text_signup
import cookapp.resources.auth.login_welcome_quote
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.stringResource

const val TAG_SIGNUP = "signup"

@Composable
fun Login(
    modifier: Modifier = Modifier,
    sentEvent: (LoginAction) -> Unit = {},
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        CookImage(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(0.4f),
            drawableResource = Res.drawable.ic_cyclone1
        )
        CookSpace(SpaceSize.MEDIUM)
        CookTitleText(text = stringResource(Res.string.login_welcome_quote))
        CookSpace(SpaceSize.SMALL)
        CookSmallText(text = stringResource(Res.string.login_welcome_quote))
        CookSpace(SpaceSize.SMALL)
        LoginWithSocial()
        CookSpace(SpaceSize.MEDIUM)

        CookSmallText(text = stringResource(Res.string.login_welcome_quote))
        val textSegments = listOf(
            SegmentText(text = stringResource(Res.string.login_text_no_account)),
            SegmentText(text = " "),
            SegmentText(
                text = stringResource(Res.string.login_text_signup),
                isClickable = true,
                tag = TAG_SIGNUP
            ),
        )
        MultiClickableText(textSegments = textSegments, onClick = { tag ->
            when (tag) {
                TAG_SIGNUP -> {}
                else -> {}
            }
        }) { text ->
            CookSmallText(text = text)
        }
    }
}

@Composable
private fun LoginWithSocial() {
    SocialButton(
        modifier = Modifier.fillMaxWidth(0.6f).heightIn(20.dp, 30.dp),
        text = stringResource(Res.string.login_button_login_with_google),
        icon = Res.drawable.ic_cyclone1
    ) {}
    SocialButton(
        modifier = Modifier.fillMaxWidth(0.6f).heightIn(20.dp, 30.dp),
        text = stringResource(Res.string.login_button_login_with_facebook),
        icon = Res.drawable.ic_cyclone1
    ) {}
    SocialButton(
        modifier = Modifier.fillMaxWidth(0.6f).heightIn(20.dp, 30.dp),
        text = stringResource(Res.string.login_button_login_with_apple),
        icon = Res.drawable.ic_cyclone1
    ) {}
    SocialButton(
        modifier = Modifier.fillMaxWidth(0.6f).heightIn(20.dp, 30.dp),
        text = stringResource(Res.string.login_button_login_with_email),
        icon = Res.drawable.ic_cyclone1
    ) {}
}

@Composable
fun SocialButton(
    modifier: Modifier = Modifier,
    text: String,
    icon: DrawableResource,
    onClick: () -> Unit,
) {
    val shape = CookTheme.shapes.medium
    Row(
        modifier
            .padding(all = 2.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(shape)
            .background(CookTheme.colors.primary)
            .clickable { onClick() }
            .padding(horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        CookImage(
            modifier = Modifier.padding(5.dp).fillMaxHeight().aspectRatio(1f),
            drawableResource = icon
        )
        CookSpace(SpaceSize.MEDIUM)
        CookSmallText(modifier = Modifier.fillMaxWidth(), text = text)
    }
}

@Composable
fun MultiClickableText(
    modifier: Modifier = Modifier,
    textSegments: List<SegmentText>,
    onClick: (tag: String) -> Unit,
    content: @Composable (text: AnnotatedString) -> Unit
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
    content(annotatedString)
}

data class SegmentText(
    val text: String,
    val tag: String = "",
    val isClickable: Boolean = false,
)
