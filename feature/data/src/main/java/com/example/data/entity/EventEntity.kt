package com.example.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class EventEntity(
    @SerialName("count") val count: Int?,
    @SerialName("next") val next: String?,
    @SerialName("previous") val previous: String?,
    @SerialName("results") val items: List<EventItemEntity>,
)

@Serializable
class EventItemEntity(
    @SerialName("id") val id: Long,
    @SerialName("title") val title: String,
    @SerialName("slug") val slug: String,
    @SerialName("image") val image: String?,
)