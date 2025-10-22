package com.haitrvn.notification

import kotlinx.collections.immutable.PersistentList

data class NotificationScreenUiState(
    val notifications: PersistentList<NotificationGroupByDate>
)