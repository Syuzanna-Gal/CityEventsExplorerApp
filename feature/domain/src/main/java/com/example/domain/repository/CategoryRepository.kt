package com.example.domain.repository

import androidx.paging.PagingData
import com.example.domain.entity.EventDetailsUiEntity
import com.example.domain.entity.EventItemUiEntity
import kotlinx.coroutines.flow.Flow

interface EventsRepository {

    fun fetchEvents(): Flow<PagingData<EventItemUiEntity>>

    fun getEventDetails(id: Long): Flow<EventDetailsUiEntity>
}