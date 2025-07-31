package com.haitrvn.navigation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class ReloadViewModel : ViewModel() {
    private val _events = MutableSharedFlow<MainEvent>(extraBufferCapacity = 1)
    val events = _events.asSharedFlow()
}

sealed interface MainAction {

}

sealed interface MainEvent {
    data class Reload(val destination: Destination) : MainEvent
}