package com.haitrvn.home

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.haitrvn.coreui.Paragraph
import com.haitrvn.coreui.Text
import com.haitrvn.coreui.utils.toText
import com.haitrvn.navigation.NavigationItem
import org.jetbrains.compose.resources.vectorResource

@Composable
fun BottomNavigationBar(
    items: List<NavigationItem>,
    currentRoute: String?,
    onItemClick: (NavigationItem) -> Unit,
    onItemReClick: (Boolean, NavigationItem) -> Unit = { _, _ -> },
) {
    NavigationBar(
        modifier = Modifier.fillMaxWidth(),
    ) {
        items.forEach { navigationItem ->
            val isSelected =
                currentRoute?.contains(navigationItem.destination::class.qualifiedName ?: "")
                    ?: false
            val isShouldCallReload =
                currentRoute == navigationItem.startDestination::class.qualifiedName
            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    if (isSelected) {
                        onItemReClick(isShouldCallReload, navigationItem)
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
                    Text.Paragraph(
                        text = navigationItem.title.toText(),
                    )
                },
            )
        }
    }
}