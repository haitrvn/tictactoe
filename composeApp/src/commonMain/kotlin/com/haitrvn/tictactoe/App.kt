package com.haitrvn.tictactoe

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.haitrvn.coreui.theme.AppTheme
import com.haitrvn.features.home.BottomNavigationBar
import com.haitrvn.navigation.Auth
import com.haitrvn.navigation.Home
import com.haitrvn.navigation.NavigationItem
import com.haitrvn.navigation.Navigator
import cookapp.resources.app.Res
import cookapp.resources.app.ic_home_main
import cookapp.resources.app.presentation_bottom_main_title
import cookapp.resources.app.presentation_bottom_search_title
import cookapp.resources.app.presentation_bottom_setting_title
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject
import org.koin.core.parameter.parametersOf

val navigationItemsLists by lazy {
    listOf(
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
}

@Preview
@Composable
internal fun App() = AppTheme {
    val (navController, navigator) = rememberNavControllerAndNavigator()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    Scaffold(
        bottomBar = {
            if (currentRoute?.contains(Home::class.qualifiedName.toString()) == true) {
                BottomNavigationBar(
                    items = navigationItemsLists,
                    currentRoute = currentRoute,
                    onItemClick = { item ->
                        navigator.navigate(
                            destination = item.destination, launchSingleTop = true
                        )
                    })
            }
        }) {
        MainGraph(
            navController = navController, navigator = navigator, startDestination = Home
        )
    }
}

@Composable
private fun rememberNavControllerAndNavigator(): Pair<NavHostController, Navigator> {
    val navController: NavHostController = rememberNavController()
    val navigator = koinInject<Navigator> { parametersOf(navController) }
    return navController to navigator
}