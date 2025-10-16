package com.haitrvn.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface Screen : NavKey {
    @Serializable
    data object Auth : Screen

    @Serializable
    sealed class Home : Screen, BottomNavShown {

    }
}

interface BottomNavShown