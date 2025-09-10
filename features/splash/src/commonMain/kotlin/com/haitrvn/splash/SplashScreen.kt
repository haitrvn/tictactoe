package com.haitrvn.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.haitrvn.coreui.CookImage
import com.haitrvn.coreui.HeaderText2
import com.haitrvn.coreui.utils.toText
import cookapp.resources.splash.Res
import cookapp.resources.splash.splash_welcome

@Composable
fun SplashScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CookImage(modifier = Modifier.fillMaxSize(), source = "https://picsum.photos/200/300")
        HeaderText2(
            text = Res.string.splash_welcome.toText(),
        )
    }
}