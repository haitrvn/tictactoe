package com.haitrvn.navigation

import androidx.navigationevent.NavigationEvent
import androidx.navigationevent.NavigationEventHandler
import androidx.navigationevent.NavigationEventInfo
import androidx.navigationevent.NavigationEventTransitionState

class ComposeNavigationEventHandler<T : NavigationEventInfo>(
    initialInfo: T,
    private val onTransitionStateChanged: (NavigationEventTransitionState) -> Unit = {},
) :
    NavigationEventHandler<T>(
        initialInfo = initialInfo,
        isBackEnabled = false,
        isForwardEnabled = false,
    ) {

    var currentOnForwardCancelled: () -> Unit = {}
    var currentOnForwardCompleted: () -> Unit = {}
    var currentOnBackCancelled: () -> Unit = {}
    var currentOnBackCompleted: () -> Unit = {}

    override fun onForwardStarted(event: NavigationEvent) {
        onTransitionStateChanged(transitionState)
    }

    override fun onForwardProgressed(event: NavigationEvent) {
        onTransitionStateChanged(transitionState)
    }

    override fun onForwardCancelled() {
        onTransitionStateChanged(transitionState)
        currentOnForwardCancelled.invoke()
    }

    override fun onForwardCompleted() {
        onTransitionStateChanged(transitionState)
        currentOnForwardCompleted.invoke()
    }

    override fun onBackStarted(event: NavigationEvent) {
        onTransitionStateChanged(transitionState)
    }

    override fun onBackProgressed(event: NavigationEvent) {
        onTransitionStateChanged(transitionState)
    }

    override fun onBackCancelled() {
        onTransitionStateChanged(transitionState)
        currentOnBackCancelled.invoke()
    }

    override fun onBackCompleted() {
        onTransitionStateChanged(transitionState)
        currentOnBackCompleted.invoke()
    }
}