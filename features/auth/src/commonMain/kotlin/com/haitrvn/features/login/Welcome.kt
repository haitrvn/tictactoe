package com.haitrvn.features.login

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.haitrvn.navigation.Auth
import com.haitrvn.navigation.Navigator

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

    Box(modifier = Modifier.fillMaxSize().then(modifier)) {
        Background()
        Column(modifier = Modifier.fillMaxSize().then(modifier)) {
            Header(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(headerScaleY.value)
                    .background(Color.Red)
            )
            AnimatedVisibility(
                visible = !isDoAnimate,
                exit = androidx.compose.animation.fadeOut(
                    animationSpec = tween(
                        durationMillis = 900,
                        easing = FastOutLinearInEasing
                    )
                )
            ) {
                Footer { isDoAnimate = true }
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

@Composable
private fun Background(modifier: Modifier = Modifier) {
    modifier.background(Color.Gray)
}

@Composable
private fun Header(modifier: Modifier = Modifier) {
    Box(modifier = modifier)
}

@Composable
fun Footer(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(
        onClick = { onClick() },
    ) {
        Text("Login Di chuyển lên")
    }
}