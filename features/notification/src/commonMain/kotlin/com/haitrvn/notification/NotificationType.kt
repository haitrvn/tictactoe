package com.haitrvn.notification

import cookapp.resources.notification.Res
import cookapp.resources.notification.notification_tab_all
import cookapp.resources.notification.notification_tab_read
import cookapp.resources.notification.notification_tab_unread
import org.jetbrains.compose.resources.StringResource

internal enum class NotificationType {
    ALL,
    UNREAD,
    READ
}

internal val NotificationType.title: StringResource
    get() = when (this) {
        NotificationType.ALL -> Res.string.notification_tab_all
        NotificationType.UNREAD -> Res.string.notification_tab_unread
        NotificationType.READ -> Res.string.notification_tab_read
    }
