package com.adammncneilly.housechores.shared.models

import kotlinx.datetime.LocalDate

data class Task(
    val id: String,
    val title: String,
    val dueDate: LocalDate,
)
