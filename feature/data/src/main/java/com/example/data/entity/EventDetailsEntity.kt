package com.example.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class EventDetailsEntity(
    @SerialName("id") val id: Long?,
    @SerialName("publication_date") val publicationDate: Long?,
    @SerialName("title") val title: String?,
    @SerialName("place") val place: PlaceEntity?,
    @SerialName("dates") val dates: List<DateEntity>?,
    @SerialName("description") val description: String?,
    @SerialName("location") val location: LocationEntity?,
    @SerialName("categories") val categories: List<String>?,
    @SerialName("price") val price: String?,
    @SerialName("is_free") val isFree: Boolean?,
    @SerialName("images") val images: List<ImageEntity>?,
    @SerialName("favorites_count") val favoritesCount: Int?,
    @SerialName("comments_count") val commentsCount: Int?,
    @SerialName("site_url") val siteUrl: String?,
    @SerialName("tags") val tags: List<String>?,
    @SerialName("disable_comments") val disableComments: Boolean?
)

@Serializable
class PlaceEntity(
    @SerialName("id") val id: Int
)

@Serializable
class DateEntity(
    @SerialName("start") val start: Long,
    @SerialName("end") val end: Long
)

@Serializable
class LocationEntity(
    @SerialName("slug") val slug: String
)

@Serializable
class ImageEntity(
    @SerialName("image") val image: String
)