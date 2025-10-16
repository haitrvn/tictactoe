package com.haitrvn.cookapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.rememberNavBackStack
import com.haitrvn.coreui.Label
import com.haitrvn.coreui.Text
import com.haitrvn.navigation.CustomNavDisplay
import com.haitrvn.navigation.Screen

class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            App(modifier = Modifier.safeContentPadding())
            val backStack = rememberNavBackStack(elements = arrayOf(Screen.Auth))

            CustomNavDisplay(backStack = backStack, entryProvider = { key ->
                when (key) {
                    is Screen.Auth -> NavEntry(key = key) {
                        Text.Label(text = "HOME")
                    }

                    is Screen.Home -> NavEntry(key = key) {
                        Text.Label(text = "HOME")
                    }

                    else -> throw IllegalArgumentException("Unknown key: $key")
                }
            })
        }
    }
}
