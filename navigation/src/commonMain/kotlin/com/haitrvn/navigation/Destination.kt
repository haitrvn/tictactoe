package com.haitrvn.navigation

import com.haitrvn.navigation.arg.LoginScreenArgument
import kotlinx.serialization.Serializable

sealed class Destination {
    @Serializable
    data class Login(
        val loginScreenArgument: LoginScreenArgument
    ) : Destination()

    @Serializable
    data object Home : Destination()

    @Serializable
    data object Setting : Destination()
}