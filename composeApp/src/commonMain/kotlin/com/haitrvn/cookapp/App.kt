package com.haitrvn.cookapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.haitrvn.coreui.imageloader.initImageLoader
import com.haitrvn.coreui.theme.CookTheme
import com.haitrvn.navigation.Auth
import com.haitrvn.navigation.Main
import com.haitrvn.navigation.NavigationItem
import com.haitrvn.navigation.Screen
import com.haitrvn.navigation.ShowBottomBar
import com.haitrvn.auth.SignInEmailScreen
import com.haitrvn.auth.SignInPasswordScreen
import com.haitrvn.auth.CreateAccountScreen
import com.haitrvn.auth.ForgotPasswordScreen
import com.haitrvn.auth.EmailSentScreen
import com.haitrvn.auth.AboutYourselfScreen
import com.haitrvn.coreui.theme.AppColors
import cookapp.resources.app.Res
import cookapp.resources.app.ic_app_home
import cookapp.resources.app.ic_app_search
import cookapp.resources.app.ic_app_setting
import cookapp.resources.app.presentation_bottom_main_title
import cookapp.resources.app.presentation_bottom_search_title
import cookapp.resources.app.presentation_bottom_setting_title
import com.haitrvn.splash.SplashScreen
import com.haitrvn.onboarding.OnboardingScreen

@Composable
internal fun App(
    modifier: Modifier = Modifier
) = CookTheme {
    initImageLoader()

    val topLevelBackStack = remember { TopLevelBackStack<Screen>(Auth.LoginWithEmail) }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = {
            if (topLevelBackStack.backStack.lastOrNull() is ShowBottomBar) {
                // TODO: Implement Bottom Bar
            }
        }) {
        NavDisplay(
            modifier = Modifier.fillMaxSize().background(AppColors.background),
            backStack = topLevelBackStack.backStack,
            onBack = { topLevelBackStack.removeLast() },
            entryProvider = entryProvider {
                entry<Auth> {
                    SplashScreen(
                        modifier = modifier,
                        onStartClick = { topLevelBackStack.add(Auth.Onboarding) }
                    )
                }
                entry<Auth.Onboarding> {
                    OnboardingScreen(
                        modifier = modifier,
                        onFinish = { topLevelBackStack.add(Auth.LoginWithEmail) }
                    )
                }
                entry<Auth.LoginWithEmail> {
                    SignInEmailScreen(
                        onContinueClick = { email -> topLevelBackStack.add(Auth.LoginWithPassword) },
                        onCreateAccountClick = { topLevelBackStack.add(Auth.Register) }
                    )
                }
                entry<Auth.LoginWithPassword> {
                    SignInPasswordScreen(
                        onContinueClick = { password -> topLevelBackStack.add(Main.Home) },
                        onForgotPasswordClick = { topLevelBackStack.add(Auth.ForgotPassword) }
                    )
                }
                entry<Auth.Register> {
                    CreateAccountScreen(
                        onContinueClick = { topLevelBackStack.add(Auth.AboutYourself) },
                        onForgotPasswordClick = { topLevelBackStack.add(Auth.ForgotPassword) }
                    )
                }
                entry<Auth.ForgotPassword> {
                    ForgotPasswordScreen(
                        onContinueClick = { email -> topLevelBackStack.add(Auth.EmailSent) }
                    )
                }
                entry<Auth.EmailSent> {
                    EmailSentScreen(
                        onReturnToLoginClick = { topLevelBackStack.add(Auth.LoginWithEmail) }
                    )
                }
                entry<Auth.AboutYourself> {
                    AboutYourselfScreen(
                        onFinishClick = { topLevelBackStack.add(Main.Home) }
                    )
                }
                entry<Main.Home> {
                    // Placeholder for Home Screen
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