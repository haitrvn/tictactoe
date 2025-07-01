package com.haitrvn.tictactoe

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.haitrvn.coreui.theme.AppTheme
import com.haitrvn.features.home.BottomNavigationBar
import com.haitrvn.navigation.Auth
import com.haitrvn.navigation.Destination
import com.haitrvn.navigation.Home
import com.haitrvn.navigation.HomeDestination
import com.haitrvn.navigation.NavigationItem
import com.haitrvn.navigation.Navigator
import cookapp.composeapp.generated.resources.Res
import cookapp.composeapp.generated.resources.ic_home_main
import cookapp.composeapp.generated.resources.presentation_bottom_main_title
import cookapp.composeapp.generated.resources.presentation_bottom_search_title
import cookapp.composeapp.generated.resources.presentation_bottom_setting_title
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject
import org.koin.core.parameter.parametersOf

val navigationItemsLists = listOf(
    NavigationItem(
        unSelectedIcon = Res.drawable.ic_home_main,
        selectedIcon = Res.drawable.ic_home_main,
        title = Res.string.presentation_bottom_main_title,
        destination = Home.Main,
    ),
    NavigationItem(
        unSelectedIcon = Res.drawable.ic_home_main,
        selectedIcon = Res.drawable.ic_home_main,
        title = Res.string.presentation_bottom_search_title,
        destination = Home.Search,
    ),
    NavigationItem(
        unSelectedIcon = Res.drawable.ic_home_main,
        selectedIcon = Res.drawable.ic_home_main,
        title = Res.string.presentation_bottom_setting_title,
        destination = Home.Setting,
    ),
)

@Preview
@Composable
internal fun App() = AppTheme {
    val (navController, navigator) = rememberNavControllerAndNavigator()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.toRoute<Destination>()
    Scaffold(
        bottomBar = {
            if (currentRoute is HomeDestination) {
                BottomNavigationBar(
                    items = navigationItemsLists,
                    currentRoute = currentRoute,
                    onItemClick = { item ->
                        navigator.navigate(
                            destination = item.destination,
                            launchSingleTop = true
                        )
                    }
                )
            }
        }
    ) {
        MainGraph(
            navController = navController,
            navigator = navigator,
            startDestination = Auth
        )
    }
}

@Composable
private fun rememberNavControllerAndNavigator(): Pair<NavHostController, Navigator> {
    val navController: NavHostController = rememberNavController()
    val navigator = koinInject<Navigator> { parametersOf(navController) }
    return navController to navigator
}