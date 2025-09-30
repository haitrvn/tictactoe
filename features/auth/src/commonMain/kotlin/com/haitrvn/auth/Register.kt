package com.haitrvn.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.haitrvn.coreui.Button
import com.haitrvn.coreui.Curved
import com.haitrvn.coreui.Text
import com.haitrvn.coreui.Title
import com.haitrvn.coreui.theme.CookTheme

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
            Button.Curved(
                modifier = Modifier.fillMaxHeight(0.085f).aspectRatio(1f),
                text = "<"
            ) {
                goBack()
            }
            Text.Title(modifier = Modifier.padding(CookTheme.space.medium).clickable {
                goToLogin()
            }, text = "Login")
        }
        Column(modifier = Modifier.fillMaxWidth()) {
        }
    }
}
