package com.haitrvn.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.haitrvn.coreui.component.OnPrimaryText
import com.haitrvn.coreui.theme.CookTheme
import cookapp.resources.splash.Res
import cookapp.resources.splash.bg_splash
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun PreviewSplashScreenLight() {
    CookTheme(systemIsDark = true) {
        SplashScreen { }
    }
}

@Preview
@Composable
fun PreviewSplashScreenDark() {
    CookTheme(systemIsDark = false) {
        SplashScreen { }
    }
}

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    onStartClick: () -> Unit
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(Res.drawable.bg_splash),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        OnPrimaryText(
            text = "Appétit"
        )
    }

    LaunchedEffect(Unit) {
        delay(2000)
        onStartClick()
    }
}
