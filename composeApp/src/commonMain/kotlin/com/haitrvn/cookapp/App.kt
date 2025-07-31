@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.haitrvn.cookapp

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.haitrvn.coreui.CookSurface
import com.haitrvn.coreui.imageloader.initImageLoader
import com.haitrvn.coreui.theme.CookTheme
import com.haitrvn.home.BottomNavigationBar
import com.haitrvn.navigation.Auth
import com.haitrvn.navigation.Main
import com.haitrvn.navigation.NavigationItem
import com.haitrvn.navigation.Navigator
import cookapp.resources.app.Res
import cookapp.resources.app.ic_app_home
import cookapp.resources.app.ic_app_search
import cookapp.resources.app.ic_app_setting
import cookapp.resources.app.presentation_bottom_main_title
import cookapp.resources.app.presentation_bottom_search_title
import cookapp.resources.app.presentation_bottom_setting_title
import org.koin.core.parameter.parametersOf
import org.koin.mp.KoinPlatform.getKoin

@Composable
internal fun App(
    modifier: Modifier = Modifier
) = CookTheme {
    initImageLoader()
    val navController = rememberNavController()
    val navigator: Navigator by remember(navController) {
        mutableStateOf(getKoin().get<Navigator>(parameters = { parametersOf(navController) }))
    }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val isShowScaffold = currentRoute?.contains(Main::class.qualifiedName.toString()) == true
    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            if (isShowScaffold) {
                BottomNavigationBar(
                    items = navigationItemsLists,
                    currentRoute = currentRoute,
                    onItemClick = { item ->
                        navigator.navigate(
                            destination = item.destination,
                            popUpToRoute = Main,
                            launchSingleTop = true,
                            restoreState = true,
                            popUpToSaveState = true
                        )
                    },
                    onItemReClick = { item ->
                        navigator.navigate(
                            destination = item.destination,
                            popUpToRoute = item.destination,
                            popUpToInclusive = true,
                            launchSingleTop = true,
                            restoreState = false,
                            popUpToSaveState = true
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

val navigationItemsLists by lazy {
    listOf(
        NavigationItem(
            unSelectedIcon = Res.drawable.ic_app_home,
            selectedIcon = Res.drawable.ic_app_home,
            title = Res.string.presentation_bottom_main_title,
            destination = Main.Home,
        ),
        NavigationItem(
            unSelectedIcon = Res.drawable.ic_app_search,
            selectedIcon = Res.drawable.ic_app_search,
            title = Res.string.presentation_bottom_search_title,
            destination = Main.Search,
        ),
        NavigationItem(
            unSelectedIcon = Res.drawable.ic_app_setting,
            selectedIcon = Res.drawable.ic_app_setting,
            title = Res.string.presentation_bottom_setting_title,
            destination = Main.Setting,
        ),
    )
}