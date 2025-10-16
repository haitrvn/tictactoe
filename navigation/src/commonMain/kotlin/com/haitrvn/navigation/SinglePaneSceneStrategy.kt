package com.haitrvn.navigation

import androidx.navigation3.runtime.NavEntry

class SinglePaneSceneStrategy<T : Any> : SceneStrategy<T> {

    override fun SceneStrategyScope<T>.calculateScene(entries: List<NavEntry<T>>): Scene<T> {
        return SinglePaneScene(
            key = entries.last().contentKey,
            entry = entries.last(),
            previousEntries = entries.dropLast(1),
        )
    }
}
