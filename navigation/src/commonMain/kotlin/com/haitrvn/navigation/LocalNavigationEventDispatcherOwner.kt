package com.haitrvn.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidedValue
import androidx.compose.runtime.compositionLocalOf
import androidx.navigationevent.NavigationEventDispatcher
import androidx.navigationevent.NavigationEventDispatcherOwner

object LocalNavigationEventDispatcherOwner {
    val LocalNavigationEventDispatcherOwner =
        compositionLocalOf<NavigationEventDispatcherOwner?> { null }

    /**
     * Returns current composition local value for the owner or `null` if one has not been provided
     * nor is one available via [findViewTreeNavigationEventDispatcherOwner] on the current
     * `androidx.compose.ui.platform.LocalView`.
     */
    val current: NavigationEventDispatcherOwner?
        @Composable
        get() =
            LocalNavigationEventDispatcherOwner.current ?:  object :NavigationEventDispatcherOwner {
                override val navigationEventDispatcher: NavigationEventDispatcher
                    get() = NavigationEventDispatcher()
            }

    /**
     * Associates a [LocalNavigationEventDispatcherOwner] key to a value in a call to
     * [CompositionLocalProvider].
     */
    infix fun provides(
        navigationEventDispatcherOwner: NavigationEventDispatcherOwner
    ): ProvidedValue<NavigationEventDispatcherOwner?> {
        return LocalNavigationEventDispatcherOwner.provides(navigationEventDispatcherOwner)
    }
}