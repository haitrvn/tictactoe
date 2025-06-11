package com.haitrvn.features.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.haitrvn.coreui.CommonText
import com.haitrvn.coreui.CommonTextField

@Composable
fun Login(
    modifier: Modifier = Modifier,
    viewmodel: LoginViewModel = remember { LoginViewModel() },
) {
    val loginState = viewmodel.uiState.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize().then(modifier)
    ) {
        CommonText(text = "Login")
        CommonTextField(value = loginState.value.username, placeholder = "Username") {
            viewmodel.dispatch(LoginAction.UsernameChanged(it))
        }
        CommonTextField(value = loginState.value.password, placeholder = "Password") {
            viewmodel.dispatch(LoginAction.PasswordChanged(it))
        }
    }
}