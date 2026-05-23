package com.adammncneilly.housechores.shared.feature.archive

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
@Suppress("UnusedParameter")
fun ArchiveContent(
    state: ArchiveUiState,
    modifier: Modifier = Modifier,
) {
    Text(
        text = "Archive Content",
        modifier = modifier,
    )
}
