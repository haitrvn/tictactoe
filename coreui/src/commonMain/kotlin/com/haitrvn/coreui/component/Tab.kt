package com.haitrvn.coreui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.haitrvn.coreui.theme.AppColors
import com.haitrvn.coreui.theme.Dimensions
import com.haitrvn.coreui.theme.Shapes
import kotlinx.collections.immutable.PersistentList

@Composable
fun Tabs(
    modifier: Modifier = Modifier,
    listTabs: PersistentList<String>,
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth()
            .padding(horizontal = Dimensions.medium, vertical = Dimensions.small),
        horizontalArrangement = Arrangement.spacedBy(Dimensions.small)
    ) {
        listTabs.forEachIndexed { index, tab ->
            Tab(
                modifier = Modifier.fillMaxWidth().weight(1f),
                text = tab,
                isSelected = index == selectedTabIndex,
            ) {
                onTabSelected(index)
            }
        }
    }
}

@Composable
fun LazyTabs(
    modifier: Modifier = Modifier,
    listTabs: PersistentList<String>,
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit
) {
    LazyRow(
        modifier = modifier.fillMaxWidth()
            .padding(horizontal = Dimensions.medium, vertical = Dimensions.small),
        horizontalArrangement = Arrangement.spacedBy(Dimensions.small)
    ) {
        items(listTabs.size) { index ->
            Tab(
                modifier = Modifier.wrapContentWidth(),
                text = listTabs[index],
                isSelected = index == selectedTabIndex,
            ) {
                onTabSelected(index)
            }
        }
    }
}

@Composable
fun Tab(
    modifier: Modifier = Modifier,
    isSelected: Boolean,
    text: String,
    onTabSelected: () -> Unit
) {
    Box(
        modifier = modifier
            .clip(Shapes.rounded)
            .background(
                if (isSelected) AppColors.primary else AppColors.surface
            )
            .clickable { onTabSelected() }
            .padding(vertical = Dimensions.small, horizontal = Dimensions.medium),
        contentAlignment = Alignment.Center
    ) {
        Text.SmallBold(
            text = text,
            color = if (isSelected) AppColors.onPrimary else AppColors.onSurface
        )
    }
}