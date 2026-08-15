package com.adammncneilly.housechores.shared.displaymodels

import com.adammncneilly.housechores.shared.models.TaskStatus

data class TaskDisplayModel(
    val id: String,
    val title: String,
    val status: TaskStatus,
)
