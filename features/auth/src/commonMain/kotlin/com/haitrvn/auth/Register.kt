package com.haitrvn.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.CookImage
import com.haitrvn.coreui.RoundButton
import com.haitrvn.coreui.TextTitle
import com.haitrvn.coreui.theme.CookTheme
import cookapp.resources.auth.Res
import cookapp.resources.auth.ic_login_socical_google

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
    Column(
        modifier = Modifier.padding(CookTheme.space.screenPadding).fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            RoundButton(
                modifier = Modifier.fillMaxHeight(0.085f).aspectRatio(1f),
                text = "<"
            ) {
                goBack()
            }
            TextTitle(modifier = Modifier.padding(CookTheme.space.medium).clickable {
                goToLogin()
            }, text = "Login")
        }
        Column(modifier = Modifier.fillMaxWidth()) {
        }
    }
}
