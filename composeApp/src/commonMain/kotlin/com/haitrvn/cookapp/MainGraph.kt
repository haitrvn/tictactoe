@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.haitrvn.cookapp

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.haitrvn.auth.LoginScreen
import com.haitrvn.auth.RegisterScreen
import com.haitrvn.auth.WelcomeScreen
import com.haitrvn.navigation.Auth
import com.haitrvn.navigation.Destination
import com.haitrvn.navigation.Main
import com.haitrvn.navigation.Navigator
import com.haitrvn.splash.SplashScreen

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
    navigation<Main>(startDestination = Main.Home) {
        navigation<Main.Home>(startDestination = Main.Home.Home1) {
            composable<Main.Home.Home1> {
            }
        }
        navigation<Main.Search>(startDestination = Main.Search.Search1) {
            composable<Main.Search.Search1> {
            }
        }
        navigation<Main.Setting>(startDestination = Main.Setting.Setting1) {
            composable<Main.Setting.Setting1> {
            }
            composable<Main.Setting.Setting2> {
            }
        }
    }
}

internal fun NavGraphBuilder.authGraph(
    modifier: Modifier = Modifier,
    navigator: Navigator,
    sharedTransitionScope: SharedTransitionScope,
) {
    navigation<Auth>(startDestination = Auth.Welcome) {
        composable<Auth.Welcome> {
            SplashScreen {  }
        }
        composable<Auth.Login> {
            LoginScreen(modifier = modifier, navigator = navigator)
        }
        composable<Auth.LoginWithEmail> {
        }
        composable<Auth.Register> {
            RegisterScreen()
        }
    }
}