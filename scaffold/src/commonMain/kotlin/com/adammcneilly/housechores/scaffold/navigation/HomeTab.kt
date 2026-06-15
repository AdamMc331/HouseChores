package com.adammcneilly.housechores.scaffold.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Feed
import androidx.compose.material.icons.filled.Feed
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Defines a tab that will be shown on the home screen in a navigation container.
 */
enum class HomeTab(
    val label: String,
    val icon: ImageVector,
    val supportsTwoPane: Boolean,
) {
    Feed(
        label = "Feed",
        icon = Icons.AutoMirrored.Filled.Feed,
        supportsTwoPane = false,
    ),
    Archive(
        label = "Archive",
        icon = Icons.Default.History,
        supportsTwoPane = false,
    ),
    Settings(
        label = "Settings",
        icon = Icons.Default.Settings,
        supportsTwoPane = false,
    ),
}
