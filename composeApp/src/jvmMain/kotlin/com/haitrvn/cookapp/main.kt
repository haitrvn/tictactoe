package com.haitrvn.cookapp

import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import org.koin.core.context.startKoin

fun main() = application {
    startKoin {
        modules(appModule)
    }
    Window(
        title = "VietCook",
        alwaysOnTop = true,
        state = rememberWindowState(width = 412.dp, height = 915.dp),
        onCloseRequest = ::exitApplication,
    ) {
        App()
    }
}

