package com.haitrvn.tictactoe

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.haitrvn.coreui.theme.AppTheme
import com.haitrvn.navigation.Destination
import com.haitrvn.navigation.NavigationItem
import com.haitrvn.navigation.Navigator
import com.haitrvn.navigation.arg.LoginScreenArgument
import cookapp.composeapp.generated.resources.Res
import cookapp.composeapp.generated.resources.home_title
import cookapp.composeapp.generated.resources.ic_cyclone
import cookapp.composeapp.generated.resources.login_title
import cookapp.composeapp.generated.resources.setting_title
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject
import org.koin.core.parameter.parametersOf

@Preview
@Composable
internal fun App() = AppTheme {
    val navController: NavHostController = rememberNavController()
    val navigator = koinInject<Navigator> { parametersOf(navController) }
    val navigationItemsLists = listOf(
        NavigationItem(
            unSelectedIcon = Res.drawable.ic_cyclone,
            selectedIcon = Res.drawable.ic_cyclone,
            title = stringResource(Res.string.login_title),
            destination = Destination.Login(LoginScreenArgument("")),
        ),
        NavigationItem(
            unSelectedIcon = Res.drawable.ic_cyclone,
            selectedIcon = Res.drawable.ic_cyclone,
            title = stringResource(Res.string.home_title),
            destination = Destination.Home,
        ),
        NavigationItem(
            unSelectedIcon = Res.drawable.ic_cyclone,
            selectedIcon = Res.drawable.ic_cyclone,
            title = stringResource(Res.string.setting_title),
            destination = Destination.Setting,
        ),
    )
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                items = navigationItemsLists,
                currentRoute = Destination.Home,
                onItemClick = { item ->
                    navigator.navigate(destination = item.destination, launchSingleTop = true)
                }
            )
        }
    ) {
        MainGraph(navController = navController, navigator = navigator)
    }
    BackPressSample()
}
