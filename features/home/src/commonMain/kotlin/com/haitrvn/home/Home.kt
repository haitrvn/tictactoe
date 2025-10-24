package com.haitrvn.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.haitrvn.coreui.component.Bookmark
import com.haitrvn.coreui.component.Button
import com.haitrvn.coreui.component.Circle
import com.haitrvn.coreui.component.H5
import com.haitrvn.coreui.component.Header
import com.haitrvn.coreui.component.Image
import com.haitrvn.coreui.component.Input
import com.haitrvn.coreui.component.LabelBold
import com.haitrvn.coreui.component.LazyTabs
import com.haitrvn.coreui.component.Small
import com.haitrvn.coreui.component.SmallBold
import com.haitrvn.coreui.component.Text
import com.haitrvn.coreui.component.Title
import com.haitrvn.coreui.component.VideoCard
import com.haitrvn.coreui.theme.AppColors
import com.haitrvn.coreui.theme.Dimensions
import com.haitrvn.coreui.utils.toText
import com.haitrvn.navigation.Main
import com.haitrvn.navigation.Navigator
import cookapp.resources.home.Res
import cookapp.resources.home.home_time
import cookapp.resources.home.home_title
import cookapp.resources.home.home_trending
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import org.koin.compose.getKoin
import org.koin.compose.scope.rememberKoinScope
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.context.startKoin

@Composable
fun Home(
    modifier: Modifier = Modifier,
    navigator: Navigator,
    viewmodel: HomeViewModel = koinViewModel(),
) {
    val uiState by viewmodel.uiState.collectAsStateWithLifecycle()
    Home(
        modifier = modifier,
        trendingVideos = persistentListOf(),
    )
}

@Composable
fun Home(
    modifier: Modifier = Modifier,
    trendingVideos: PersistentList<SavedVideoAndRecipe>,
    goToWatch: (String) -> Unit = {},
    saveVideoAndRecipe: (String) -> Unit = {},
    viewRate: (String) -> Unit = {},
) {
    Column(modifier = modifier) {
        Header(title = Res.string.home_title.toText())
        Input.Text(value = "", onValueChange = {})
        Trending(
            trendingVideos = trendingVideos,
            goToWatch = goToWatch,
            saveVideoAndRecipe = saveVideoAndRecipe,
            viewRate = viewRate,
        )
        Popular(listPopularRecipe = persistentListOf("", "", "", "", ""))
        RecentRecipe()
        PopularPeople()
    }
}


@Composable
fun Popular(
    modifier: Modifier = Modifier,
    listPopularRecipe: PersistentList<String>
) {
    Column(modifier = modifier) {
        Text.H5(modifier = Modifier.fillMaxWidth(), text = Res.string.home_trending.toText())
        LazyTabs(
            modifier = Modifier,
            listTabs = listPopularRecipe,
            selectedTabIndex = 1,
            onTabSelected = {},
        )
        LazyRow {
            items(listPopularRecipe) {
                PopularRecipe(
                    modifier = Modifier,
                    title = "title",
                    time = "time",
                    isSaved = false,
                    recipeImageUrl = "",
                    onBookmarkClick = {}
                )
            }
        }
    }
}

@Composable
fun PopularRecipe(
    modifier: Modifier = Modifier,
    title: String,
    time: String,
    isSaved: Boolean,
    recipeImageUrl: String,
    onBookmarkClick: (Boolean) -> Unit,
) {
    BoxWithConstraints(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
                .padding(top = maxWidth * 0.25f)
                .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                .background(AppColors.primary)
                .align(Alignment.BottomCenter),
        ) {}
        Column(
            modifier = Modifier.fillMaxWidth().align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image.Circle(
                modifier = Modifier.fillMaxWidth(0.5f).aspectRatio(1f),
                source = recipeImageUrl
            )
            Column(
                modifier = Modifier.fillMaxSize().padding(Dimensions.small),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text.LabelBold(text = title, textAlign = TextAlign.Center)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Column {
                        Text.Small(text = Res.string.home_time.toText())
                        Text.SmallBold(text = time)
                    }
                    Button.Bookmark(modifier = Modifier.size(24.dp), isSaved = isSaved) {
                        onBookmarkClick(isSaved)
                    }
                }
            }
        }
    }
}

@Composable
fun Trending(
    modifier: Modifier = Modifier,
    trendingVideos: PersistentList<SavedVideoAndRecipe>,
    goToWatch: (String) -> Unit,
    saveVideoAndRecipe: (String) -> Unit,
    viewRate: (String) -> Unit
) {
    Column(modifier = modifier) {
        Title(modifier = modifier.fillMaxWidth(), title = Res.string.home_trending.toText()) {

        }
        BoxWithConstraints(modifier = Modifier) {
            LazyRow {
                items(trendingVideos) { savedVideoAndRecipe ->
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

@Composable
fun RecentRecipe(modifier: Modifier = Modifier) {

}

@Composable
fun PopularPeople(modifier: Modifier = Modifier) {

}

data class SavedVideoAndRecipe(
    val id: String,
    val title: String,
    val star: Float,
    val isSaved: Boolean,
    val timeStamp: Long,
    val thumbnailUrl: String,
)
