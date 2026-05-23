package com.adammncneilly.housechores.shared.feature.settings

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
@Suppress("UnusedParameter")
fun SettingsContent(
    state: SettingsUiState,
    modifier: Modifier = Modifier,
) {
    Text(
        text = "Settings Content",
        modifier = modifier,
    )
}
