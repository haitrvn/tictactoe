package com.haitrvn.navigation

import kotlinx.serialization.Serializable

sealed interface Destination {
    val deeplinkPattern: String?
        get() = null
}

@Serializable
data object Auth : Destination {
    @Serializable
    data object Welcome : Destination

    @Serializable
    data object Login : Destination

    @Serializable
    data object LoginWithEmail : Destination

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