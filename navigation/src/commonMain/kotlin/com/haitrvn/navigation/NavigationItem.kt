package com.haitrvn.navigation

import org.jetbrains.compose.resources.DrawableResource

data class NavigationItem(
    val unSelectedIcon: DrawableResource,
    val selectedIcon: DrawableResource,
    val title: String,
    val destination: Destination
)