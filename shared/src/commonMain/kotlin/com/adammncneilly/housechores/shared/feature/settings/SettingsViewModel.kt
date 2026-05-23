package com.adammncneilly.housechores.shared.feature.settings

import androidx.lifecycle.ViewModel
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesIntoMap
import dev.zacsweers.metro.Inject
import dev.zacsweers.metrox.viewmodel.ViewModelKey
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

@Inject
@ViewModelKey
@ContributesIntoMap(AppScope::class)
class SettingsViewModel : ViewModel() {
    private val mutableState = MutableStateFlow(SettingsUiState())
    val state = mutableState.asStateFlow()

    @Suppress("UnusedParameter")
    fun onEvent(
        event: SettingsUiEvent,
    ) {
        // Coming soon
    }
}
