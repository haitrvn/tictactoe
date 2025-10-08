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
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import com.haitrvn.coreui.Button
import com.haitrvn.coreui.Curved
import com.haitrvn.coreui.Float
import com.haitrvn.coreui.Header
import com.haitrvn.coreui.Image
import com.haitrvn.coreui.MultiClickableText
import com.haitrvn.coreui.Paragraph
import com.haitrvn.coreui.SegmentText
import com.haitrvn.coreui.Text
import com.haitrvn.coreui.Title
import com.haitrvn.coreui.theme.Shapes
import com.haitrvn.coreui.theme.Space
import com.haitrvn.coreui.utils.toText
import com.haitrvn.navigation.Auth
import com.haitrvn.navigation.Navigator
import cookapp.resources.auth.Res
import cookapp.resources.auth.ic_login_socical_apple
import cookapp.resources.auth.ic_login_socical_google
import cookapp.resources.auth.register_with_email
import kotlinx.collections.immutable.persistentListOf

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
            .padding(Space.screenPadding)
    ) {
        Button.Float(
            modifier = Modifier.fillMaxHeight(0.09f).aspectRatio(1f),
            text = "<"
        ) {
            goBack()
        }
        Box(
            modifier = Modifier.fillMaxWidth()
                .weight(0.8f)
                .padding(top = Space.medium)
        ) {
            Image(
                modifier = Modifier.fillMaxSize().clip(shape = Shapes.medium),
                source = welcomeUiState.login.imageUrl,
            )
            Box(
                modifier = Modifier.fillMaxSize().clip(shape = Shapes.medium)
                    .background(Color.Black.copy(0.5f))
            ) {
                Column(
                    modifier = Modifier.padding(Space.medium).fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text.Header(
                        text = welcomeUiState.login.title,
                    )
                    Text.Paragraph(
                        text = welcomeUiState.login.description,
                    )
                }
            }
        }
        Column(
            modifier = Modifier.fillMaxWidth().weight(0.2f).padding(top = Space.medium),
        ) {
            val density = LocalDensity.current
            Button.Curved(
                modifier = Modifier.fillMaxWidth(),
                onClick = registerWithEmail
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier.padding(end = Space.small)
                            .aspectRatio(1f),
                        source = Res.drawable.ic_login_socical_apple
                    )
                    Text.Paragraph(
                        text = Res.string.register_with_email.toText(),
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth().padding(top = Space.small),
                horizontalArrangement = Arrangement.spacedBy(Space.small),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Button.Curved(
                    modifier = Modifier.weight(0.5f),
                    onClick = loginWithApple,
                ) {
                    Image(
                        source = Res.drawable.ic_login_socical_apple
                    )
                }
                Button.Curved(
                    modifier = Modifier.weight(0.5f),
                    onClick = loginWithGoogle,
                ) {
                    Image(
                        source = Res.drawable.ic_login_socical_google
                    )
                }
            }
            MultiClickableText(
                modifier = Modifier.fillMaxWidth(),
                textSegments = persistentListOf(
                    SegmentText("Have a account?"),
                    SegmentText("Login", tag = "login", isClickable = true)
                ),
                onClick = {
                    if (it == "login") {
                        loginWithEmail()
                    }
                }
            ) { modifier, text ->
                Text.Title(
                    modifier = modifier.fillMaxWidth(),
                    string = text,
                )
            }
        }
    }
}