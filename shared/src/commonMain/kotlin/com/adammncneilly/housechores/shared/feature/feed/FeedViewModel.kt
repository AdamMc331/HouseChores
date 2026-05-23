package com.adammncneilly.housechores.shared.feature.feed

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class FeedViewModel : ViewModel() {
    private val mutableState = MutableStateFlow(FeedUiState())
    val state = mutableState.asStateFlow()

    fun onEvent(
        event: FeedUiEvent,
    ) {
        // Coming soon
    }
}
