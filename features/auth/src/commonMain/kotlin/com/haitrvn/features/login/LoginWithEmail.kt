package com.haitrvn.features.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.CookParagraphText
import com.haitrvn.coreui.CookImage
import com.haitrvn.coreui.CookSurface
import com.haitrvn.coreui.CookBigPrimaryButton
import com.haitrvn.coreui.CookTextInput
import com.haitrvn.coreui.theme.CookTheme
import com.haitrvn.navigation.Home
import com.haitrvn.navigation.Navigator
import cookapp.resources.auth.Res
import cookapp.resources.auth.ic_cyclone1
import cookapp.resources.auth.login_hint_email_or_username
import cookapp.resources.auth.login_hint_password
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.koinInject

@Composable
fun LoginWithEmail(
    modifier: Modifier = Modifier,
    viewmodel: LoginViewModel = koinInject<LoginViewModel>(),
    navigator: Navigator,
) {
    val loginState by viewmodel.uiState.collectAsState()
    CookSurface(modifier = Modifier.fillMaxSize().then(modifier)) {
        Background()
        Column(
            modifier = Modifier.fillMaxSize().padding(horizontal = 30.dp).then(modifier),
            verticalArrangement = Arrangement.Center
        ) {
            Header()
            InputUserName(
                value = loginState.username, errorMessage = loginState.usernameErrorMessage
            ) {
                viewmodel.dispatch(LoginAction.UsernameChanged(it))
            }
            InputPassword(
                value = loginState.password,
                errorMessage = loginState.passwordErrorMessage,
            ) {
                viewmodel.dispatch(LoginAction.PasswordChanged(it))
            }
            ErrorMessages(errorMessage = loginState.errorMessage)
            CookBigPrimaryButton("Login") {
                viewmodel.dispatch(LoginAction.LoginClicked)
            }
            CookBigPrimaryButton("Register") {
                navigator.navigate(Home.Setting)
            }
        }
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
    CookParagraphText(text = "Login")
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
        CookParagraphText(text = errorMessage)
    }
}

@Composable
private fun LoginButtons() {

}