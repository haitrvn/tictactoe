package com.haitrvn.tictactoe

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.haitrvn.core.Log
import com.haitrvn.coreui.theme.AppTheme
import com.haitrvn.navigation.Auth
import com.haitrvn.navigation.Navigator
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named

@Preview
@Composable
internal fun App() = AppTheme {
    val navController: NavHostController = rememberNavController()
        .apply {
            Log.i("NavController", "AppTheme navController: $this")
        }

    val navigator = koinInject<Navigator>(qualifier = named("APP")) { parametersOf(navController) }
    MainGraph(navController = navController, navigator = navigator, startDestination = Auth)
}
