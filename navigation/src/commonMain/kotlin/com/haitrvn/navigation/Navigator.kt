package com.haitrvn.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

interface Navigator {
    suspend fun navigate(destination: Destination)
    suspend fun popBackStack()
}

sealed interface Destination {
    object Login : Destination
    object Home : Destination
}

internal class NavigatorImpl: Navigator {
    override suspend fun navigate(destination: Destination) {
        TODO("Not yet implemented")
    }

    override suspend fun popBackStack() {
        TODO("Not yet implemented")
    }
}

@Composable
fun Navigator(navigator: Navigator) {
    val navController = rememberNavController()
}