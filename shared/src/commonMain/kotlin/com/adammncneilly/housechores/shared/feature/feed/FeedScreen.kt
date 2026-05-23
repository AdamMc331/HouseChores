package com.adammncneilly.housechores.shared.feature.feed

import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.adammcneilly.housechores.scaffold.PersistentScaffold
import com.adammcneilly.housechores.scaffold.navigation.components.PersistentFloatingActionButton
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
        floatingActionButton = {
            PersistentFloatingActionButton(
                text = {
                    Text(
                        text = "Add Task",
                    )
                },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null,
                    )
                },
                onClick = {
                    viewModel.onEvent(FeedUiEvent.AddTaskClicked)
                },
                shape = CircleShape,
                expanded = true,
            )
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
