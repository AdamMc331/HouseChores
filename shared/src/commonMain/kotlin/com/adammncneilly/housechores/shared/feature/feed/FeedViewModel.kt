package com.adammncneilly.housechores.shared.feature.feed

import androidx.lifecycle.ViewModel
import dev.zacsweers.metro.AppScope
import dev.zacsweers.metro.ContributesIntoMap
import dev.zacsweers.metro.Inject
import dev.zacsweers.metrox.viewmodel.ViewModelKey
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@Inject
@ViewModelKey
@ContributesIntoMap(AppScope::class)
class FeedViewModel : ViewModel() {
    private val mutableState = MutableStateFlow(FeedUiState())
    val state = mutableState.asStateFlow()

    fun onEvent(
        event: FeedUiEvent,
    ) {
        when (event) {
            FeedUiEvent.AddTaskClicked -> {
                // Coming soon
            }

            is FeedUiEvent.ChoreGroupClicked -> {
                updateChoreGroup(event)
            }
        }
    }

    private fun updateChoreGroup(event: FeedUiEvent.ChoreGroupClicked) {
        mutableState.update { currentState ->
            currentState.copy(
                selectedChoreGroup = event.group,
            )
        }
    }
}
