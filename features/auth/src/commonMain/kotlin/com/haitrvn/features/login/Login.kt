@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.haitrvn.features.login

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.CookBigHeadTitle
import com.haitrvn.coreui.CookImage
import com.haitrvn.coreui.CookLabelText
import com.haitrvn.coreui.CookSurface
import com.haitrvn.coreui.CookTextButton
import com.haitrvn.navigation.Auth
import com.haitrvn.navigation.Home
import com.haitrvn.navigation.Navigator
import cookapp.resources.auth.Res
import cookapp.resources.auth.login_welcome_app_name
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.koinInject

@Composable
fun Login(
    modifier: Modifier = Modifier,
    viewmodel: LoginViewModel = koinInject<LoginViewModel>(),
    navigator: Navigator,
    sharedTransitionScope: SharedTransitionScope,
    animatedVisibilityScope: AnimatedVisibilityScope,
) {
    var movedUp by remember { mutableStateOf(false) }
    val animY = remember { Animatable(0.3f) }
    var animState by remember { mutableStateOf("Idle") }

    if (movedUp) {
        LaunchedEffect(Unit) {
            animState = "Started"
            animY.animateTo(
                targetValue = if (movedUp) 0.6f else 0.3f,
                animationSpec = tween(durationMillis = 1000)
            )
            navigator.navigate(Home)
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        with(sharedTransitionScope) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 32.dp, vertical = 48.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Header()
                CookTextButton(
                    text = "Get Started",
                    onClick = {
                        navigator.navigate(Auth.LoginWithEmail)
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Composable
private fun Header(modifier: Modifier = Modifier) {
    CookSurface(
        modifier = modifier
    ) {
        CookBigHeadTitle(
            modifier = Modifier,
            text = stringResource(Res.string.login_welcome_app_name),
        )
        CookLabelText(
            text = stringResource(Res.string.login_welcome_app_name),
        )
    }
}