package com.haitrvn.auth

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun RegisterScreen(modifier: Modifier = Modifier) {
    RegisterScreen(modifier = modifier, goBack = {}, registerWithEmail = {})
}

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    goBack: () -> Unit = {},
    registerWithEmail: () -> Unit = {},
    goToLogin: () -> Unit = {},
) {

}
