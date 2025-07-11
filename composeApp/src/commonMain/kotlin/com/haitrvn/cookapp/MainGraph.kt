@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.haitrvn.cookapp

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.haitrvn.coreui.CookParagraphText
import com.haitrvn.features.home.DiscoverScreen
import com.haitrvn.features.login.Login
import com.haitrvn.features.login.LoginWithEmail
import com.haitrvn.features.login.Welcome2
import com.haitrvn.features.setting.Setting
import com.haitrvn.navigation.Auth
import com.haitrvn.navigation.Destination
import com.haitrvn.navigation.Home
import com.haitrvn.navigation.Navigator

@Composable
internal fun MainGraph(
    modifier: Modifier = Modifier,
    navigator: Navigator,
    navController: NavHostController,
    startDestination: Destination,
    sharedTransitionScope: SharedTransitionScope,
) {
    NavHost(
        modifier = Modifier.fillMaxSize().then(modifier),
        navController = navController,
        startDestination = startDestination
    ) {
        authGraph(
            navigator = navigator,
            sharedTransitionScope = sharedTransitionScope,
        )
        homeGraph(
            navigator = navigator,
            sharedTransitionScope = sharedTransitionScope,
        )
    }
}

internal fun NavGraphBuilder.homeGraph(
    modifier: Modifier = Modifier,
    navigator: Navigator,
    sharedTransitionScope: SharedTransitionScope,
) {
    navigation<Home>(startDestination = Home.Search) {
        composable<Home.Main> {
            CookParagraphText(text = "Main")
        }
        composable<Home.Search> {
            DiscoverScreen()
        }
        composable<Home.Setting> {
            Setting(onLogout = { navigator.navigate(Auth) })
        }
    }
}

internal fun NavGraphBuilder.authGraph(
    modifier: Modifier = Modifier,
    navigator: Navigator,
    sharedTransitionScope: SharedTransitionScope,
) {
    navigation<Auth>(startDestination = Auth.Welcome) {
        composable<Auth.Welcome>(
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None },
            popEnterTransition = { EnterTransition.None },
            popExitTransition = { ExitTransition.None }
        ) {
//            Welcome(
//                modifier = modifier,
//                navigator = navigator,
//                sharedTransitionScope = sharedTransitionScope,
//                animatedVisibilityScope = this@composable,
//            )
            Welcome2()
        }
        composable<Auth.Login> {
            Login(
                navigator = navigator,
                sharedTransitionScope = sharedTransitionScope,
                animatedVisibilityScope = this@composable,
            )
        }
        composable<Auth.LoginWithEmail> {
            LoginWithEmail(navigator = navigator)
        }
        composable<Auth.Register> {
            CookParagraphText(text = "Register")
        }
    }
}

private fun shouldSkipTransition(from: String?, to: String?): Boolean {
    val welcomeRoute = Auth.Welcome::class.qualifiedName.toString()
    val loginRoute = Auth.Login::class.qualifiedName.toString()
    return (from == welcomeRoute && to == loginRoute) || to == welcomeRoute || from == welcomeRoute
}

private fun getEnterTransition(
    initialState: NavBackStackEntry,
    targetState: NavBackStackEntry,
): EnterTransition {
    val from = initialState.destination.route
    val to = targetState.destination.route
    val welcomeRoute = Auth.Welcome::class.qualifiedName.toString()
    if (shouldSkipTransition(from, to)) {
        return EnterTransition.None
    }
    return slideInHorizontally(initialOffsetX = { if (to == welcomeRoute) -it else it })
}

private fun getExitTransition(
    initialState: NavBackStackEntry,
    targetState: NavBackStackEntry,
): ExitTransition {
    val from = initialState.destination.route
    val to = targetState.destination.route
    if (shouldSkipTransition(from, to)) {
        return ExitTransition.None
    }
    return ExitTransition.None // Customize exit transition as needed
}