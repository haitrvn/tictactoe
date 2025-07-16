package com.haitrvn.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.koin.compose.koinInject

@Composable
fun Home(
    modifier: Modifier = Modifier,
    viewmodel: HomeViewModel = koinInject<HomeViewModel>(),
) {
}

@Composable
private fun Header(modifier: Modifier = Modifier) {

}

@Composable
fun Search(modifier: Modifier = Modifier) {

}

@Composable
fun Trending(modifier: Modifier = Modifier) {

}

@Composable
fun Popular(modifier: Modifier = Modifier) {
    
}

@Composable
fun Recent(modifier: Modifier = Modifier) {
    
}

@Composable
fun PopularUser(modifier: Modifier = Modifier) {

}