package com.adammncneilly.housechores.shared.feature.feed

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
import com.adammncneilly.housechores.shared.displaymodels.TaskDisplayModel

@Composable
fun TaskCard(
    task: TaskDisplayModel,
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
                text = task.title,
                style = MaterialTheme.typography.titleMedium,
            )

            Row(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(top = 16.dp),
            ) {
                TextButton(
                    onClick = {},
                ) {
                    Text(
                        text = "Complete",
                    )
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
    val task = TaskDisplayModel(
        id = "123",
        title = "Clean Washing Machine",
    )

    TaskCard(
        task = task,
        modifier = Modifier
            .fillMaxWidth(),
    )
}
