package com.example.data.repository.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.data.api.MainApi
import com.example.data.mapper.MapperEventEntityToUiEntity
import com.example.domain.entity.EventItemUiEntity

class EventsPagingSource(
    private val mainApi: MainApi,
) :
    PagingSource<Int, EventItemUiEntity>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, EventItemUiEntity> {
        val startFrom = params.key ?: 1
        return try {
            val response = mainApi.fetchEvents(
                page = startFrom
            )

            val result = MapperEventEntityToUiEntity().map(response)
            LoadResult.Page(
                data = result.items,
                prevKey = null, // Only paging forward.
                nextKey = if (result.next != null) startFrom + 1 else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, EventItemUiEntity>): Int? = null
}