package com.haitrvn.notification.preview

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.haitrvn.coreui.imageloader.DevicesPreview
import com.haitrvn.coreui.theme.CookTheme
import com.haitrvn.notification.NotificationGroupByDate
import com.haitrvn.notification.NotificationItem
import com.haitrvn.notification.NotificationScreen
import com.haitrvn.notification.NotificationScreenUiState
import kotlinx.collections.immutable.persistentListOf

@DevicesPreview
@Composable
fun PreviewButton() {
    CookTheme {
        Column {
            NotificationScreen(
                modifier = Modifier,
                uiState = NotificationScreenUiState(mockNotificationGroupByDate),
                goToDetail = {}
            )
        }
    }
}

val mockNotificationItems1 = persistentListOf(
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

val mockNotificationItems2 = persistentListOf(
    NotificationItem(
        id = "3",
        title = "Lời nhắc: Cuộc hẹn sắp tới",
        description = "Đừng quên cuộc hẹn của bạn vào ngày mai lúc 10 giờ sáng.",
        isRead = false,
        date = "2023-10-26"
    )
)

val mockNotificationGroupByDate = persistentListOf(
    NotificationGroupByDate(date = "Hôm nay", notifications = mockNotificationItems1),
    NotificationGroupByDate(date = "Hôm qua", notifications = mockNotificationItems2)
)