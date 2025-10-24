package com.haitrvn.saved

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.haitrvn.coreui.component.Header
import com.haitrvn.coreui.component.SmallSpace
import com.haitrvn.coreui.component.Tabs
import com.haitrvn.coreui.component.VideoCard
import com.haitrvn.coreui.theme.AppColors
import com.haitrvn.coreui.utils.toText
import cookapp.resources.saved.Res
import cookapp.resources.saved.saved_title
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.launch
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SavedScreen(
    modifier: Modifier = Modifier,
    viewModel: SavedViewModel = koinViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    SavedScreen(
        modifier = modifier,
        uiState = uiState,
    )
}

@Composable
fun SavedScreen(
    modifier: Modifier = Modifier,
    uiState: SavedScreenUiState,
) {
    val pagerState = rememberPagerState(pageCount = { SavedType.entries.size })
    val scope = rememberCoroutineScope()
    Column(
        modifier = modifier.fillMaxSize().background(AppColors.background)
    ) {
        Header(title = Res.string.saved_title.toText())
        Tabs(
            modifier = Modifier,
            listTabs = SavedType.entries.map { notificationType -> notificationType.title.toText() }.toPersistentList(),
            selectedTabIndex = pagerState.currentPage,
            onTabSelected = { scope.launch { pagerState.scrollToPage(it) } }
        )
        SavedVideoAndRecipePager(
            modifier = Modifier,
            pagerState = pagerState,
            notifications = uiState.listSaved,
            goToWatch = {},
            saveVideoAndRecipe = {},
            viewRate = {},
        )
    }
}

@Composable
fun SavedVideoAndRecipePager(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    notifications: PersistentList<SavedVideoAndRecipe>,
    goToWatch: (String) -> Unit = {},
    saveVideoAndRecipe: (String) -> Unit = {},
    viewRate: (String) -> Unit = {},
) {
    HorizontalPager(
        modifier = modifier.fillMaxSize(),
        state = pagerState
    ) { page ->
        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(items = notifications, key = { it.id }) { savedVideoAndRecipe ->
                    SmallSpace()
                    VideoCard(
                        modifier = Modifier.fillMaxWidth().height(maxWidth * 0.5f),
                        star = savedVideoAndRecipe.star,
                        isSaved = savedVideoAndRecipe.isSaved,
                        timeStamp = savedVideoAndRecipe.timeStamp,
                        title = savedVideoAndRecipe.title,
                        thumbnailUrl = savedVideoAndRecipe.thumbnailUrl,
                        onPlayClick = { goToWatch(savedVideoAndRecipe.id) },
                        onSaveClick = { saveVideoAndRecipe(savedVideoAndRecipe.id) },
                        onRateClick = { viewRate(savedVideoAndRecipe.id) },
                    )
                }
            }
        }
    }
}