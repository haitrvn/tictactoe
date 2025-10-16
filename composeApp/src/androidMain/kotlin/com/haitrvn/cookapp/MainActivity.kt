package com.haitrvn.cookapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.rememberNavBackStack
import com.haitrvn.coreui.Button
import com.haitrvn.coreui.Primary
import com.haitrvn.navigation.CustomNavDisplay
import com.haitrvn.navigation.Screen

class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val backStack = rememberNavBackStack(elements = arrayOf(Screen.Auth))

            CustomNavDisplay(backStack = backStack, entryProvider = { key ->
                when (key) {
                    is Screen.Auth -> NavEntry(key = key) {
                        Button.Primary(text = "go to Home") {
                            backStack.add(Screen.Home)
                        }
                    }

                    is Screen.Home -> NavEntry(key = key) {
                        Button.Primary(text = "go to Auth") {
                            backStack.removeLastOrNull()
                        }
                    }

                    else -> throw IllegalArgumentException("Unknown key: $key")
                }
            })
        }
    }
}
