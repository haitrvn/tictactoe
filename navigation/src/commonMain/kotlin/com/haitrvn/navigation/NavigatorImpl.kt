package com.haitrvn.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow

internal class NavigatorImpl(
    private val navigator: NavController,
) : Navigator {
    override val currentBackStackEntryFlow: MutableSharedFlow<Destination> =
        MutableSharedFlow(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)

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
        currentBackStackEntryFlow.tryEmit(destination)
    }

    override fun popBackStack(
        destination: Destination?,
        inclusive: Boolean,
        saveState: Boolean
    ) {
        destination?.let {
            navigator.popBackStack(destination, inclusive, saveState)
            currentBackStackEntryFlow.tryEmit(destination)
        } ?: navigator.popBackStack()
    }

    override fun clearBackStack(destination: Destination) {
        navigator.clearBackStack(destination)
        currentBackStackEntryFlow.tryEmit(destination)
    }

    override fun handleDeeplink(deeplink: String) {
        navigator.handleDeepLink(NavDeepLinkRequest.Builder.fromAction(deeplink).build())
    }
}

@Composable
public fun Navigator.currentDestinationAsState(): State<Destination?> {
    return currentBackStackEntryFlow.collectAsState(null)
}