package com.adammncneilly.housechores.shared.feature.archive

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
class ArchiveViewModel : ViewModel() {
    private val mutableState = MutableStateFlow(ArchiveUiState())
    val state = mutableState.asStateFlow()

    fun onEvent(
        event: ArchiveUiEvent,
    ) {
        // Coming soon
    }
}
