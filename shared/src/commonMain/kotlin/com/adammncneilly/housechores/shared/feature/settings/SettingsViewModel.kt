package com.adammncneilly.housechores.shared.feature.settings

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SettingsViewModel : ViewModel() {
    private val mutableState = MutableStateFlow(SettingsUiState())
    val state = mutableState.asStateFlow()

    fun onEvent(
        event: SettingsUiEvent,
    ) {
        // Coming soon
    }
}
