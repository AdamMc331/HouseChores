package com.adammncneilly.housechores.shared

import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.adammcneilly.housechores.scaffold.LocalSharedTransitionScope
import com.adammcneilly.housechores.scaffold.app.AppState
import com.adammcneilly.housechores.scaffold.app.LocalAppState
import com.adammncneilly.housechores.shared.di.AppGraph
import com.adammncneilly.housechores.shared.navigation.AppNavHost
import com.adammncneilly.housechores.shared.ui.theme.HCTheme
import dev.zacsweers.metro.createGraph
import dev.zacsweers.metrox.viewmodel.LocalMetroViewModelFactory

@Preview
@Composable
fun App() {
    val appState = rememberSaveable(saver = AppState.appStateSaver) {
        AppState()
    }

    val appGraph = createGraph<AppGraph>()

    HCTheme {
        Surface {
            SharedTransitionLayout(
                modifier = Modifier
                    .fillMaxSize(),
            ) {
                CompositionLocalProvider(
                    LocalSharedTransitionScope provides this,
                    LocalAppState provides appState,
                    LocalMetroViewModelFactory provides appGraph.metroVmf,
                ) {
                    AppNavHost()
                }
            }
        }
    }
}
