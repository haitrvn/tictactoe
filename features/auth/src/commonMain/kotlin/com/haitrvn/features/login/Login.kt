package com.haitrvn.features.login

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.haitrvn.navigation.Auth
import com.haitrvn.navigation.Home
import com.haitrvn.navigation.Navigator
import org.koin.compose.koinInject

@Composable
fun Login(
    modifier: Modifier = Modifier,
    viewmodel: LoginViewModel = koinInject<LoginViewModel>(),
    navigator: Navigator,
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
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(animY.value)
                .background(Color.Red)
        )

        Button(
            onClick = { movedUp = true },
            modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 32.dp)
        ) {
            Text("Login Di chuyển lên")
        }

        Text(
            "Trạng thái animation: $animState",
            modifier = Modifier.align(Alignment.TopCenter)
        )
    }
}