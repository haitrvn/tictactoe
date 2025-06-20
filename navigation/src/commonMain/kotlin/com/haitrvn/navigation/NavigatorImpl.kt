package com.haitrvn.navigation

import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest

internal class NavigatorImpl(
    private val navigator: NavController
) : Navigator {
    override fun navigate(
        destination: Destination,
        popUpToRoute: String?,
        popUpToInclusive: Boolean,
        popUpToSaveState: Boolean,
        launchSingleTop: Boolean,
        restoreState: Boolean,
    ) {
        navigator.navigate(destination) {
            popUpToRoute?.let { route ->
                popUpTo(route) {
                    inclusive = popUpToInclusive
                    saveState = popUpToSaveState
                }
            }
            this.launchSingleTop = launchSingleTop
            this.restoreState = restoreState
        }
    }

    override fun popBackStack(
        destination: Destination?,
        inclusive: Boolean,
        saveState: Boolean
    ) {
        destination?.let {
            navigator.popBackStack(destination, inclusive, saveState)
        } ?: navigator.popBackStack()
    }

    override fun clearBackStack(destination: Destination) {
        navigator.clearBackStack(destination)
    }

    override fun handleDeeplink(deeplink: String) {
        navigator.handleDeepLink(NavDeepLinkRequest.Builder.fromAction(deeplink).build())
    }
}