package com.haitrvn.navigation.arg

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginScreenArgument(
    @SerialName("name")
    val name: String = ""
)