package com.adammncneilly.housechores.shared.feature.feed.components.taskcard

import com.adammncneilly.housechores.shared.displaymodels.TaskDisplayModel
import com.adammncneilly.housechores.shared.models.TaskStatus

data class TaskCardData(
    val title: String,
    val actions: List<Action>,
) {
    data class Action(
        val label: String,
        val onClick: () -> Unit,
    )
}
