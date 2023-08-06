package com.example.cityeventsexplorerapp.ui.events

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.cityeventsexplorerapp.R
import com.example.cityeventsexplorerapp.base.BaseViewModel
import com.example.cityeventsexplorerapp.navigation.Command
import com.example.cityeventsexplorerapp.util.event.InfoEvent
import com.example.domain.usecase.GetEventsUseCase
import com.example.foodorderapp.util.TextSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import javax.inject.Inject

@HiltViewModel
class EventsViewModel @Inject constructor(
    private val getEventsUseCase: GetEventsUseCase
) : BaseViewModel() {

    val eventPagingState = getEventsUseCase()
        .cachedIn(viewModelScope)
        .catch {
            emitInfoEvent(
                InfoEvent.Info(
                    title = TextSource.Resource(R.string.something_went_wrong),
                    message = TextSource.Dynamic(it.message ?: ""),
                    buttonText = TextSource.Resource(R.string.ok)
                )
            )
        }

    fun navigateToDetails(id: Long){
        val dir = EventsFragmentDirections.toEventDetailsFragment(id)
        sendCommand(Command.NavCommand(dir))
    }
}