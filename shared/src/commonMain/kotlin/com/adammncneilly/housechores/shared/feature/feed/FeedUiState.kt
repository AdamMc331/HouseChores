package com.adammncneilly.housechores.shared.feature.feed

import com.adammncneilly.housechores.shared.models.Task

data class FeedUiState(
    val selectedChoreGroup: ChoreGroup = ChoreGroup.MyChores,
    val upcomingTaskGroups: Map<String, List<Task>> = emptyMap(),
)
