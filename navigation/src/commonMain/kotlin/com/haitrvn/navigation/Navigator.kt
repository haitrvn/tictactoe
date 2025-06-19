package com.haitrvn.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.haitrvn.navigation.arg.LoginScreenArgument
import kotlinx.serialization.Serializable
import org.koin.compose.koinInject

interface Navigator {
    suspend fun navigate(
        destination: Destination,
        popUpToRoute: String? = null,
        popUpToInclusive: Boolean = false,
        popUpToSaveState: Boolean = false,
        launchSingleTop: Boolean = false,
        restoreState: Boolean = false,
    )

    suspend fun popBackStack(
        destination: Destination? = null,
        inclusive: Boolean = false,
        saveState: Boolean = false
    )

    suspend fun clearBackStack(destination: Destination)
    suspend fun handleDeeplink(deeplink: String)
}

sealed interface Screen<T> {

    @Composable
    fun content(
        modifier: Modifier = Modifier,
        navigator: Navigator,
        arg: T
    )

    interface Home<T> : Screen<T>
    interface Login: Screen<LoginScreenArgument?>
    interface Search<T>: Screen<T>
}



interface Destination

sealed class GraphDestination : Destination {
    @Serializable
    data object Home : GraphDestination()

    @Serializable
    data object Login : GraphDestination()

    @Serializable
    data object Search : GraphDestination()
}

fun NavGraphBuilder.loginScreen(navigator: Navigator) {
    composable<GraphDestination.Login> { backStackEntry ->
        val arg = backStackEntry.toRoute<LoginScreenArgument>()
        val loginScreen = koinInject<Screen.Login>()
        loginScreen.content(navigator = navigator, arg = arg)
    }
}