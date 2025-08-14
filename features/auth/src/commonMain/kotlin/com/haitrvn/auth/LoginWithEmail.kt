package com.haitrvn.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.AuthInput
import com.haitrvn.coreui.CookImage
import com.haitrvn.coreui.CookPrimaryButton
import com.haitrvn.coreui.CookSurface
import com.haitrvn.coreui.MultiClickableText
import com.haitrvn.coreui.SegmentText
import com.haitrvn.coreui.HeaderText2
import com.haitrvn.coreui.LargeSpace
import com.haitrvn.coreui.SmallSpace
import com.haitrvn.coreui.TextParagraph
import com.haitrvn.coreui.TextSmall
import com.haitrvn.coreui.theme.CookTheme
import com.haitrvn.coreui.utils.toText
import com.haitrvn.navigation.Auth
import com.haitrvn.navigation.Main
import com.haitrvn.navigation.Navigator
import cookapp.resources.auth.Res
import cookapp.resources.auth.ic_cyclone1
import cookapp.resources.auth.login_button_login
import cookapp.resources.auth.login_hint_email_or_username
import cookapp.resources.auth.login_hint_password
import cookapp.resources.auth.login_text_forgot_password

@Composable
fun LoginWithEmail(
    navigator: Navigator
) {
    LoginWithEmailWrapper(
        goToHome = {
            navigator.navigate(Main, Auth, popUpToInclusive = true)
        }
    )
}

@Composable
fun LoginWithEmailWrapper(
    modifier: Modifier = Modifier,
    goToHome: () -> Unit = {},
    gotoSignup: () -> Unit = {},
    gotoForgotPassword: () -> Unit = {},
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxSize().padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CookImage(
            modifier = Modifier.fillMaxWidth().aspectRatio(1f),
            drawableResource = Res.drawable.ic_cyclone1
        )
        HeaderText2(text = Res.string.login_hint_email_or_username.toText())
        LargeSpace()
        AuthInput(
            value = username,
            label = Res.string.login_hint_email_or_username.toText(),
            error = "This is mock error",
            onValueChange = { username = it })
        SmallSpace()
        AuthInput(
            value = password,
            label = Res.string.login_hint_password.toText(),
            isPasswordVisible = false,
            onValueChange = { password = it },
        )
        SmallSpace()
        CookPrimaryButton(
            text = Res.string.login_button_login.toText()
        ) {
            goToHome()
        }
        LargeSpace()
        ForgotPassword { gotoForgotPassword }
        LoginQuestion { gotoSignup() }
    }
}

@Composable
private fun Background(modifier: Modifier = Modifier) {
    CookSurface(
        modifier = Modifier
            .background(color = CookTheme.colors.primary)
            .then(modifier)
    ) {
        CookImage(
            modifier = Modifier,
            drawableResource = Res.drawable.ic_cyclone1,
        )
    }
}

@Composable
private fun Header(modifier: Modifier = Modifier) {
    TextParagraph(text = "Login")
}

@Composable
private fun ErrorMessages(
    modifier: Modifier = Modifier,
    errorMessage: String,
) {
    if (errorMessage.isNotEmpty()) {
        TextParagraph(text = errorMessage)
    }
}

@Composable
private fun LoginButtons() {

}

const val TAG_FORGOT_PASSWORD = "forgot_password"

@Composable
internal fun ForgotPassword(
    modifier: Modifier = Modifier,
    gotoForgotPassword: () -> Unit
) {
    val textSegments = listOf(
        SegmentText(
            text = Res.string.login_text_forgot_password.toText(),
            tag = TAG_FORGOT_PASSWORD,
            isClickable = true
        ),
    )
    MultiClickableText(textSegments = textSegments, onClick = { tag ->
        when (tag) {
            TAG_FORGOT_PASSWORD -> {
                gotoForgotPassword()
            }

            else -> {}
        }
    }) { _, text ->
        TextSmall(modifier = modifier, text = text)
    }
}