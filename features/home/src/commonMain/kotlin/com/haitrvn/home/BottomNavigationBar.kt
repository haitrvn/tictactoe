package com.haitrvn.home

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.haitrvn.core.Log
import com.haitrvn.coreui.TextParagraph
import com.haitrvn.coreui.utils.toText
import com.haitrvn.navigation.NavigationItem
import org.jetbrains.compose.resources.vectorResource

@Composable
fun BottomNavigationBar(
    items: List<NavigationItem>,
    currentRoute: String?,
    onItemClick: (NavigationItem) -> Unit,
    onItemReClick: (NavigationItem) -> Unit = {},
) {
    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
    ) {
        items.forEach { navigationItem ->
            val isSelected = currentRoute?.contains(navigationItem.destination::class.qualifiedName ?: "") ?: false
            val isShouldCallReload = currentRoute == navigationItem.destination::class.qualifiedName
            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    Log.d("BottomNavigationBar", "onClick: $currentRoute ${navigationItem.destination::class.qualifiedName}")
                        if (isSelected) {

                            onItemReClick(navigationItem)
                        } else {
                            onItemClick(navigationItem)
                        }
                },
                icon = {
                    Icon(
                        imageVector = vectorResource(navigationItem.unSelectedIcon),
                        contentDescription = navigationItem.title.toText(),
                    )
                },
                label = {
                    TextParagraph(
                        text = navigationItem.title.toText(),
                    )
                },
            )
        }
    }
}