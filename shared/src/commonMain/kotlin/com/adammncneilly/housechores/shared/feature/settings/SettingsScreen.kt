package com.adammncneilly.housechores.shared.feature.settings

import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.adammcneilly.housechores.scaffold.PersistentScaffold
import com.adammcneilly.housechores.scaffold.navigation.components.PersistentNavigationBar
import com.adammcneilly.housechores.scaffold.navigation.components.PersistentNavigationRail
import com.adammcneilly.housechores.scaffold.rememberScaffoldState
import dev.zacsweers.metrox.viewmodel.metroViewModel

@Composable
fun SettingsScreen(
    modifier: Modifier = Modifier,
    viewModel: SettingsViewModel = metroViewModel(),
) {
    rememberScaffoldState().PersistentScaffold(
        modifier = modifier,
        navigationBar = {
            PersistentNavigationBar()
        },
        navigationRail = {
            PersistentNavigationRail()
        },
        content = {
            val state = viewModel.state.collectAsState()

            SettingsContent(
                state = state.value,
                modifier = Modifier
                    .statusBarsPadding(),
            )
        },
    )
}
