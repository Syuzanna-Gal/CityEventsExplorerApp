package com.example.domain.usecase

import com.example.domain.entity.EventDetailsUiEntity
import com.example.domain.repository.EventsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetEventDetailsUseCase @Inject constructor(private val eventRepository: EventsRepository) {

    operator fun invoke(id: Long): Flow<EventDetailsUiEntity> {
        return eventRepository.getEventDetails(id)
    }
}