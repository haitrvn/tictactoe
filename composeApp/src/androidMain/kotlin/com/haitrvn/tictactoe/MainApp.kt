package com.haitrvn.tictactoe

import android.app.Application
import com.haitrvn.data.di.dataModule
import com.haitrvn.features.login.di.loginModule
import com.haitrvn.navigation.di.navigationMode
import org.koin.core.context.startKoin

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(loginModule, dataModule, navigationMode)
        }
    }
}