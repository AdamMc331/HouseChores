package com.adammncneilly.housechores.shared.feature.feed

import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.adammcneilly.housechores.scaffold.PersistentScaffold
import com.adammcneilly.housechores.scaffold.navigation.components.PersistentNavigationBar
import com.adammcneilly.housechores.scaffold.navigation.components.PersistentNavigationRail
import com.adammcneilly.housechores.scaffold.rememberScaffoldState
import dev.zacsweers.metrox.viewmodel.metroViewModel

@Composable
fun FeedScreen(
    modifier: Modifier = Modifier,
    viewModel: FeedViewModel = metroViewModel(),
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

            FeedContent(
                state = state.value,
                modifier = Modifier
                    .statusBarsPadding(),
            )
        },
    )
}
