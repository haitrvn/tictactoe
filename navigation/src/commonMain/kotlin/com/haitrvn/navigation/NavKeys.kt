package com.haitrvn.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSerializable
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.serialization.NavBackStackSerializer
import androidx.savedstate.serialization.SavedStateConfiguration
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.Serializable

@Serializable
sealed interface Screen : NavKey {
    @Serializable
    data object Auth : Screen

    @Serializable
    open class Main : Screen, BottomNavShown {
        @Serializable
        data object Home : Main()

        @Serializable
        data object Saved : Main()

        @Serializable
        data object Notification : Main()

        @Serializable
        data object Setting : Main()
    }
}

interface BottomNavShown

@Composable
inline fun <reified T : NavKey> rememberNavBackStackFix(
    configuration: SavedStateConfiguration,
    vararg elements: T,
): NavBackStack<NavKey> {
    return rememberSerializable(
        configuration = configuration,
        serializer = NavBackStackSerializer(PolymorphicSerializer(NavKey::class)),
    ) {
        NavBackStack(*elements)
    }
}