package com.haitrvn.navigation

import kotlinx.serialization.Serializable

sealed interface Destination

@Serializable
data object Auth : Destination {
    @Serializable
    data class Login(val email: String = "") : Destination

    @Serializable
    data class Register(val email: String = "") : Destination
}

@Serializable
data object Home : Destination {
    @Serializable
    data object Main : Destination

    @Serializable
    data object Search : Destination

    @Serializable
    data object Setting : Destination
}