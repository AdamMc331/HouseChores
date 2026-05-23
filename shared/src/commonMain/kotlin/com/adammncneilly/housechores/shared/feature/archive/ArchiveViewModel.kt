package com.adammncneilly.housechores.shared.feature.archive

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ArchiveViewModel : ViewModel() {
    private val mutableState = MutableStateFlow(ArchiveUiState())
    val state = mutableState.asStateFlow()

    fun onEvent(
        event: ArchiveUiEvent,
    ) {
        // Coming soon
    }
}
