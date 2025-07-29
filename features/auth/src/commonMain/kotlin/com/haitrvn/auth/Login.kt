@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.haitrvn.auth

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.CookImage
import com.haitrvn.coreui.CookSpace
import com.haitrvn.coreui.MultiClickableText
import com.haitrvn.coreui.SegmentText
import com.haitrvn.coreui.SocialButton
import com.haitrvn.coreui.SpaceSize
import com.haitrvn.coreui.TextBigTitle
import com.haitrvn.coreui.TextSmall
import com.haitrvn.coreui.theme.DarkColors
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
import cookapp.resources.auth.login_welcome_quote
import org.koin.compose.koinInject

const val TAG_SIGNUP = "signup"

@Composable
fun Login(
    navigator: Navigator
) {
    val loginViewModel = koinInject<LoginViewModel>()
    LoginWrapper(
        sentEvent = loginViewModel::dispatch,
        loginEmail = { navigator.navigate(Auth.LoginWithEmail) },
        loginGoogle = {},
        loginFacebook = {},
        loginApple = {},
        gotoSignup = { navigator.navigate(Auth.Register) }
    )
}

@Composable
internal fun LoginWrapper(
    modifier: Modifier = Modifier,
    sentEvent: (LoginAction) -> Unit = {},
    gotoSignup: () -> Unit = {},
    loginGoogle: () -> Unit = {},
    loginFacebook: () -> Unit = {},
    loginApple: () -> Unit = {},
    loginEmail: () -> Unit = {},
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
        TextBigTitle(text = Res.string.login_welcome_quote.toText())
        CookSpace(SpaceSize.SMALL)
        TextSmall(text = Res.string.login_welcome_quote.toText())
        CookSpace(SpaceSize.SMALL)
        LoginWithSocial(
            loginGoogle = loginGoogle,
            loginFacebook = loginFacebook,
            loginApple = loginApple,
            loginEmail = loginEmail
        )
        CookSpace(SpaceSize.MEDIUM)
        TextSmall(text = Res.string.login_welcome_quote.toText())
        LoginQuestion { gotoSignup() }

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
        CookSpace(SpaceSize.SMALL)
        SocialButton(
            text = Res.string.login_button_login_with_facebook.toText(),
            icon = Res.drawable.ic_login_socical_facebook,
            background = facebookLoginBackground,
        ) {
            loginFacebook()
        }
        CookSpace(SpaceSize.SMALL)
        SocialButton(
            text = Res.string.login_button_login_with_apple.toText(),
            icon = Res.drawable.ic_login_socical_apple,
            background = appleLoginBackground,
        ) {
            loginApple()
        }
        CookSpace(SpaceSize.SMALL)
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