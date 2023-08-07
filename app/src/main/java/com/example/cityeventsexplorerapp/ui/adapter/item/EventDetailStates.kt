package com.example.cityeventsexplorerapp.ui.adapter.item

import java.util.UUID

sealed class EventDetailStates(val identifier: Any) {

    data class Slider(val imageList: List<String>, val title: String) :
        EventDetailStates(UUID.randomUUID().toString())

    data class Info(val text: String, val image: Int) :
        EventDetailStates(UUID.randomUUID().toString())

    data class Description(val text: String) :
        EventDetailStates(UUID.randomUUID().toString())

    data class ChipGroup(val titles: List<String>, val title: String) :
        EventDetailStates(UUID.randomUUID().toString())
}