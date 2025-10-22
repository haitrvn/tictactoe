package com.haitrvn.notification

import kotlinx.collections.immutable.ImmutableList

data class NotificationGroupByDate(
    val date: String,
    val notifications: ImmutableList<NotificationItem>
)

data class NotificationItem(
    val id: String,
    val title: String,
    val description: String,
    val isRead: Boolean,
    val date: String
)