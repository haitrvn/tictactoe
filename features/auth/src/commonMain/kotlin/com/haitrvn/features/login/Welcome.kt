package com.haitrvn.features.login

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.CookBodyText
import com.haitrvn.coreui.CookImage
import com.haitrvn.coreui.CookTextButton
import com.haitrvn.coreui.theme.CookTheme
import com.haitrvn.navigation.Auth
import com.haitrvn.navigation.Navigator
import cookapp.resources.auth.Res
import cookapp.resources.auth.ic_cyclone1

@Composable
fun Welcome(
    modifier: Modifier = Modifier,
    navigator: Navigator
) {
    var isDoAnimate by remember { mutableStateOf(false) }
    val headerScaleY = remember { Animatable(0.6f) }

    if (isDoAnimate) {
        moveImageUp(headerScaleY, isDoAnimate, navigator)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(CookTheme.colors.background)
            .then(modifier)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp, vertical = 48.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            CookImage(
                drawableResource = Res.drawable.ic_cyclone1,
                modifier = Modifier.height(120.dp)
            )
            Spacer(modifier = Modifier.height(32.dp))
            CookBodyText(
                text = "Welcome to PeepPreview!",
            )
            Spacer(modifier = Modifier.height(16.dp))
            CookBodyText(
                text = "Discover and share the best recipes with our community. Get started now!",
            )
            Spacer(modifier = Modifier.weight(1f))
            AnimatedVisibility(
                visible = !isDoAnimate,
                exit = androidx.compose.animation.fadeOut(
                    animationSpec = tween(
                        durationMillis = 900,
                        easing = FastOutLinearInEasing
                    )
                )
            ) {
                CookTextButton(
                    text = "Get Started",
                    onClick = { isDoAnimate = true },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Composable
private fun moveImageUp(
    animY: Animatable<Float, AnimationVector1D>,
    movedUp: Boolean,
    navigator: Navigator
) {
    LaunchedEffect(Unit) {
        animY.animateTo(
            targetValue = 0.3f,
            animationSpec = tween(durationMillis = 1000)
        )
        navigator.navigate(Auth.Login)
    }
}