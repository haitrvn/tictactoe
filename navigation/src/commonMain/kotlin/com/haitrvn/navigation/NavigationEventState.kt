package com.haitrvn.navigation

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.navigationevent.NavigationEventHandler
import androidx.navigationevent.NavigationEventInfo
import androidx.navigationevent.NavigationEventTransitionState
import androidx.navigationevent.NavigationEventTransitionState.Idle

@Stable
class NavigationEventState<T : NavigationEventInfo>
internal constructor(
    currentInfo: T,
    backInfo: List<T> = emptyList(),
    forwardInfo: List<T> = emptyList(),
) {

    /**
     * The current physical gesture state from the dispatcher. This value is collected from the
     * local [NavigationEventHandler] and will be either [NavigationEventTransitionState.Idle] or
     * [NavigationEventTransitionState.InProgress]. This property will update frequently during a
     * gesture.
     */
    var transitionState: NavigationEventTransitionState by mutableStateOf(Idle)
        internal set // Public getter, internal setter

    /** History partitions relative to the current position. */

    /** A list of destinations the user may navigate back to. */
    var backInfo: List<T> by mutableStateOf(backInfo)
        internal set

    /** The contextual information for the currently active destination. */
    var currentInfo: T by mutableStateOf(currentInfo)
        internal set

    /** A list of destinations the user may navigate forward to. */
    var forwardInfo: List<T> by mutableStateOf(forwardInfo)
        internal set

    /**
     * The internal handler instance associated with this state object. This handler is created and
     * remembered by [rememberNavigationEventState] and is registered with the dispatcher when
     * passed to [NavigationEventHandler]. This guarantees the link between the hoisted state and
     * the active handler.
     */
    internal var sourceHandler: NavigationEventHandler<out NavigationEventInfo>? = null
}
