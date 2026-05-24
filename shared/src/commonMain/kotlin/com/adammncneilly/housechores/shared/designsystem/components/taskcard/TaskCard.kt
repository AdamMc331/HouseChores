package com.adammncneilly.housechores.shared.designsystem.components.taskcard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.adammncneilly.housechores.shared.ui.theme.HCTheme

@Composable
fun TaskCard(
    data: TaskCardData,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Text(
                text = data.title,
                style = MaterialTheme.typography.titleMedium,
            )

            if (data.actions.isNotEmpty()) {
                Row(
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(top = 16.dp),
                ) {
                    for (action in data.actions) {
                        TextButton(
                            onClick = action.onClick,
                        ) {
                            Text(
                                text = action.label,
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
@PreviewLightDark
@PreviewFontScale
@PreviewDynamicColors
private fun TaskCardPreview() {
    val data = TaskCardData(
        title = "Clean Washing Machine",
        actions = listOf(
            TaskCardData.Action(
                label = "Done",
                onClick = {},
            ),
        ),
    )

    HCTheme {
        TaskCard(
            data = data,
            modifier = Modifier
                .fillMaxWidth(),
        )
    }
}
