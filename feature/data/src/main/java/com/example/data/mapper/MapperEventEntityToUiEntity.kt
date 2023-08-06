package com.example.data.mapper

import com.example.data.entity.EventEntity
import com.example.data.entity.EventItemEntity
import com.example.domain.entity.EventItemUiEntity
import com.example.domain.entity.EventUiEntity

class MapperEventEntityToUiEntity :
    Mapper<EventEntity, EventUiEntity> {
    override fun map(from: EventEntity): EventUiEntity {
        return EventUiEntity(
            count = from.count ?: 0,
            next = from.next,
            previous = from.previous,
            items = from.items.map { MapperEventItemEntityToUiEntity().map(it) }
        )
    }

    private class MapperEventItemEntityToUiEntity : Mapper<EventItemEntity, EventItemUiEntity> {
        override fun map(from: EventItemEntity): EventItemUiEntity {
            return EventItemUiEntity(
                id = from.id,
                image = from.image ?: "https://wallpaperaccess.com/full/2929632.jpg",
                name = from.title
            )
        }
    }
}