package com.haitrvn.navigation

import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest
import com.haitrvn.core.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

internal class NavigatorImpl(
    private val navigator: NavController,
) : Navigator {

    init {
        CoroutineScope(Dispatchers.Default).launch {
            navigator.currentBackStack.collect { backStackEntry ->
                Log.d(
                    "Navigator",
                    "currentBackStackEntryFlow: ${backStackEntry.map { it.destination.route }}"
                )
            }
        }
    }

    override fun navigate(
        destination: Destination,
        popUpToRoute: Destination?,
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