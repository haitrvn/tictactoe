@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.haitrvn.cookapp

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.savedstate.serialization.SavedStateConfiguration
import com.haitrvn.coreui.imageloader.initImageLoader
import com.haitrvn.coreui.theme.AppColors
import com.haitrvn.coreui.theme.CookTheme
import com.haitrvn.home.BottomNavigationBar
import com.haitrvn.navigation.Auth
import com.haitrvn.navigation.BottomNavShown
import com.haitrvn.navigation.Main
import com.haitrvn.navigation.NavigationItem
import com.haitrvn.navigation.Screen
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
    val backStack = rememberNavBackStack(
        configuration = SavedStateConfiguration.DEFAULT,
        elements = arrayOf(Screen.Auth)
    )
    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            if (backStack.lastOrNull() is BottomNavShown) {
                BottomNavigationBar(
                    items = navigationItemsLists,
                    currentRoute = backStack.lastOrNull() as Screen,
                    onItemClick = { item ->
                        backStack.add(Screen.Home)
                    })
            }
        }) {
        SharedTransitionLayout {
            Box(modifier = Modifier.background(AppColors.background)) {
                MainGraph(
                    backStack = backStack,
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
            destination = Screen.Home,
        ),
        NavigationItem(
            unSelectedIcon = Res.drawable.ic_app_search,
            selectedIcon = Res.drawable.ic_app_search,
            title = Res.string.presentation_bottom_search_title,
        ),
        NavigationItem(
            unSelectedIcon = Res.drawable.ic_app_setting,
            selectedIcon = Res.drawable.ic_app_setting,
            title = Res.string.presentation_bottom_setting_title,
            destination = Main.Setting,
        ),
    )
}