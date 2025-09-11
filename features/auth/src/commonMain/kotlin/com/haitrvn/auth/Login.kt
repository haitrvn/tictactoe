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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import com.haitrvn.coreui.CookImage
import com.haitrvn.coreui.CurvedButton
import com.haitrvn.coreui.HeaderText2
import com.haitrvn.coreui.RoundButton
import com.haitrvn.coreui.TextParagraph
import com.haitrvn.coreui.theme.CookTheme
import com.haitrvn.coreui.utils.toText
import com.haitrvn.navigation.Auth
import com.haitrvn.navigation.Navigator
import cookapp.resources.auth.Res
import cookapp.resources.auth.ic_login_socical_apple
import cookapp.resources.auth.register_with_email
import kotlinx.collections.immutable.persistentListOf

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navigator: Navigator
) {
    val welcomeUiState = WelcomeUiState(
        login = WelcomePageUi(title = "Title", description = "Description", imageUrl = ""),
        pages = persistentListOf()
    )
    LoginScreen(
        modifier = modifier,
        welcomeUiState = welcomeUiState,
        loginWithEmail = { navigator.navigate(Auth.Login) },
        loginWithGoogle = { navigator.navigate(Auth.Login) },
        loginWithApple = { navigator.navigate(Auth.Login) },
    )
}

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    welcomeUiState: WelcomeUiState,
    goBack: () -> Unit = {},
    loginWithEmail: () -> Unit = {},
    loginWithGoogle: () -> Unit = {},
    loginWithApple: () -> Unit = {},
) {
    Column(
        modifier = modifier.fillMaxSize()
            .padding(CookTheme.space.medium)
    ) {
        RoundButton(
            modifier = Modifier.fillMaxHeight(0.09f).aspectRatio(1f),
            text = "<"
        ) {
            goBack()
        }
        Box(
            modifier = Modifier.fillMaxWidth()
                .weight(0.8f)
                .padding(top = CookTheme.space.medium)
        ) {
            CookImage(
                modifier = Modifier.fillMaxSize().clip(shape = CookTheme.shapes.medium),
                source = welcomeUiState.login.imageUrl,
            )
            Box(
                modifier = Modifier.fillMaxSize().clip(shape = CookTheme.shapes.medium)
                    .background(Color.Black.copy(0.5f))
            ) {
                Column(
                    modifier = Modifier.padding(CookTheme.space.medium).fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    HeaderText2(
                        text = welcomeUiState.login.title,
                    )
                    TextParagraph(
                        text = welcomeUiState.login.description,
                    )
                }
            }
        }
        Column(
            modifier = Modifier.fillMaxWidth().weight(0.2f).padding(top = CookTheme.space.medium),
        ) {
            CurvedButton(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val density = LocalDensity.current

                    val textHeight = with(density) {
                        CookTheme.typography.paragraph.fontSize.toDp()
                    }
                    CookImage(
                        modifier = Modifier.padding(end = CookTheme.space.small)
                            .height(textHeight)
                            .aspectRatio(1f),
                        source = Res.drawable.ic_login_socical_apple
                    )
                    TextParagraph(
                        text = Res.string.register_with_email.toText(),
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth().padding(top = CookTheme.space.small),
                horizontalArrangement = Arrangement.spacedBy(CookTheme.space.small),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                CurvedButton(
                    modifier = Modifier.weight(0.5f),
                ) {

                }
                CurvedButton(
                    modifier = Modifier.weight(0.5f),
                ) {

                }
            }
        }
    }
}