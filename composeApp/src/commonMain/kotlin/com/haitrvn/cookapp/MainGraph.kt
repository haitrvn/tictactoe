@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.haitrvn.cookapp

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.haitrvn.auth.Login
import com.haitrvn.auth.LoginWithEmail
import com.haitrvn.auth.Welcome
import com.haitrvn.coreui.Drop
import com.haitrvn.coreui.HeaderText
import com.haitrvn.coreui.ImageRecipe
import com.haitrvn.coreui.SmoothLinearProgressBar
import com.haitrvn.coreui.TextParagraph
import com.haitrvn.coreui.TextSmall
import com.haitrvn.features.setting.Setting
import com.haitrvn.home.DiscoverScreen
import com.haitrvn.home.Home
import com.haitrvn.navigation.Auth
import com.haitrvn.navigation.Destination
import com.haitrvn.navigation.Main
import com.haitrvn.navigation.Navigator
import com.haitrvn.splash.BACKGROUND_ALPHA
import com.haitrvn.splash.PADDING_ALL_SIDES
import com.haitrvn.splash.PADDING_BOTTOM_COLUMN
import com.haitrvn.splash.PADDING_BOTTOM_PROGRESS_INDICATOR
import com.haitrvn.splash.PADDING_BOTTOM_TEXT
import com.haitrvn.splash.PADDING_START_PROGRESS_INDICATOR
import com.haitrvn.splash.PageContent
import com.haitrvn.splash.SharedYourRecipesScreen
import com.haitrvn.splash.SplashInformation
import com.haitrvn.splash.SplashScreen
import kotlinx.collections.immutable.persistentListOf

@Composable
internal fun MainGraph(
    modifier: Modifier = Modifier,
    navigator: Navigator,
    navController: NavHostController,
    startDestination: Destination,
    sharedTransitionScope: SharedTransitionScope,
) {
    NavHost(
        modifier = Modifier.fillMaxSize().then(modifier),
        navController = navController,
        startDestination = startDestination
    ) {
        authGraph(
            navigator = navigator,
            sharedTransitionScope = sharedTransitionScope,
        )
        homeGraph(
            navigator = navigator,
            sharedTransitionScope = sharedTransitionScope,
        )
    }
}

internal fun NavGraphBuilder.homeGraph(
    modifier: Modifier = Modifier,
    navigator: Navigator,
    sharedTransitionScope: SharedTransitionScope,
) {
    navigation<Main>(startDestination = Main.Home) {
        navigation<Main.Home>(startDestination = Main.Home.Home1) {
            composable<Main.Home.Home1> {
                Home()
            }
        }
        navigation<Main.Search>(startDestination = Main.Search.Search1) {
            composable<Main.Search.Search1> {
                DiscoverScreen()
            }
        }
        navigation<Main.Setting>(startDestination = Main.Setting.Setting1) {
            composable<Main.Setting.Setting1> {
                Setting(
                    onEditAvatar = { navigator.navigate(Main.Setting.Setting2) },
                    onLogout = { navigator.navigate(Auth) })
            }
            composable<Main.Setting.Setting2> {
                TextSmall(text = "Setting2")
            }
        }
    }
}
val listData = persistentListOf(
    PageContent(
        "Share Your Recipes",
        "Share your favorite recipes with the world!blablablablablablablablablablablablablablablablablabla",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsK8g4zhtM_TszTYUho3dMZ2r3uwS-WLL4mA&s"
    ),
    PageContent(
        "Discover New Flavors",
        "Explore a wide variety of cuisines and dishes.blablablablablablablablablablablablablablablablablablablablablabla",
        "https://cdn.britannica.com/36/123536-050-95CB0C6E/Variety-fruits-vegetables.jpg"
    ),
    PageContent(
        "Cook Like a Pro",
        "Learn new cooking techniques and tips.blablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablablabla",
        "https://vietop.edu.vn/wp-content/uploads/2023/07/idioms-chu-de-food.jpg"
    ),
)
internal fun NavGraphBuilder.authGraph(
    modifier: Modifier = Modifier,
    navigator: Navigator,
    sharedTransitionScope: SharedTransitionScope,
) {
    navigation<Auth>(startDestination = Auth.Welcome) {
        composable<Auth.Welcome> {
            SharedYourRecipesScreen(listData = listData){
                navigator.navigate(Auth.Login)
            }
        }
        composable<Auth.Login> {
            Login(
                navigator = navigator,
                sharedTransitionScope = sharedTransitionScope,
                animatedVisibilityScope = this@composable
            )
        }
        composable<Auth.LoginWithEmail> {
            LoginWithEmail(navigator = navigator)
        }
        composable<Auth.Register> {
            TextParagraph(text = "Register")
        }
    }
}

private fun shouldSkipTransition(from: String?, to: String?): Boolean {
    val welcomeRoute = Auth.Welcome::class.qualifiedName.toString()
    val loginRoute = Auth.Login::class.qualifiedName.toString()
    return (from == welcomeRoute && to == loginRoute) || to == welcomeRoute || from == welcomeRoute
}

private fun getEnterTransition(
    initialState: NavBackStackEntry,
    targetState: NavBackStackEntry,
): EnterTransition {
    val from = initialState.destination.route
    val to = targetState.destination.route
    val welcomeRoute = Auth.Welcome::class.qualifiedName.toString()
    if (shouldSkipTransition(from, to)) {
        return EnterTransition.None
    }
    return slideInHorizontally(initialOffsetX = { if (to == welcomeRoute) -it else it })
}

private fun getExitTransition(
    initialState: NavBackStackEntry,
    targetState: NavBackStackEntry,
): ExitTransition {
    val from = initialState.destination.route
    val to = targetState.destination.route
    if (shouldSkipTransition(from, to)) {
        return ExitTransition.None
    }
    return ExitTransition.None // Customize exit transition as needed
}