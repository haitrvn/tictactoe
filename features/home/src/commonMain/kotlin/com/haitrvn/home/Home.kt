package com.haitrvn.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.haitrvn.coreui.AuthInput
import com.haitrvn.coreui.CookSpace
import com.haitrvn.coreui.CookSurface
import com.haitrvn.coreui.HeaderText
import com.haitrvn.coreui.SpaceSize
import com.haitrvn.coreui.TextSmall
import com.haitrvn.coreui.TextTitle
import org.koin.compose.koinInject

@Composable
fun Home(
    modifier: Modifier = Modifier,
    viewmodel: HomeViewModel = koinInject<HomeViewModel>(),
) {
    HomeWrapper()
}

@Composable
fun HomeWrapper(
    modifier: Modifier = Modifier,
) {
    LazyColumn {
        item {
            HeaderText(text = "Find best recipees for cooking")
        }
        item {
            CookSpace(SpaceSize.MEDIUM)
            Search()
        }
        item {
            Trending()
        }
        item {
            Popular()
        }
        item {
            Recent()
        }
        item {
            Creator()
        }
    }
}

@Composable
fun Search(modifier: Modifier = Modifier) {
    AuthInput(value = "Search Recipes", label = "") {

    }
}

@Composable
fun Trending(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(0.3f)
    ) {
        Row {
            TextTitle(text = "Trending now (fire)")
            CookSpace(SpaceSize.MEDIUM)
            TextSmall(text = "See all")
        }
        LazyRow {
            items(10) {
                TrendingItem(
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                        .fillMaxHeight()
                )
            }
        }
    }
}

@Composable
fun TrendingItem(modifier: Modifier = Modifier) {
    CookSurface {
        TextTitle(modifier = Modifier.align(Alignment.TopStart), text = "4*")
        TextTitle(modifier = Modifier.align(Alignment.TopEnd), text = "10:10")
    }
}

@Composable
fun Popular(modifier: Modifier = Modifier) {

}

@Composable
fun Recent(modifier: Modifier = Modifier) {

}

@Composable
fun Creator(modifier: Modifier = Modifier) {

}