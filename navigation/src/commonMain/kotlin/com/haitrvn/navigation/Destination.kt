package com.haitrvn.navigation

import kotlinx.serialization.Serializable

sealed class Destination {
    @Serializable
    data object Login : Destination()

    @Serializable
    data object Setting : Destination()
}