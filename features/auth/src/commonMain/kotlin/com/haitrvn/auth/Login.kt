@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.haitrvn.auth

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.haitrvn.coreui.Button
import com.haitrvn.coreui.Curved
import com.haitrvn.coreui.Header
import com.haitrvn.coreui.Image
import com.haitrvn.coreui.Input
import com.haitrvn.coreui.Paragraph
import com.haitrvn.coreui.Text
import com.haitrvn.coreui.theme.Space
import com.haitrvn.coreui.utils.ScreenSizeType
import com.haitrvn.coreui.utils.rememberScreenSizeType
import com.haitrvn.coreui.utils.toText
import com.haitrvn.navigation.Auth
import com.haitrvn.navigation.Navigator
import cookapp.resources.auth.Res
import cookapp.resources.auth.login_button_login
import cookapp.resources.auth.login_forgot_password
import cookapp.resources.auth.login_title
import kotlinx.collections.immutable.persistentListOf
import org.jetbrains.compose.resources.stringResource

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navigator: Navigator,
) {
    val welcomeUiState = WelcomeUiState(
        login = WelcomePageUi(title = "Title", description = "Description", imageUrl = ""),
        pages = persistentListOf()
    )
    LoginScreen(
        modifier = modifier,
        welcomeUiState = welcomeUiState,
        registerWithEmail = { navigator.navigate(Auth.Register) },
        loginWithEmail = { navigator.navigate(Auth.LoginWithEmail) },
        loginWithGoogle = { },
        loginWithApple = { },
    )
}

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    welcomeUiState: WelcomeUiState,
    goBack: () -> Unit = {},
    registerWithEmail: () -> Unit = {},
    loginWithEmail: () -> Unit = {},
    loginWithGoogle: () -> Unit = {},
    loginWithApple: () -> Unit = {},
) {
    Column(
        modifier = modifier.fillMaxSize()
            .padding(Space.medium)
    ) {
        if (rememberScreenSizeType() == ScreenSizeType.Large) {
            Image(
                modifier = Modifier.fillMaxWidth(0.5f).aspectRatio(1f),
                source = "",
            )
        }
        Text.Header(text = stringResource(Res.string.login_title))
        Input.Text(modifier = Modifier.padding(top = Space.medium), value = "", onValueChange = {

        })
        Input.Text(modifier = Modifier.padding(top = Space.medium), value = "", onValueChange = {

        })
        Text.Paragraph(text = Res.string.login_forgot_password.toText())
        Button.Curved(text = Res.string.login_button_login.toText()) {

        }
        Row {

        }
    }
}