package com.adammncneilly.housechores.shared.feature.feed

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.adammncneilly.housechores.shared.feature.feed.components.ChoreGroupButtonRow
import com.adammncneilly.housechores.shared.feature.feed.components.taskcard.TaskCard
import com.adammncneilly.housechores.shared.feature.feed.components.taskcard.TaskCardData
import com.adammncneilly.housechores.shared.models.Task
import com.adammncneilly.housechores.shared.ui.theme.HCTheme
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock

@Composable
fun FeedContent(
    state: FeedUiState,
    onEvent: (FeedUiEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
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

        state.taskGroups.entries.forEach { (title, items) ->
            item {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge,
                )
            }

            items(items) { task ->
                TaskCard(
                    data = TaskCardData(
                        title = task.title,
                        actions = listOf(
                            TaskCardData.Action(
                                label = "Done",
                                onClick = {},
                            ),
                        ),
                    ),
                )
            }
        }
    }
}

@Composable
@PreviewLightDark
@PreviewFontScale
private fun FeedContentPreview() {
    val tasks = mapOf(
        "Today" to List(2) { index ->
            Task(
                id = index.toString(),
                title = "Task: $index",
                dueDate = Clock.System
                    .now()
                    .toLocalDateTime(TimeZone.currentSystemDefault())
                    .date,
            )
        },
        "This Week" to List(2) { index ->
            Task(
                id = index.toString(),
                title = "Task: $index",
                dueDate = Clock.System
                    .now()
                    .toLocalDateTime(TimeZone.currentSystemDefault())
                    .date,
            )
        },
    )

    val state = FeedUiState(
        taskGroups = tasks,
    )

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
