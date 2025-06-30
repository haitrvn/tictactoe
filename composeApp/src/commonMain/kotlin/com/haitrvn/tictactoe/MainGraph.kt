package com.haitrvn.tictactoe

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.haitrvn.core.Log
import com.haitrvn.coreui.CommonText
import com.haitrvn.features.home.Home
import com.haitrvn.features.setting.Setting
import com.haitrvn.navigation.Auth
import com.haitrvn.navigation.Destination
import com.haitrvn.navigation.Home
import com.haitrvn.navigation.NavigationItem
import com.haitrvn.navigation.Navigator
import cookapp.composeapp.generated.resources.Res
import cookapp.composeapp.generated.resources.home_title
import cookapp.composeapp.generated.resources.ic_cyclone
import cookapp.composeapp.generated.resources.login_title
import cookapp.composeapp.generated.resources.setting_title
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.koinInject
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named

@Composable
internal fun MainGraph(
    modifier: Modifier = Modifier,
    navigator: Navigator,
    navController: NavHostController = rememberNavController(),
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
    composable<Home> {
        val navController: NavHostController = rememberNavController().apply {
            Log.i("NavController", "homeGraph navController: $this")
        }
        val homeNavigator = koinInject<Navigator>(qualifier = named("HOME")) { parametersOf(navController) }
        val navigationItemsLists = listOf(
            NavigationItem(
                unSelectedIcon = Res.drawable.ic_cyclone,
                selectedIcon = Res.drawable.ic_cyclone,
                title = stringResource(Res.string.login_title),
                destination = Home.Main,
            ),
            NavigationItem(
                unSelectedIcon = Res.drawable.ic_cyclone,
                selectedIcon = Res.drawable.ic_cyclone,
                title = stringResource(Res.string.home_title),
                destination = Home.Search,
            ),
            NavigationItem(
                unSelectedIcon = Res.drawable.ic_cyclone,
                selectedIcon = Res.drawable.ic_cyclone,
                title = stringResource(Res.string.setting_title),
                destination = Home.Setting,
            ),
        )
        var currentRoute = remember<Destination> { Home.Main }
        Scaffold(
            bottomBar = {
                BottomNavigationBar(
                    items = navigationItemsLists,
                    currentRoute = currentRoute,
                    onItemClick = { item ->
                        currentRoute = item.destination
                        homeNavigator.navigate(destination = item.destination, launchSingleTop = true)
                    }
                )
            }
        ) {
            NavHost(
                modifier = Modifier.fillMaxSize().then(modifier),
                navController = navController,
                startDestination = Home.Main
            ) {
                composable<Home.Main> {
                    Home(navigator = homeNavigator, arg = null)
                }
                composable<Home.Search> {
                    CommonText(text = "Search", modifier = Modifier.clickable {
                        homeNavigator.navigate(Home)
                    })
                }
                composable<Home.Setting> {
                    Setting(onLogout = {navigator.navigate(Auth.Login())})
                }
            }
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