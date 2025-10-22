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
    data object Register : Destination
}


@Serializable
data object Main : Destination {
    @Serializable
    data object Home : Destination {
        @Serializable
        data object Home1 : Destination

        @Serializable
        data object Home2 : Destination
    }

    @Serializable
    data object Search : Destination {
        @Serializable
        data object Search1 : Destination
    }

    @Serializable
    data object Notification : Destination {
        @Serializable
        data object Notification1 : Destination

        @Serializable
        data class Detail(val id: String) : Destination
    }

    @Serializable
    data object Setting : Destination {
        @Serializable
        data object Setting1 : Destination

        @Serializable
        data object Setting2 : Destination
    }
}