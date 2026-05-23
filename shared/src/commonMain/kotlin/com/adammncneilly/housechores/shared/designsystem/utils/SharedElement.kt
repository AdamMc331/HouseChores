package com.adammncneilly.housechores.shared.designsystem.utils

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.adammcneilly.housechores.scaffold.LocalNavAnimatedVisibilityScope
import com.adammcneilly.housechores.scaffold.LocalSharedTransitionScope
import com.adammncneilly.housechores.shared.navigation.LocalSceneType
import com.adammncneilly.housechores.shared.navigation.SceneType

/**
 * Custom wrapper around the Compose foundation sharedElement modifier, that will only apply
 * if we have the relevant local scopes defined. Otherwise we'll return early with the current modifier.
 */
@Composable
@OptIn(ExperimentalSharedTransitionApi::class)
fun Modifier.sharedElement(
    key: String,
): Modifier {
    val sharedTransitionScope = LocalSharedTransitionScope.current
    val animatedVisibilityScope = LocalNavAnimatedVisibilityScope.current
    val localSceneType = LocalSceneType.current

    if (
        sharedTransitionScope == null ||
        animatedVisibilityScope == null ||
        (localSceneType == SceneType.TwoPane)
    ) {
        return this
    }

    return with(sharedTransitionScope) {
        this@sharedElement.sharedElement(
            sharedContentState = rememberSharedContentState(
                key = key,
            ),
            animatedVisibilityScope = animatedVisibilityScope,
        )
    }
}
