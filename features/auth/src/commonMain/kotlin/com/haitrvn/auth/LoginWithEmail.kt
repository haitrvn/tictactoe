package com.haitrvn.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.CookImage
import com.haitrvn.coreui.CookPrimaryButton
import com.haitrvn.coreui.CookSurface
import com.haitrvn.coreui.CookTextInput
import com.haitrvn.coreui.TextParagraph
import com.haitrvn.coreui.TextTitle
import com.haitrvn.coreui.theme.CookTheme
import com.haitrvn.navigation.Navigator
import cookapp.resources.auth.Res
import cookapp.resources.auth.ic_cyclone1
import cookapp.resources.auth.login_button_login
import cookapp.resources.auth.login_hint_email_or_username
import cookapp.resources.auth.login_hint_password
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.koinInject

@Composable
fun LoginWithEmailWrapper(
    navigator: Navigator
) {
    LoginWithEmail(navigator = navigator)
}

@Composable
fun LoginWithEmail(
    modifier: Modifier = Modifier,
    viewmodel: LoginViewModel = koinInject<LoginViewModel>(),
    navigator: Navigator,
) {
    Column(
        modifier = modifier.fillMaxSize().padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CookImage(
            modifier = Modifier.fillMaxWidth().aspectRatio(1f),
            drawableResource = Res.drawable.ic_cyclone1
        )
        TextTitle(text = stringResource(Res.string.login_hint_email_or_username))
        CookTextInput(value = "") {}
        CookTextInput(value = "") {}
        CookPrimaryButton(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(Res.string.login_button_login)
        ) {

        }
        TextTitle(text = stringResource(Res.string.login_hint_email_or_username))
        TextTitle(text = stringResource(Res.string.login_hint_email_or_username))
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
    CookTextInput(
        modifier = Modifier.then(modifier),
        value = value,
        isPassword = isPassword
    ) {
        onValueChange(it)
    }
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
    hint = stringResource(Res.string.login_hint_email_or_username),
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
    hint = stringResource(Res.string.login_hint_password),
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