package com.adammncneilly.housechores.shared.feature.feed.components.taskcard

import com.adammncneilly.housechores.shared.displaymodels.TaskDisplayModel
import com.adammncneilly.housechores.shared.models.TaskStatus

data class TaskCardData(
    val title: String,
    val actions: List<Action>,
) {
    constructor(task: TaskDisplayModel) : this(
        title = task.title,
        actions = when (task.status) {
        },
    )

    data class Action(
        val label: String,
        val onClick: () -> Unit,
    )
}

private fun actionsForStatus(status: TaskStatus): List<TaskCardData.Action> {
}
