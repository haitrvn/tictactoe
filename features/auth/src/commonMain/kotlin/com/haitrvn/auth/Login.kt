@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.haitrvn.auth

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.AppIcon
import com.haitrvn.coreui.CookImage
import com.haitrvn.coreui.CookPrimaryButton
import com.haitrvn.coreui.Drop
import com.haitrvn.coreui.HeaderText
import com.haitrvn.coreui.MultiClickableText
import com.haitrvn.coreui.SegmentText
import com.haitrvn.coreui.Side
import com.haitrvn.coreui.SmallSpace
import com.haitrvn.coreui.SocialButton
import com.haitrvn.coreui.TextSmall
import com.haitrvn.coreui.theme.appleLoginBackground
import com.haitrvn.coreui.theme.facebookLoginBackground
import com.haitrvn.coreui.theme.googleLoginBackground
import com.haitrvn.coreui.theme.googleLoginText
import com.haitrvn.coreui.utils.toText
import com.haitrvn.navigation.Auth
import com.haitrvn.navigation.Navigator
import cookapp.resources.auth.Res
import cookapp.resources.auth.ic_cyclone1
import cookapp.resources.auth.ic_login_socical_apple
import cookapp.resources.auth.ic_login_socical_facebook
import cookapp.resources.auth.ic_login_socical_google
import cookapp.resources.auth.login_button_login_with_apple
import cookapp.resources.auth.login_button_login_with_email
import cookapp.resources.auth.login_button_login_with_facebook
import cookapp.resources.auth.login_button_login_with_google
import cookapp.resources.auth.login_text_no_account
import cookapp.resources.auth.login_text_signup
import org.koin.compose.koinInject

const val TAG_SIGNUP = "signup"
private val PADDING_ALL_SIDES = 32.dp
private val PADDING_BOTTOM_TEXT = 53.dp

@Composable
fun Login(
    navigator: Navigator,
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,
) {
    val loginViewModel = koinInject<LoginViewModel>()
    with(sharedTransitionScope) {
        val sharedImageModifier = Modifier.sharedBounds(
            sharedContentState = rememberSharedContentState(key = "mainImage"),
            animatedVisibilityScope = animatedVisibilityScope,
        )
        LoginWrapper(
            modifier = Modifier.fillMaxSize(),
            sentEvent = loginViewModel::dispatch,
            loginEmail = { navigator.navigate(Auth.LoginWithEmail) },
            loginGoogle = {},
            loginApple = {},
            gotoSignup = { navigator.navigate(Auth.Register) },
        )
    }
}

@Composable
internal fun LoginWrapper(
    modifier: Modifier = Modifier,
    sentEvent: (LoginAction) -> Unit = {},
    goBack: () -> Unit = {},
    gotoSignup: () -> Unit = {},
    loginGoogle: () -> Unit = {},
    loginApple: () -> Unit = {},
    loginEmail: () -> Unit = {},
) {
    Column(modifier = modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxWidth().fillMaxHeight(0.75f)) {
            Drop(modifier = modifier.fillMaxSize(), side = Side.TOP, offset = 0.dp) {
                CookImage(
                    modifier = Modifier.fillMaxSize(),
                    source = Res.drawable.ic_login_socical_apple
                )
            }
            AppIcon(
                modifier = Modifier.padding(top = PADDING_ALL_SIDES).fillMaxWidth(),
                color = Color.Black
            )
            Box(
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 22.dp,
                    )
                    .size(100.dp)
                    .align(Alignment.TopStart)
                    .clip(CircleShape)
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                        onClick = { goBack() }
                    ),
                contentAlignment = Alignment.Center
            ) {
                HeaderText(
                    modifier = Modifier,
                    text = "<",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                )
            }
        }
        Column(modifier = Modifier.fillMaxSize()) {
            CookPrimaryButton("Login") {

            }
            Row(modifier = Modifier.fillMaxWidth()) {
                CookPrimaryButton(modifier = Modifier.fillMaxWidth().weight(0.5f), text = "G") {}
                CookPrimaryButton(modifier = Modifier.fillMaxWidth().weight(0.5f), text = "A") {}
            }
        }
    }
}

@Composable
internal fun LoginWithSocial(
    modifier: Modifier = Modifier,
    loginGoogle: () -> Unit = {},
    loginFacebook: () -> Unit = {},
    loginApple: () -> Unit = {},
    loginEmail: () -> Unit = {},
) {
    Column(modifier = modifier.fillMaxWidth().padding(horizontal = 30.dp)) {
        SocialButton(
            text = Res.string.login_button_login_with_google.toText(),
            icon = Res.drawable.ic_login_socical_google,
            background = googleLoginBackground,
            textColor = googleLoginText,
        ) {
            loginGoogle()
        }
        SmallSpace()
        SocialButton(
            text = Res.string.login_button_login_with_facebook.toText(),
            icon = Res.drawable.ic_login_socical_facebook,
            background = facebookLoginBackground,
        ) {
            loginFacebook()
        }
        SmallSpace()
        SocialButton(
            text = Res.string.login_button_login_with_apple.toText(),
            icon = Res.drawable.ic_login_socical_apple,
            background = appleLoginBackground,
        ) {
            loginApple()
        }
        SmallSpace()
        SocialButton(
            text = Res.string.login_button_login_with_email.toText(),
            icon = Res.drawable.ic_cyclone1,
        ) {
            loginEmail()
        }
    }
}

@Composable
internal fun LoginQuestion(
    modifier: Modifier = Modifier,
    gotoSignup: () -> Unit
) {
    val textSegments = listOf(
        SegmentText(text = Res.string.login_text_no_account.toText()),
        SegmentText(text = " "),
        SegmentText(
            text = Res.string.login_text_signup.toText(),
            isClickable = true,
            tag = TAG_SIGNUP
        ),
    )
    MultiClickableText(textSegments = textSegments, onClick = { tag ->
        when (tag) {
            TAG_SIGNUP -> {
                gotoSignup()
            }

            else -> {}
        }
    }) { _, text ->
        TextSmall(modifier = modifier, text = text)
    }
}