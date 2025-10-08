@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.haitrvn.auth

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.Button
import com.haitrvn.coreui.Curved
import com.haitrvn.coreui.Header
import com.haitrvn.coreui.Image
import com.haitrvn.coreui.Input
import com.haitrvn.coreui.LargeSpace
import com.haitrvn.coreui.MediumSpace
import com.haitrvn.coreui.Paragraph
import com.haitrvn.coreui.SmallSpace
import com.haitrvn.coreui.Text
import com.haitrvn.coreui.theme.Space
import com.haitrvn.coreui.utils.ScreenSizeType
import com.haitrvn.coreui.utils.rememberScreenSizeType
import com.haitrvn.coreui.utils.toText
import com.haitrvn.navigation.Auth
import com.haitrvn.navigation.Navigator
import cookapp.resources.auth.Res
import cookapp.resources.auth.ic_login_socical_apple
import cookapp.resources.auth.ic_login_socical_google
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
            .padding(Space.large),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (rememberScreenSizeType() == ScreenSizeType.Large) {
            Image(
                modifier = Modifier.fillMaxWidth(0.8f).aspectRatio(1f),
                source = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRGnkz7LPNNnGZX1eG9Is04eyoMh6WCb8sd3Q&s",
            )
            MediumSpace()
        }
        Text.Header(text = stringResource(Res.string.login_title))
        MediumSpace()
        Input.Text(modifier = Modifier.padding(top = Space.medium), value = "", onValueChange = {

        })
        SmallSpace()
        Input.Text(modifier = Modifier.padding(top = Space.medium), value = "", onValueChange = {

        })
        SmallSpace()
        Text.Paragraph(text = Res.string.login_forgot_password.toText())
        MediumSpace()
        Button.Curved(
            modifier = Modifier.fillMaxWidth(),
            text = Res.string.login_button_login.toText()
        ) {

        }
        LargeSpace()
        Box(modifier = Modifier.fillMaxWidth(0.6f).height(1.dp).background(Color.Black))
        LargeSpace()
        Row(
            modifier = Modifier.fillMaxWidth().height(30.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Image(
                modifier = Modifier.fillMaxHeight().aspectRatio(1f),
                source = Res.drawable.ic_login_socical_google
            )
            Image(
                modifier = Modifier.fillMaxHeight().aspectRatio(1f),
                source = Res.drawable.ic_login_socical_apple
            )
        }
    }
}