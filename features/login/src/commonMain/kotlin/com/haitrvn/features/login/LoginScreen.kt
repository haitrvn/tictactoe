package com.haitrvn.features.login

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.haitrvn.navigation.Navigator
import com.haitrvn.navigation.Screen
import com.haitrvn.navigation.arg.LoginScreenArgument

class LoginScreen : Screen.Login {
    @Composable
    override fun content(
        modifier: Modifier,
        navigator: Navigator,
        arg: LoginScreenArgument?
    ) {
        Login(
            modifier = modifier,
            navigator = navigator,
            arg = arg
        )
    }
}