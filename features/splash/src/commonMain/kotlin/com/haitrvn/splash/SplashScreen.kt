package com.haitrvn.splash

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.component.Heading
import com.haitrvn.coreui.component.Image
import com.haitrvn.coreui.component.Normal
import com.haitrvn.coreui.component.Text
import com.haitrvn.coreui.theme.AppColors
import com.haitrvn.coreui.utils.toText
import cookapp.resources.splash.Res
import cookapp.resources.splash.app_name
import cookapp.resources.splash.ic_app_logo
import cookapp.resources.splash.ic_loading
import kotlinx.coroutines.delay
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun SplashScreen(modifier: Modifier = Modifier, onStartClick: () -> Unit = {}) {
    LaunchedEffect(Unit) {
        delay(3000L)
        onStartClick()
    }

    val infiniteTransition = rememberInfiniteTransition()
    val rotate by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(667, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image.Normal(
                modifier = Modifier.size(120.dp),
                source = Res.drawable.ic_app_logo,
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text.Heading(
                text = Res.string.app_name.toText(),
                textAlign = TextAlign.Center,
                color = Color.Black
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 64.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Image.Normal(
                modifier = Modifier
                    .size(48.dp)
                    .graphicsLayer { rotationZ = rotate },
                source = Res.drawable.ic_loading,
            )
        }
    }
}