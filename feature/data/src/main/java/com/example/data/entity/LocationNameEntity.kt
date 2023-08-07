package com.example.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class LocationNameEntity(
    @SerialName("slug") val slug: String,
    @SerialName("name") val name: String
)