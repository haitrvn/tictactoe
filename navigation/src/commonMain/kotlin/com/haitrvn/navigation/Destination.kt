package com.haitrvn.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface Screen : NavKey

interface ShowBottomBar

@Serializable
data object Auth : Screen {
    @Serializable
    data object Welcome : Screen

    @Serializable
    data object Login : Screen

    @Serializable
    data object LoginWithEmail : Screen

    @Serializable
    data object Register : Screen
}


@Serializable
data object Main : Screen {
    @Serializable
    data object Home : Screen, ShowBottomBar {
        @Serializable
        data object Home1 : Screen

        @Serializable
        data object Home2 : Screen
    }

    @Serializable
    data object Search : Screen, ShowBottomBar {
        @Serializable
        data object Search1 : Screen
    }

    @Serializable
    data object Notification : Screen, ShowBottomBar {
        @Serializable
        data object Notification1 : Screen

        @Serializable
        data class Detail(val id: String) : Screen
    }

    @Serializable
    data object Setting : Screen, ShowBottomBar {
        @Serializable
        data object Setting1 : Screen

        @Serializable
        data object Setting2 : Screen
    }
}