package com.adammncneilly.housechores.shared.navigation

import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.scene.SinglePaneSceneStrategy
import androidx.navigation3.ui.LocalNavAnimatedContentScope
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import androidx.window.core.layout.WindowSizeClass
import com.adammcneilly.housechores.scaffold.LocalNavAnimatedVisibilityScope
import com.adammcneilly.housechores.scaffold.app.LocalAppState
import com.adammcneilly.housechores.scaffold.navigation.HomeTab
import com.adammncneilly.housechores.shared.feature.feed.FeedScreen
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

private val config = SavedStateConfiguration {
    serializersModule = SerializersModule {
        polymorphic(NavKey::class) {
            subclass(AppScreen.Tab::class, AppScreen.Tab.serializer())
        }
    }
}

@Composable
fun AppNavHost() {
    val startDestination = AppScreen.Tab(HomeTab.News)

    val backStack = rememberNavBackStack(
        config,
        startDestination,
    )

    val appState = LocalAppState.current

    val currentTab = appState.currentSelectedTab

    LaunchedEffect(currentTab) {
        if (currentTab != null) {
            val previousTab = (backStack.lastOrNull() as? AppScreen.Tab)?.tab
            if (previousTab != null) {
                if (currentTab != previousTab) {
                    // Before adding this tab, drop everything up to the first tab
                    while (backStack.lastOrNull() != startDestination) {
                        backStack.removeLastOrNull()
                    }

                    // Need to navigate to current tab
                    backStack.add(AppScreen.Tab(currentTab))
                }
            }
        }
    }

    val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass

    val isMediumOrLargerWidth = windowSizeClass.isWidthAtLeastBreakpoint(
        widthDpBreakpoint = WindowSizeClass.WIDTH_DP_MEDIUM_LOWER_BOUND,
    )

    NavDisplay(
        backStack = backStack,
        onBack = {
            backStack.removeLastOrNull()

            // If we're navigating back to a home tab, update app state.
            val newTab = (backStack.lastOrNull() as? AppScreen.Tab)?.tab
            if (newTab != null) {
                appState.onNavItemSelected(newTab)
            }
        },
        sceneStrategies = listOf(
            SinglePaneSceneStrategy(),
            TwoPaneSceneStrategy(
                isMediumOrLargerWidth = isMediumOrLargerWidth,
            ),
        ),
        entryProvider = { key ->
            navEntryProvider(key)
        },
    )
}

private fun navEntryProvider(
    key: NavKey,
): NavEntry<NavKey> {
    return when (val screen = key as AppScreen) {
        is AppScreen.Tab -> {
            homeTabEntry(
                key = screen,
            )
        }
    }
}

private fun homeTabEntry(
    key: AppScreen.Tab,
): NavEntry<NavKey> {
    val metadata = if (key.tab.supportsTwoPane) {
        TwoPaneScene.twoPane()
    } else {
        emptyMap()
    }

    return NavEntry(
        key = key,
        metadata = metadata,
    ) {
        CompositionLocalProvider(
            LocalNavAnimatedVisibilityScope provides LocalNavAnimatedContentScope.current,
        ) {
            when (key.tab) {
                HomeTab.News -> {
                    FeedScreen()
                }

                HomeTab.Launches -> {
                    FeedScreen()
                }

                HomeTab.Astronauts -> {
                    FeedScreen()
                }

                HomeTab.Stations -> {
                    FeedScreen()
                }
            }
        }
    }
}
