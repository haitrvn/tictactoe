package com.haitrvn.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.haitrvn.coreui.component.H4
import com.haitrvn.coreui.component.Label
import com.haitrvn.coreui.component.Small
import com.haitrvn.coreui.component.Text
import com.haitrvn.coreui.theme.AppColors

data class NotificationItem(
    val id: String,
    val title: String,
    val description: String,
    val isRead: Boolean,
    val date: String
)

@Composable
fun NotificationScreen(
    modifier: Modifier = Modifier
) {
    var selectedTab by remember { mutableStateOf(0) }

    val notifications = remember {
        listOf(
            NotificationItem(
                id = "1",
                title = "New recipe!",
                description = "Far far away, behind the word mountains, far from the countries.",
                isRead = false,
                date = "Today"
            ),
            NotificationItem(
                id = "2",
                title = "Don't forget to try your saved recipe",
                description = "Far far away, behind the word mountains, far from the countries.",
                isRead = false,
                date = "Today"
            ),
            NotificationItem(
                id = "3",
                title = "Don't forget to try your saved recipe",
                description = "Far far away, behind the word mountains, far from the countries.",
                isRead = true,
                date = "Yesterday"
            )
        )
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(AppColors.background)
    ) {
        // Header
        NotificationHeader()

        // Tabs
        NotificationTabs(
            selectedTab = selectedTab,
            onTabSelected = { selectedTab = it }
        )

        // Notification List
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(
                horizontal = 20.dp,
                vertical = 12.dp
            ),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Today section
            item {
                Text.Label(
                    text = "Today",
                    color = AppColors.onBackground,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            val todayNotifications = notifications.filter { it.date == "Today" }
            items(todayNotifications) { notification ->
                NotificationItemCard(
                    notification = notification
                )
            }

            // Yesterday section
            item {
                Text.Label(
                    text = "Yesterday",
                    color = AppColors.onBackground,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }

            val yesterdayNotifications = notifications.filter { it.date == "Yesterday" }
            items(yesterdayNotifications) { notification ->
                NotificationItemCard(
                    notification = notification
                )
            }
        }
    }
}

@Composable
private fun NotificationHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text.H4(
            text = "Notifications",
            color = AppColors.onBackground
        )

        // Filter icon placeholder
        Box(
            modifier = Modifier
                .size(24.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(AppColors.onBackground.copy(alpha = 0.1f))
        )
    }
}

@Composable
private fun NotificationTabs(
    selectedTab: Int,
    onTabSelected: (Int) -> Unit
) {
    val tabs = listOf("All", "Unread", "Read")

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        tabs.forEachIndexed { index, tab ->
            val isSelected = selectedTab == index

            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (isSelected) AppColors.primary else Color.Transparent
                    )
                    .clickable { onTabSelected(index) }
                    .padding(vertical = 8.dp, horizontal = 12.dp),
                contentAlignment = Alignment.Center
            ) {
                Text.Small(
                    text = tab,
                    color = if (isSelected) AppColors.onPrimary else AppColors.primary.copy(alpha = 0.7f)
                )
            }
        }
    }
}

@Composable
private fun NotificationItemCard(
    notification: NotificationItem
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFFF1F1F1))
            .padding(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.Top
    ) {
        // Icon
        Box(
            modifier = Modifier
                .size(28.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFFCEECD7)),
            contentAlignment = Alignment.Center
        ) {
            // Recipe icon placeholder
            Box(
                modifier = Modifier
                    .size(16.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF31B057))
            )
        }

        // Content
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text.Small(
                text = notification.title,
                color = Color(0xFF303030)
            )
            Text.Small(
                text = notification.description,
                color = Color(0xFFA9A9A9)
            )
        }

        // Unread indicator
        if (!notification.isRead) {
            Box(
                modifier = Modifier
                    .size(6.dp)
                    .clip(CircleShape)
                    .background(AppColors.primary)
            )
        }
    }
}
