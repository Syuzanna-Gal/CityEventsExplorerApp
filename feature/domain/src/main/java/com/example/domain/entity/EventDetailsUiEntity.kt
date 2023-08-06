package com.example.domain.entity

class EventDetailsUiEntity(
    val id: Long,
    val publicationDate: String,
    val title: String,
    val place: Int,
    val dates: List<DateUiEntity>,
    val description: String,
    val location: String,
    val categories: List<String>,
    val price: String,
    val isFree: Boolean,
    val images: List<String>,
    val favoritesCount: Int,
    val commentsCount: Int,
    val siteUrl: String,
    val tags: List<String>,
    val disableComments: Boolean
)

class DateUiEntity(
    val start: String,
    val end: String
)