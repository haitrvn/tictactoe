package com.haitrvn.navigation.arg

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class LoginScreenArgument(
    @SerialName("name")
    val name: String = ""
)