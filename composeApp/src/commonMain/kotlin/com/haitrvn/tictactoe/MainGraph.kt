package com.haitrvn.tictactoe

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.haitrvn.coreui.CommonText
import com.haitrvn.features.login.Login
import com.haitrvn.features.setting.Setting
import com.haitrvn.navigation.Destination
import com.haitrvn.navigation.NavigationItem
import com.haitrvn.navigation.Navigator
import org.jetbrains.compose.resources.vectorResource

@Composable
internal fun MainGraph(
    modifier: Modifier = Modifier,
    navigator: Navigator,
    navController: NavHostController = rememberNavController(),
    startDestination: Destination = Destination.Login,
) {
    NavHost(
        modifier = Modifier.fillMaxSize().then(modifier),
        navController = navController,
        startDestination = startDestination
    ) {
        composable<Destination.Login> {
            Login(navigator = navigator, arg = null)
        }
        composable<Destination.Setting> {
            Setting()
        }
    }
}

@Composable
fun BottomNavigationBar(
    items: List<NavigationItem>,
    currentRoute: Destination?,
    onItemClick: (NavigationItem) -> Unit
) {
    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
    ) {
        items.forEach { navigationItem ->
            NavigationBarItem(
                selected = currentRoute == navigationItem.destination,
                onClick = { onItemClick(navigationItem) },
                icon = {
                    Icon(
                        imageVector = vectorResource(navigationItem.unSelectedIcon),
                        contentDescription = navigationItem.title,
                    )
                },
                label = {
                    CommonText(
                        text = navigationItem.title,
                        maxLines = 1,
                    )
                },
            )
        }
    }
}