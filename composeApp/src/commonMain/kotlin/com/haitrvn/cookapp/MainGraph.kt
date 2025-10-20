@file:OptIn(ExperimentalSharedTransitionApi::class)

package com.haitrvn.cookapp

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey

@Composable
internal fun MainGraph(
    modifier: Modifier = Modifier,
    backStack: NavBackStack<NavKey>,
) {

}