package com.adammncneilly.housechores.shared.feature.archive

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
fun ArchiveScreen(
    modifier: Modifier = Modifier,
    viewModel: ArchiveViewModel = metroViewModel(),
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

            ArchiveContent(
                state = state.value,
                modifier = Modifier
                    .statusBarsPadding(),
            )
        },
    )
}
