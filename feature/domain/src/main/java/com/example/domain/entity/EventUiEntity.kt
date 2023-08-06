package com.example.domain.entity

class EventUiEntity(
    val count: Int,
    val next: String?,
    val previous: String?,
    val items: List<EventItemUiEntity>
)

class EventItemUiEntity(
    val id: Long,
    val image: String,
    val name: String
)