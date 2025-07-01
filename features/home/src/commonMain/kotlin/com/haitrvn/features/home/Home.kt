package com.haitrvn.features.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.haitrvn.navigation.Navigator
import org.koin.compose.koinInject

@Composable
fun Home(
    modifier: Modifier = Modifier,
    viewmodel: HomeViewModel = koinInject<HomeViewModel>(),
    content: @Composable (navController: NavHostController, navigator: Navigator) -> Unit
) {

}