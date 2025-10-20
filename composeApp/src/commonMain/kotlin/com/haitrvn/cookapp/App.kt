@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.haitrvn.cookapp

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import com.haitrvn.coreui.Button
import com.haitrvn.coreui.Heading
import com.haitrvn.coreui.Image
import com.haitrvn.coreui.Primary
import com.haitrvn.coreui.Text
import com.haitrvn.coreui.imageloader.initImageLoader
import com.haitrvn.coreui.theme.CookTheme
import com.haitrvn.navigation.NavigationItem
import com.haitrvn.navigation.Screen
import com.haitrvn.navigation.rememberNavBackStackFix
import cookapp.resources.app.Res
import cookapp.resources.app.ic_app_home
import cookapp.resources.app.ic_app_search
import cookapp.resources.app.ic_app_setting
import cookapp.resources.app.presentation_bottom_main_title
import cookapp.resources.app.presentation_bottom_search_title
import cookapp.resources.app.presentation_bottom_setting_title
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

private val config = SavedStateConfiguration {
    serializersModule = SerializersModule {
        polymorphic(NavKey::class) {
            subclass(Screen.Auth::class, Screen.Auth.serializer())
            subclass(Screen.Main::class, Screen.Main.serializer())
            subclass(Screen.Main.Home::class, Screen.Main.Home.serializer())
            subclass(Screen.Main.Saved::class, Screen.Main.Saved.serializer())
            subclass(Screen.Main.Notification::class, Screen.Main.Notification.serializer())
            subclass(Screen.Main.Notification::class, Screen.Main.Notification.serializer())
        }
    }
}

@Composable
internal fun App(
    modifier: Modifier = Modifier
) = CookTheme {
    initImageLoader()
    val backStack = rememberNavBackStackFix<Screen>(config, Screen.Auth)
    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Screen.Auth> {
                Button.Primary(text = "Home") {
                    backStack.removeLastOrNull()
                    backStack.add(Screen.Main())
                }
            }
            entry<Screen.Main> {
                InnerDisplay(modifier = Modifier)
            }
        },
    )
}

@Composable
fun InnerDisplay(modifier: Modifier = Modifier) {
    val backStack = rememberNavBackStackFix(config, Screen.Main.Home)
    Scaffold(
        bottomBar = {
            NavigationBar {
                navigationItemsLists.forEach { topLevelRoute ->

                    val isSelected = topLevelRoute == backStack
                    NavigationBarItem(
                        selected = isSelected,
                        onClick = {
                            backStack.removeLastOrNull()
                            backStack.add(topLevelRoute.destination)
                        },
                        icon = {
                            Image(source = topLevelRoute.selectedIcon)
                        }
                    )
                }
            }
        }
    ) { _ ->
        NavDisplay(
            backStack = backStack,
            modifier = modifier,
            onBack = { backStack.removeLastOrNull() },
            entryProvider = entryProvider {
                entry<Screen.Main.Home> {
                    Text.Heading(text = "Home")
                }
                entry<Screen.Main.Saved> {
                    Text.Heading(text = "ChatList")
                }
                entry<Screen.Main.Notification> {
                    Text.Heading(text = "ChatDetail")
                }
                entry<Screen.Main.Setting> {
                    Text.Heading(text = "Camera")
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
            destination = Screen.Main.Home,
        ),
        NavigationItem(
            unSelectedIcon = Res.drawable.ic_app_search,
            selectedIcon = Res.drawable.ic_app_search,
            title = Res.string.presentation_bottom_search_title,
            destination = Screen.Main.Saved,
        ),
        NavigationItem(
            unSelectedIcon = Res.drawable.ic_app_setting,
            selectedIcon = Res.drawable.ic_app_setting,
            title = Res.string.presentation_bottom_setting_title,
            destination = Screen.Main.Notification,
        ),
        NavigationItem(
            unSelectedIcon = Res.drawable.ic_app_setting,
            selectedIcon = Res.drawable.ic_app_setting,
            title = Res.string.presentation_bottom_setting_title,
            destination = Screen.Main.Setting,
        ),
    )
}