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
import com.haitrvn.coreui.CookSpace
import com.haitrvn.coreui.CookSurface
import com.haitrvn.coreui.SpaceSize
import com.haitrvn.coreui.TextParagraph
import com.haitrvn.coreui.TextTitle
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
        AuthInput(
            value = username,
            label = Res.string.login_hint_email_or_username.toText(),
            onValueChange = { username = it })
        CookSpace(SpaceSize.SMALL)
        AuthInput(
            value = password,
            label = Res.string.login_hint_password.toText(),
            onValueChange = { password = it },
        )
        CookPrimaryButton(
            text = Res.string.login_button_login.toText()
        ) {
            goToHome()
        }
        TextTitle(text = Res.string.login_hint_email_or_username.toText())
        TextTitle(text = Res.string.login_hint_email_or_username.toText())
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
private fun BaseInput(
    modifier: Modifier = Modifier,
    value: String,
    hint: String,
    errorMessage: String,
    onValueChange: (String) -> Unit,
    isPassword: Boolean = false,
) {
}

@Composable
private fun InputUserName(
    modifier: Modifier = Modifier,
    value: String,
    errorMessage: String,
    onValueChange: (String) -> Unit,
) = BaseInput(
    modifier = modifier,
    value = value,
    hint = Res.string.login_hint_email_or_username.toText(),
    errorMessage = errorMessage,
    onValueChange = onValueChange,
)

@Composable
private fun InputPassword(
    modifier: Modifier = Modifier,
    value: String,
    errorMessage: String,
    onValueChange: (String) -> Unit,
) = BaseInput(
    modifier = modifier,
    value = value,
    hint = Res.string.login_hint_password.toText(),
    errorMessage = errorMessage,
    onValueChange = onValueChange,
    isPassword = true
)

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