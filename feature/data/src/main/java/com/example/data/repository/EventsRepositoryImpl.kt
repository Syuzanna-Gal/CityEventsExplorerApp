package com.example.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.data.api.MainApi
import com.example.data.mapper.MapperEventDetailEntityToUiEntity
import com.example.data.repository.paging_source.EventsPagingSource
import com.example.domain.entity.EventDetailsUiEntity
import com.example.domain.entity.EventItemUiEntity
import com.example.domain.repository.EventsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EventsRepositoryImpl @Inject constructor(private val mainApi: MainApi) :
    EventsRepository {

    override fun fetchEvents(): Flow<PagingData<EventItemUiEntity>> =
        Pager(
            config = PagingConfig(
                pageSize = 12,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                EventsPagingSource(mainApi)
            }
        ).flow

    override fun getEventDetails(id: Long): Flow<EventDetailsUiEntity> = flow {
        val details = mainApi.getEventDetails(id)
        emit(MapperEventDetailEntityToUiEntity().map(details))
    }

}