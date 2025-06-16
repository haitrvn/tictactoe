package com.haitrvn.features.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.CommonButton
import com.haitrvn.coreui.CommonText
import com.haitrvn.coreui.CommonTextField
import org.koin.compose.koinInject

@Composable
fun Login(
    modifier: Modifier = Modifier,
    viewmodel: LoginViewModel = koinInject<LoginViewModel>(),
) {
    val loginState by viewmodel.uiState.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(horizontal = 30.dp)
            .then(modifier),
        verticalArrangement = Arrangement.Center
    ) {
        CommonText("Login")
        CommonTextField(value = loginState.username, placeholder = "Username") {
            viewmodel.dispatch(LoginAction.UsernameChanged(it))
        }
        CommonTextField(value = loginState.password, placeholder = "Password", isPassword = true) {
            viewmodel.dispatch(LoginAction.PasswordChanged(it))
        }
        if (loginState.errorMessage.isNotEmpty()) {
            CommonText(loginState.errorMessage)
        }
        CommonButton("Login") {
            viewmodel.dispatch(LoginAction.LoginClicked)
        }
        CommonButton("Register") { }
    }
}