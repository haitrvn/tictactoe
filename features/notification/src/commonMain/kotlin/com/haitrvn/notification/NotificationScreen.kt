package com.haitrvn.notification

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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.haitrvn.coreui.component.Header
import com.haitrvn.coreui.component.LabelBold
import com.haitrvn.coreui.component.Small
import com.haitrvn.coreui.component.SmallSpace
import com.haitrvn.coreui.component.Tab
import com.haitrvn.coreui.component.Tabs
import com.haitrvn.coreui.component.Text
import com.haitrvn.coreui.theme.AppColors
import com.haitrvn.coreui.theme.Dimensions
import com.haitrvn.coreui.utils.toText
import com.haitrvn.navigation.Main
import com.haitrvn.navigation.Navigator
import cookapp.resources.notification.Res
import cookapp.resources.notification.notification_title
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.launch
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun NotificationScreen(
    modifier: Modifier = Modifier,
    navigator: Navigator,
    viewModel: NotificationViewModel = koinViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    NotificationScreen(
        modifier = modifier,
        uiState = uiState,
        goToDetail = { navigator.navigate(Main.Notification.Detail(it)) }
    )
}

@Composable
fun NotificationScreen(
    modifier: Modifier = Modifier,
    uiState: NotificationScreenUiState,
    goToDetail: (String) -> Unit = {},
) {
    val pagerState = rememberPagerState(pageCount = { NotificationType.entries.size })
    val scope = rememberCoroutineScope()
    Column(
        modifier = modifier.fillMaxSize().background(AppColors.background)
    ) {
        Header(
            modifier = Modifier.fillMaxWidth(),
            title = Res.string.notification_title.toText(),
            headerAction = {})
        Tabs(
            modifier = Modifier,
            listTabs = NotificationType.entries.map { notificationType -> notificationType.title.toText() }
                .toPersistentList(),
            selectedTabIndex = pagerState.currentPage,
            onTabSelected = { scope.launch { pagerState.scrollToPage(it) } }
        )
        NotificationPager(
            modifier = Modifier.fillMaxSize().padding(Dimensions.medium),
            pagerState = pagerState,
            notifications = uiState.notifications,
            goToDetail = goToDetail,
        )
    }
}

@Composable
fun NotificationPager(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    notifications: PersistentList<NotificationGroupByDate>,
    goToDetail: (String) -> Unit = {},
) {
    HorizontalPager(
        modifier = Modifier.fillMaxSize(),
        state = pagerState
    ) { page ->
        LazyColumn(modifier = modifier.fillMaxSize()) {
            notifications.forEach { (date, notificationsForDay) ->
                item {
                    Text.LabelBold(
                        modifier = Modifier.padding(vertical = Dimensions.medium),
                        text = date
                    )
                }
                items(items = notificationsForDay, key = { it.id }) { notification ->
                    NotificationItemCard(notification, goToDetail)
                    SmallSpace()
                }
            }
        }
    }
}

@Composable
private fun NotificationTabs(
    modifier: Modifier = Modifier,
    selectedTab: NotificationType,
    onTabSelected: (NotificationType) -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth()
            .padding(horizontal = Dimensions.medium, vertical = Dimensions.small),
        horizontalArrangement = Arrangement.spacedBy(Dimensions.small)
    ) {
        NotificationType.entries.forEachIndexed { index, tab ->
            Tab(
                modifier = Modifier.fillMaxWidth().weight(1f),
                text = tab.title.toText(),
                isSelected = selectedTab == tab,
            ) {
                onTabSelected(tab)
            }
        }
    }
}

@Composable
private fun NotificationItemCard(
    notification: NotificationItem,
    notificationClick: (String) -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(12.dp))
            .clickable { notificationClick(notification.id) }
            .background(Color(0xFFF1F1F1)).padding(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.Top
    ) {
        // Icon
        Box(
            modifier = Modifier.size(28.dp).clip(RoundedCornerShape(10.dp))
                .background(Color(0xFFCEECD7)), contentAlignment = Alignment.Center
        ) {
            // Recipe icon placeholder
            Box(
                modifier = Modifier.size(16.dp).clip(CircleShape).background(Color(0xFF31B057))
            )
        }

        // Content
        Column(
            modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text.Small(
                text = notification.title, color = Color(0xFF303030)
            )
            Text.Small(
                text = notification.description, color = Color(0xFFA9A9A9)
            )
        }

        if (!notification.isRead) {
            Box(
                modifier = Modifier.size(6.dp).clip(CircleShape).background(AppColors.primary)
            )
        }
    }
}
