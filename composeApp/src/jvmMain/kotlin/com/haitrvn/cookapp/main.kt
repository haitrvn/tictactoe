package com.haitrvn.cookapp

import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.haitrvn.data.di.dataModule
import com.haitrvn.home.di.homeModule
import com.haitrvn.login.di.loginModule
import com.haitrvn.navigation.di.navigationMode
import org.koin.core.context.startKoin

fun main() = application {
    startKoin {
        modules(homeModule, loginModule, dataModule, navigationMode)
    }
    Window(
        title = "VietCook",
        alwaysOnTop = true,
        state = rememberWindowState(width = 350.dp, height = 600.dp),
        onCloseRequest = ::exitApplication,
    ) {
        App()
    }
}

