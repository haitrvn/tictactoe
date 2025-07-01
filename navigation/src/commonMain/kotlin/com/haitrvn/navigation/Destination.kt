package com.haitrvn.navigation

import kotlinx.serialization.Serializable

sealed interface Destination {
    val deeplinkPattern: String?
        get() = null
}

@Serializable
data object Auth : Destination {
    @Serializable
    data class Login(val email: String = "") : Destination

    @Serializable
    data class Register(val email: String = "") : Destination
}

interface HaveBottomBar

interface HomeDestination: Destination, HaveBottomBar

@Serializable
data object Home : HomeDestination {
    @Serializable
    data object Main : HomeDestination

    @Serializable
    data object Search : HomeDestination

    @Serializable
    data object Setting : HomeDestination
}