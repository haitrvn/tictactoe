package com.haitrvn.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavEntry

internal data class SinglePaneScene<T : Any>(
    override val key: Any,
    val entry: NavEntry<T>,
    override val previousEntries: List<NavEntry<T>>,
) : Scene<T> {
    override val entries: List<NavEntry<T>> = listOf(entry)

    override val content: @Composable () -> Unit = { entry.Content() }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as SinglePaneScene<*>

        return key == other.key &&
                entry == other.entry &&
                previousEntries == other.previousEntries &&
                entries == other.entries
    }

    override fun hashCode(): Int {
        return key.hashCode() * 31 +
                entry.hashCode() * 31 +
                previousEntries.hashCode() * 31 +
                entries.hashCode() * 31
    }

    override fun toString(): String {
        return "SinglePaneScene(key=$key, entry=$entry, previousEntries=$previousEntries, entries=$entries)"
    }
}