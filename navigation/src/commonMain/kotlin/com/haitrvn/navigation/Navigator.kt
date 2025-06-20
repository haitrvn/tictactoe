package com.haitrvn.navigation

interface Navigator {
    fun navigate(
        destination: Destination,
        popUpToRoute: String? = null,
        popUpToInclusive: Boolean = false,
        popUpToSaveState: Boolean = false,
        launchSingleTop: Boolean = false,
        restoreState: Boolean = false,
    )

    fun popBackStack(
        destination: Destination? = null,
        inclusive: Boolean = false,
        saveState: Boolean = false
    )

    fun clearBackStack(destination: Destination)
    fun handleDeeplink(deeplink: String)
}