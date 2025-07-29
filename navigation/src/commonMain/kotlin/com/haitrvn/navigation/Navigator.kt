package com.haitrvn.navigation

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

interface Navigator {
    fun navigate(
        destination: Destination,
        popUpToRoute: Destination? = null,
        popUpToInclusive: Boolean = false,
        popUpToSaveState: Boolean = false,
        launchSingleTop: Boolean = true,
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