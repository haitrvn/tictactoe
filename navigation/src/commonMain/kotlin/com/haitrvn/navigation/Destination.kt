package com.haitrvn.navigation

import kotlinx.serialization.Serializable

sealed interface Destination {
    val isBackable: Boolean
        get() = false
    val deeplinkPattern: String?
        get() = null
}

sealed interface BackableDestination : Destination {
    override val isBackable: Boolean
        get() = true
}

@Serializable
data object Auth : Destination {
    @Serializable
    data object Welcome : BackableDestination

    @Serializable
    data object Login : BackableDestination

    @Serializable
    data object LoginWithEmail : BackableDestination

    @Serializable
    data class Register(val email: String = "") : BackableDestination
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