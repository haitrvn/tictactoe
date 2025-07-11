@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.haitrvn.cookapp

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.haitrvn.coreui.CookSurface
import com.haitrvn.coreui.imageloader.initImageLoader
import com.haitrvn.coreui.theme.CookTheme
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
import org.koin.compose.koinInject
import org.koin.core.parameter.parametersOf

@Composable
internal fun App(
    modifier: Modifier = Modifier
) = CookTheme {
    initImageLoader()
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
        SharedTransitionLayout {
            CookSurface {
                MainGraph(
                    navController = navController,
                    navigator = navigator,
                    startDestination = Auth,
                    sharedTransitionScope = this@SharedTransitionLayout,
                )
            }
        }
    }
}

@Composable
private fun rememberNavControllerAndNavigator(): Pair<NavHostController, Navigator> {
    val navController: NavHostController = rememberNavController()
    val navigator = koinInject<Navigator> { parametersOf(navController) }
    return navController to navigator
}

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