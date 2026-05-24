package com.adammncneilly.housechores.shared.feature.feed.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.adammncneilly.housechores.shared.feature.feed.ChoreGroup
import com.adammncneilly.housechores.shared.ui.theme.HCTheme

@Composable
fun ChoreGroupButtonRow(
    selectedGroup: ChoreGroup,
    onGroupClicked: (ChoreGroup) -> Unit,
    modifier: Modifier = Modifier,
) {
    SingleChoiceSegmentedButtonRow(
        modifier = modifier,
    ) {
        ChoreGroup.entries.forEachIndexed { index, group ->
            SegmentedButton(
                selected = (group == selectedGroup),
                onClick = {
                    onGroupClicked.invoke(group)
                },
                shape = SegmentedButtonDefaults.itemShape(index, ChoreGroup.entries.size),
                label = {
                    Text(
                        text = getLabel(group),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                },
                icon = {},
            )
        }
    }
}

private fun getLabel(group: ChoreGroup): String {
    return when (group) {
        ChoreGroup.MyChores -> {
            "My Chores"
        }

        ChoreGroup.HouseChores -> {
            "House Chores"
        }
    }
}

@Composable
@PreviewLightDark
@PreviewFontScale
@PreviewDynamicColors
private fun ChoreGroupButtonRowPreview() {
    HCTheme {
        Surface {
            ChoreGroupButtonRow(
                selectedGroup = ChoreGroup.MyChores,
                onGroupClicked = {},
                modifier = Modifier
                    .fillMaxWidth(),
            )
        }
    }
}
