package com.haitrvn.notification

import androidx.lifecycle.ViewModel
import kotlinx.collections.immutable.PersistentList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class NotificationViewModel : ViewModel() {
    private var nonfilterNotifications: PersistentList<NotificationGroupByDate> =
        mockNotificationGroupByDate

    private val _uiState: MutableStateFlow<NotificationScreenUiState> = MutableStateFlow(
        NotificationScreenUiState(
            notifications = nonfilterNotifications
        )
    )

    val uiState: StateFlow<NotificationScreenUiState> = _uiState.asStateFlow()

}

val mockNotificationItems1 = kotlinx.collections.immutable.persistentListOf(
    NotificationItem(
        id = "1",
        title = "Chào mừng bạn đã đến!",
        description = "Cảm ơn bạn đã tham gia cộng đồng của chúng tôi. Hãy khám phá nhé!",
        isRead = false,
        date = "2023-10-27"
    ),
    NotificationItem(
        id = "2",
        title = "Hồ sơ của bạn đã được cập nhật",
        description = "Thông tin cá nhân của bạn đã được cập nhật thành công.",
        isRead = true,
        date = "2023-10-27"
    )
)

val mockNotificationItems2 = kotlinx.collections.immutable.persistentListOf(
    NotificationItem(
        id = "3",
        title = "Lời nhắc: Cuộc hẹn sắp tới",
        description = "Đừng quên cuộc hẹn của bạn vào ngày mai lúc 10 giờ sáng.",
        isRead = false,
        date = "2023-10-26"
    )
)

val mockNotificationGroupByDate = kotlinx.collections.immutable.persistentListOf(
    NotificationGroupByDate(date = "Hôm nay", notifications = mockNotificationItems1),
    NotificationGroupByDate(date = "Hôm qua", notifications = mockNotificationItems2)
)