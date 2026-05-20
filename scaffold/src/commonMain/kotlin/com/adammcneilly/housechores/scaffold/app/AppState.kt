package com.adammcneilly.housechores.scaffold.app

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.mapSaver
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import com.adammcneilly.housechores.scaffold.navigation.HomeTab
import com.adammcneilly.housechores.scaffold.navigation.NavItem

/**
 * A composition local provider for [AppState] allows us to
 * access app wide navigation data from within any subscreen that
 * needs it.
 */
val LocalAppState = staticCompositionLocalOf<AppState> {
    throw IllegalArgumentException("AppState must be provided in the app scaffolding.")
}

/**
 * The application state container, it's main purpose to expose the
 * shared business logic like navigation state via [navItems].
 */
class AppState(
    initialNavItems: List<NavItem>,
) {
    constructor(
        selectedTab: HomeTab = HomeTab.News,
    ) : this(
        initialNavItems = HomeTab.entries.map { tab ->
            NavItem(
                tab = tab,
                selected = (tab == selectedTab),
            )
        },
    )

    var navItems: List<NavItem> by mutableStateOf(initialNavItems)
        private set

    val currentSelectedTab: HomeTab?
        get() = navItems
            .firstOrNull { navItem ->
                navItem.selected
            }?.tab

    fun onNavItemSelected(
        tab: HomeTab,
    ) {
        navItems = navItems.map { navItem ->
            navItem.copy(
                selected = (navItem.tab == tab),
            )
        }
    }

    companion object {
        private val navItemSaver = listSaver<NavItem, Any>(
            save = {
                listOf(it.tab, it.selected)
            },
            restore = {
                NavItem(
                    it[0] as HomeTab,
                    it[1] as Boolean,
                )
            }
        )
        val appStateSaver = mapSaver<AppState>(
            save = { appState ->
                mapOf(
                    "navItems" to appState.navItems.map { navItem ->
                        with (navItemSaver) {
                            save(navItem)
                        }
                    }
                )
            },
            restore = { map ->
                val savedNavItems = map["navItems"] as? List<*>

                val navItems = savedNavItems?.mapNotNull {
                    navItemSaver.restore(it ?: return@mapNotNull null)
                }.orEmpty()

                AppState(initialNavItems = navItems)
            }
        )
    }
}
