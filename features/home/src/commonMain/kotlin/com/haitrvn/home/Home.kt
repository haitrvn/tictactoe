package com.haitrvn.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.haitrvn.coreui.MediumSpace
import com.haitrvn.coreui.Text
import com.haitrvn.coreui.Title
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
        }
        item {
            MediumSpace()
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
fun Trending(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight(0.3f)
    ) {
        Row {
            Text.Title(text = "Trending now (fire)")
            MediumSpace()
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
    Text.Title(text = "4*")
    Text.Title(text = "10:10")
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