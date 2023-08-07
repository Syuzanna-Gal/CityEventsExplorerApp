package com.example.cityeventsexplorerapp.ui.event_details

import androidx.lifecycle.viewModelScope
import com.example.cityeventsexplorerapp.R
import com.example.cityeventsexplorerapp.base.BaseViewModel
import com.example.cityeventsexplorerapp.ui.adapter.item.EventDetailStates
import com.example.cityeventsexplorerapp.util.type_alias.RDrawable
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
                EventDetailStates.Slider(imageList = it.images, title = it.title),
                EventDetailStates.Description(it.description),
                EventDetailStates.Info(text = it.location, image = R.drawable.ic_location),
                EventDetailStates.Info(text = it.siteUrl, image =  R.drawable.ic_help_circle),
                EventDetailStates.Info(text = it.favoritesCount.toString(), image = R.drawable.ic_heart),
                EventDetailStates.ChipGroup(titles = it.categories, title = "Categories"),
                EventDetailStates.ChipGroup(titles = it.tags, title = "Tags"),
            )
            _eventDetails.value = list
        }.catch {
            val a = it.message
        }.launchIn(viewModelScope)
    }
}