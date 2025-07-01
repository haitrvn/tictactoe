package com.haitrvn.tictactoe

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.haitrvn.coreui.CommonText
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
) {
    NavHost(
        modifier = Modifier.fillMaxSize().then(modifier),
        navController = navController,
        startDestination = startDestination
    ) {
        authGraph(navigator = navigator)
        homeGraph(navigator = navigator)
    }
}

internal fun NavGraphBuilder.homeGraph(
    modifier: Modifier = Modifier,
    navigator: Navigator,
) {
    navigation<Home>(startDestination = Home.Main) {
        composable<Home.Main> {
            CommonText(text = "Main")
        }
        composable<Home.Search> {
            CommonText(text = "Search")
        }
        composable<Home.Setting> {
            Setting(onLogout = { navigator.navigate(Auth.Login()) })
        }
    }
}

internal fun NavGraphBuilder.authGraph(
    modifier: Modifier = Modifier,
    navigator: Navigator,
) {
    navigation<Auth>(startDestination = Auth.Login()) {
        composable<Auth.Login> {
            CommonText(text = "Login", modifier = Modifier.clickable {
                navigator.navigate(Home)
            })
        }
        composable<Auth.Register> {
            CommonText("Register")
        }
    }
}