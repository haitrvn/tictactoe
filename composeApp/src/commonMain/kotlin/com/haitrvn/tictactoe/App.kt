package com.haitrvn.tictactoe

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.backhandler.BackHandler
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.haitrvn.navigation.Destination
import com.haitrvn.navigation.NavigationItem
import com.haitrvn.navigation.Navigator
import com.haitrvn.tictactoe.theme.AppTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject
import org.koin.core.parameter.parametersOf
import peep.composeapp.generated.resources.Res
import peep.composeapp.generated.resources.ic_cyclone

@OptIn(ExperimentalComposeUiApi::class)
@Preview
@Composable
internal fun App() = AppTheme {
    val navController: NavHostController = rememberNavController()
    val navigator = koinInject<Navigator> { parametersOf(navController) }
    val navigationItemsLists = listOf(
        NavigationItem(
            unSelectedIcon = Res.drawable.ic_cyclone,
            selectedIcon = Res.drawable.ic_cyclone,
            title = "Home",
            destination = Destination.Login,
        ),
        NavigationItem(
            unSelectedIcon = Res.drawable.ic_cyclone,
            selectedIcon = Res.drawable.ic_cyclone,
            title = "Setting",
            destination = Destination.Setting,
        ),
    )
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                items = navigationItemsLists,
                currentRoute = Destination.Login,
                onItemClick = { item ->
                    navigator.navigate(destination = item.destination, launchSingleTop = true)
                }
            )
        }
    ) { innerPadding ->
        MainGraph(navController = navController, navigator = navigator)
    }
    BackHandler(true) {
        navigator.navigate(destination = Destination.Setting, launchSingleTop = true)
    }
}
