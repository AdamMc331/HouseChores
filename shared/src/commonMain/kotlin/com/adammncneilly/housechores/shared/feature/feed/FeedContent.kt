package com.adammncneilly.housechores.shared.feature.feed

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.adammncneilly.housechores.shared.feature.feed.components.ChoreGroupButtonRow
import com.adammncneilly.housechores.shared.ui.theme.HCTheme

@Composable
fun FeedContent(
    state: FeedUiState,
    onEvent: (FeedUiEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        modifier = modifier,
    ) {
        item {
            ChoreGroupButtonRow(
                selectedGroup = state.selectedChoreGroup,
                onGroupClicked = { group ->
                    onEvent.invoke(FeedUiEvent.ChoreGroupClicked(group))
                },
                modifier = Modifier
                    .fillMaxWidth(),
            )
        }
    }
}

@Composable
@PreviewLightDark
@PreviewFontScale
@PreviewDynamicColors
private fun FeedContentPreview() {
    val state = FeedUiState()

    HCTheme {
        Surface {
            FeedContent(
                state = state,
                onEvent = {},
                modifier = Modifier
                    .fillMaxSize(),
            )
        }
    }
}
