package com.example.data.api

import com.example.data.entity.EventDetailsEntity
import com.example.data.entity.EventEntity
import com.example.data.entity.LocationNameEntity
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MainApi {

    @GET("v1.2/events/")
    suspend fun fetchEvents(
        @Query("page") page: Int
    ): EventEntity

    @GET("v1.3/events/{id}/")
    suspend fun getEventDetails(
        @Path("id") id: Long
    ): EventDetailsEntity

    @GET("v1.2/locations/")
    suspend fun getLocationNameInRussian(
        @Query("lang") lang: String?
    ): List<LocationNameEntity>


}