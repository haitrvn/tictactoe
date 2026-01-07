package com.haitrvn.cookapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.backhandler.BackHandler
import com.haitrvn.core.log.Log
import kotlinx.coroutines.delay

const val BACK_PRESS_INTERVAL_MS = 2000L

sealed class BackPressHandle {
    object Idle : BackPressHandle()
    object InitialTouch : BackPressHandle()
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun BackPressSample() {
    var backPressHandleState by remember { mutableStateOf<BackPressHandle>(BackPressHandle.Idle) }

    LaunchedEffect(key1 = backPressHandleState) {
        if (backPressHandleState == BackPressHandle.InitialTouch) {
            Log.i("Press again to exit")
            delay(BACK_PRESS_INTERVAL_MS)
            backPressHandleState = BackPressHandle.Idle
            Log.i("Press again to exit END")
        }
    }

    BackHandler(backPressHandleState == BackPressHandle.Idle) {
        backPressHandleState = BackPressHandle.InitialTouch
    }
}