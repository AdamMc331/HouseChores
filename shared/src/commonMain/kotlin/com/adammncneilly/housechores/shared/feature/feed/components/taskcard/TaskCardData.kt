package com.adammncneilly.housechores.shared.feature.feed.components.taskcard

data class TaskCardData(
    val title: String,
    val actions: List<Action>,
) {
    data class Action(
        val label: String,
        val onClick: () -> Unit,
    )
}
