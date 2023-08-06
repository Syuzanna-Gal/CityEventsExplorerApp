package com.example.cityeventsexplorerapp.ui.event_details

import androidx.lifecycle.viewModelScope
import com.example.cityeventsexplorerapp.base.BaseViewModel
import com.example.cityeventsexplorerapp.ui.adapter.item.EventDetailStates
import com.example.domain.usecase.GetEventDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class EventDetailsViewModel @Inject constructor(
    private val getEventDetailsUseCase: GetEventDetailsUseCase
) : BaseViewModel() {

    private val _eventDetails = MutableStateFlow<List<EventDetailStates>>(emptyList())
    val eventDetails = _eventDetails.asStateFlow()

    fun getEventDetails(id: Long) {
        getEventDetailsUseCase(id).onEach {
            val list = listOf(
                EventDetailStates.Slider(it.images),
                EventDetailStates.Description(it.description),
                EventDetailStates.Info(text = it.publicationDate, image = 0),
                EventDetailStates.Info(text = it.place.toString(), image = 0),
                EventDetailStates.Info(text = it.location, image = 0),
                EventDetailStates.Info(text = it.price, image = 0),
                EventDetailStates.Info(text = it.siteUrl, image = 0),
                EventDetailStates.Info(text = it.favoritesCount.toString(), image = 0),
                EventDetailStates.Info(text = it.isFree.toString(), image = 0),
                EventDetailStates.ChipGroup(titles = it.categories),
                EventDetailStates.ChipGroup(titles = it.tags),
            )
            _eventDetails.value = list
        }.catch {
            val a = it.message
        }.launchIn(viewModelScope)
    }
}