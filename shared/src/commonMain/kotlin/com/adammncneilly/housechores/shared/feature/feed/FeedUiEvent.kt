package com.adammncneilly.housechores.shared.feature.feed

sealed interface FeedUiEvent {
    data object AddTaskClicked : FeedUiEvent
}
