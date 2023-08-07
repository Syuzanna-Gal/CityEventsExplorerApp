package com.example.data.mapper

import com.example.data.entity.EventDetailsEntity
import com.example.domain.entity.DateUiEntity
import com.example.domain.entity.EventDetailsUiEntity

class MapperEventDetailEntityToUiEntity(val locName: String) :
    Mapper<EventDetailsEntity, EventDetailsUiEntity> {
    override fun map(from: EventDetailsEntity): EventDetailsUiEntity {
        return EventDetailsUiEntity(
            id = from.id ?: 0L,
            publicationDate = "",
            title = from.title ?: "",
            place = from.place?.id ?: 0,
            dates = from.dates?.map {
                DateUiEntity(
                    start = it.start.toString(),
                    end = it.end.toString()
                )
            } ?: emptyList(),
            description = from.description ?: "",
            location = locName,
            categories = from.categories ?: emptyList(),
            price = from.price ?: "",
            isFree = from.isFree ?: false,
            images = from.images?.map { it.image } ?: emptyList(),
            favoritesCount = from.favoritesCount ?: 0,
            commentsCount = from.commentsCount ?: 0,
            siteUrl = from.siteUrl ?: "",
            tags = from.tags ?: emptyList(),
            disableComments = from.disableComments ?: false
        )
    }
}
