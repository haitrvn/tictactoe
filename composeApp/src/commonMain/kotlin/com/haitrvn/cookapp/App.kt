@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.haitrvn.cookapp

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.haitrvn.auth.LoginScreen
import com.haitrvn.coreui.imageloader.initImageLoader
import com.haitrvn.coreui.theme.CookTheme
import com.haitrvn.features.setting.Setting
import com.haitrvn.home.BottomNavigationBar
import com.haitrvn.home.Home
import com.haitrvn.navigation.Auth
import com.haitrvn.navigation.Main
import com.haitrvn.navigation.NavigationItem
import com.haitrvn.navigation.Screen
import com.haitrvn.navigation.ShowBottomBar
import com.haitrvn.notification.NotificationScreen
import com.haitrvn.saved.SavedScreen
import com.haitrvn.splash.SplashScreen
import cookapp.resources.app.Res
import cookapp.resources.app.ic_app_home
import cookapp.resources.app.ic_app_search
import cookapp.resources.app.ic_app_setting
import cookapp.resources.app.presentation_bottom_main_title
import cookapp.resources.app.presentation_bottom_search_title
import cookapp.resources.app.presentation_bottom_setting_title

@Composable
internal fun App(
    modifier: Modifier = Modifier
) = CookTheme {
    initImageLoader()

    val topLevelBackStack = remember { TopLevelBackStack<Screen>(Main.Home) }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            if (topLevelBackStack.backStack.lastOrNull() is ShowBottomBar) {
                BottomNavigationBar(
                    items = navigationItemsLists,
                    currentRoute = topLevelBackStack.backStack.lastOrNull(),
                    onItemClick = { item ->
                        topLevelBackStack.addTopLevel(item.destination)
                    })
            }
        }) {
        NavDisplay(
            backStack = topLevelBackStack.backStack,
            onBack = { topLevelBackStack.removeLast() },
            entryProvider = entryProvider {
                entry<Auth> {
                    SplashScreen(
                        modifier = modifier,
                        onStartClick = { topLevelBackStack.add(Auth.Login) }
                    )
                }
                entry<Auth.Login> {
                    LoginScreen(gotoHome = { topLevelBackStack.addTopLevel(Main.Home) })
                }
                entry<Main.Home> {
                    Home()
                }
                entry<Main.Search> {
                    SavedScreen()
                }
                entry<Main.Notification> {
                    NotificationScreen()
                }
                entry<Main.Setting> {
                    Setting()
                }
            },
        )
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
            unSelectedIcon = Res.drawable.ic_app_home,
            selectedIcon = Res.drawable.ic_app_home,
            title = Res.string.presentation_bottom_search_title,
            destination = Main.Notification,
        ),
        NavigationItem(
            unSelectedIcon = Res.drawable.ic_app_setting,
            selectedIcon = Res.drawable.ic_app_setting,
            title = Res.string.presentation_bottom_setting_title,
            destination = Main.Setting,
        ),
    )
}