package com.haitrvn.tictactoe

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.haitrvn.coreui.CommonText
import com.haitrvn.navigation.Destination
import com.haitrvn.navigation.NavigationItem
import org.jetbrains.compose.resources.vectorResource

@Composable
fun BottomNavigationBar(
    items: List<NavigationItem>,
    currentRoute: Destination?,
    onItemClick: (NavigationItem) -> Unit
) {
    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
    ) {
        items.forEach { navigationItem ->
            NavigationBarItem(
                selected = currentRoute == navigationItem.destination,
                onClick = { onItemClick(navigationItem) },
                icon = {
                    Icon(
                        imageVector = vectorResource(navigationItem.unSelectedIcon),
                        contentDescription = navigationItem.title,
                    )
                },
                label = {
                    CommonText(
                        text = navigationItem.title,
                        maxLines = 1,
                    )
                },
            )
        }
    }
}