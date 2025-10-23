package com.haitrvn.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.haitrvn.coreui.component.Button
import com.haitrvn.coreui.component.Circle
import com.haitrvn.coreui.component.H5
import com.haitrvn.coreui.component.Header
import com.haitrvn.coreui.component.Image
import com.haitrvn.coreui.component.Input
import com.haitrvn.coreui.component.LazyTabs
import com.haitrvn.coreui.component.Text
import com.haitrvn.coreui.component.VideoCard
import com.haitrvn.coreui.theme.AppColors
import com.haitrvn.coreui.utils.toText
import com.haitrvn.navigation.Navigator
import cookapp.resources.home.Res
import cookapp.resources.home.home_see_all
import cookapp.resources.home.home_title
import cookapp.resources.home.home_trending
import kotlinx.collections.immutable.PersistentList
import kotlinx.collections.immutable.persistentListOf
import org.koin.compose.viewmodel.koinViewModel

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
fun RecentRecipe(modifier: Modifier = Modifier) {

}

@Composable
fun PopularPeople(modifier: Modifier = Modifier) {

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
        Popular()
    }
}

@Composable
fun Popular(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text.H5(text = Res.string.home_trending.toText())
            Button.Text(text = Res.string.home_see_all.toText(), onClick = {})
        }
        LazyTabs(
            modifier = Modifier,
            listTabs = persistentListOf(
                "Salad",
                "Pizza",
                "Noodle",
                "Meat",
                "Dessert",
                "Soup",
                "Breakfast",
                "Seafood",
                "Vegan",
                "Drink"
            ),
            selectedTabIndex = 1,
            onTabSelected = {},
        )
    }
}

@Composable
fun PopularRecipe(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(0.75f)
                .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                .background(AppColors.primary)
                .align(Alignment.BottomCenter),
        ) {}
        Column(modifier = Modifier.fillMaxSize()) {
            Image.Circle(
                modifier = Modifier.fillMaxWidth(0.5f).aspectRatio(1f),
                source = ""
            )

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
        Row(modifier = Modifier.fillMaxWidth()) {
            Text.H5(text = Res.string.home_trending.toText())
            Button.Text(text = Res.string.home_see_all.toText(), onClick = {})
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

data class SavedVideoAndRecipe(
    val id: String,
    val title: String,
    val star: Float,
    val isSaved: Boolean,
    val timeStamp: Long,
    val thumbnailUrl: String,
)
