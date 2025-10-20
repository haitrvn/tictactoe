@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.haitrvn.cookapp

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import com.haitrvn.core.Log
import com.haitrvn.coreui.Button
import com.haitrvn.coreui.Heading
import com.haitrvn.coreui.Image
import com.haitrvn.coreui.Primary
import com.haitrvn.coreui.Text
import com.haitrvn.coreui.imageloader.initImageLoader
import com.haitrvn.coreui.theme.CookTheme
import com.haitrvn.navigation.NavigationItem
import com.haitrvn.navigation.Screen
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
    val topLevelBackStack = remember { TopLevelBackStack<Screen>(Screen.Auth) }
    val activeEntries = remember { mutableStateMapOf<NavKey, Boolean>() }
    Scaffold(
        bottomBar = {
            NavigationBar {
                navigationItemsLists.forEach { topLevelRoute ->

                    val isSelected = topLevelRoute == topLevelBackStack.backStack
                    NavigationBarItem(
                        selected = isSelected,
                        onClick = {
                            if (activeEntries[topLevelRoute.destination] != true) {
                                topLevelBackStack.addTopLevel(topLevelRoute.destination)
                            }
                        },
                        icon = {
                            Image(source = topLevelRoute.selectedIcon)
                        }
                    )
                }
            }
        }
    ) { _ ->
//        val backstack = rememberNavBackStackFix(config, Screen.Main.Home, Screen.Main.Home)
        NavDisplay(
            backStack = topLevelBackStack.backStack,
            modifier = modifier,
            onBack = { topLevelBackStack.removeLast() },
            entryProvider = entryProvider {
                entry<Screen.Auth> {
                    TrackableEntry(
                        key = Screen.Auth,
                        onActiveChange = { active ->
                            activeEntries[Screen.Auth] = active
                        }) {

                        Button.Primary(text = "Go home") {
                            topLevelBackStack.addTopLevel(Screen.Main.Home)
                        }
                    }
                }
                entry<Screen.Main.Home> {
                    TrackableEntry(
                        key = Screen.Main.Home,
                        onActiveChange = { active ->
                            activeEntries[Screen.Main.Home] = active
                        }) {
                        Text.Heading(text = "Home")
                    }
                }
                entry<Screen.Main.Saved> {
                    TrackableEntry(
                        key = Screen.Main.Saved,
                        onActiveChange = { active ->
                            activeEntries[Screen.Main.Saved] = active
                        }) {
                        Text.Heading(text = "Saved")
                    }
                }
                entry<Screen.Main.Notification> {
                    TrackableEntry(
                        key = Screen.Main.Notification,
                        onActiveChange = { active ->
                            activeEntries[Screen.Main.Notification] = active
                        }) {
                        Text.Heading(text = "Saved")
                    }
                }
                entry<Screen.Main.Setting> {
                    TrackableEntry(
                        key = Screen.Main.Setting,
                        onActiveChange = { active ->
                            activeEntries[Screen.Main.Setting] = active
                        }) {
                        Text.Heading(text = "Saved")
                    }
                }
            },
        )
    }
}

@Composable
fun TrackableEntry(
    key: Any,
    onActiveChange: (Boolean) -> Unit,
    content: @Composable () -> Unit
) {
    DisposableEffect(key) {
        Log.d("TrackableEntry", "DisposableEffect $key true")
        onActiveChange(true)
        onDispose {
            Log.d("TrackableEntry", "DisposableEffect $key false")
            onActiveChange(false)
        }
    }
    content()
}


class TopLevelBackStack<T : Any>(startKey: T) {

    private var topLevelStacks: LinkedHashMap<T, SnapshotStateList<T>> = linkedMapOf(
        startKey to mutableStateListOf(startKey)
    )

    var topLevelKey = startKey
        private set

    val backStack = mutableStateListOf(startKey)

    private fun updateBackStack() =
        backStack.apply {
            clear()
            addAll(topLevelStacks.flatMap { it.value })
        }

    fun addTopLevel(key: T) {

        if (topLevelStacks[key] == null) {
            topLevelStacks.put(key, mutableStateListOf(key))
        } else {
            topLevelStacks.apply {
                remove(key)?.let {
                    put(key, it)
                }
            }
        }
        topLevelKey = key
        updateBackStack()
    }

    fun add(key: T) {
        topLevelStacks[topLevelKey]?.add(key)
        updateBackStack()
    }

    fun removeLast() {
        val removedKey = topLevelStacks[topLevelKey]?.removeLastOrNull()
        // If the removed key was a top level key, remove the associated top level stack
        topLevelStacks.remove(removedKey)
        topLevelKey = topLevelStacks.keys.last()
        updateBackStack()
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