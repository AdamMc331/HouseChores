package com.adammncneilly.housechores.shared.feature.feed

import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adammcneilly.housechores.scaffold.PersistentScaffold
import com.adammcneilly.housechores.scaffold.navigation.components.PersistentNavigationBar
import com.adammcneilly.housechores.scaffold.navigation.components.PersistentNavigationRail
import com.adammcneilly.housechores.scaffold.rememberScaffoldState

@Composable
fun FeedScreen(
    modifier: Modifier = Modifier,
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
            Text(
                text = "Feed Screen",
                modifier = Modifier
                    .statusBarsPadding(),
            )
        }
    )
}
