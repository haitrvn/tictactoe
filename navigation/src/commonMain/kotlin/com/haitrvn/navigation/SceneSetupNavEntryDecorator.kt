package com.haitrvn.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.runtime.movableContentOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavEntryDecorator

internal class SceneSetupNavEntryDecorator<T : Any>(
    val movableContentMap: MutableMap<Any, @Composable (@Composable () -> Unit) -> Unit> =
        mutableStateMapOf()
) :
    NavEntryDecorator<T>(
        onPop = { contentKey -> movableContentMap.remove(contentKey) },
        decorate = { entry ->
            val contentKey = entry.contentKey
            // If we should not be rendering this entry here in the current scene, we skip calling
            // entry.Content and all nested content wrappers. If this is the case here, then it
            // means
            // that this entry is being rendered by a different scene somewhere else.
            val entriesToExclude = LocalEntriesToExcludeFromCurrentScene.current
            // If no LocalEntriesToRenderInCurrentScene is provided, assume all entries are allowed
            if (!entriesToExclude.contains(contentKey)) {
                key(contentKey) {
                    // In case the key is removed from the backstack while this is still
                    // being rendered, we remember the movableContent directly to allow
                    // rendering it while we are animating out.
                    val movableContent = remember {
                        // Get or put a movableContentOf for this content key
                        // This represents a "slot" that can be moved around, specifically to be
                        // rendered in a different place in the UI callstack hierarchy while
                        // maintaining all internal state
                        movableContentMap.getOrPut(contentKey) {
                            // We don't capture entry.Content() here, as that could result in a
                            // stale
                            // entry.Content() call as we want to create a movableContentOf only
                            // once for each entry. Instead, we pass through the entry's content as
                            // a composable here to be invoked below
                            movableContentOf { content -> content() }
                        }
                    }

                    // Finally, render the entry content via the movableContentOf
                    movableContent { entry.Content() }
                }
            }
        },
    )