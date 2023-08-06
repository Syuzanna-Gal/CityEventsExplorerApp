package com.example.domain.usecase

import androidx.paging.PagingData
import com.example.domain.entity.EventItemUiEntity
import com.example.domain.repository.EventsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetEventsUseCase @Inject constructor(private val eventRepository: EventsRepository) {

    operator fun invoke(): Flow<PagingData<EventItemUiEntity>> {
        return eventRepository.fetchEvents().flowOn(Dispatchers.IO)
    }
}