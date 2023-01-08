package com.example.mobileshope.home.presentation.domain.model

import com.google.gson.annotations.SerializedName
data class Product(
    @SerializedName("id") val id: Long,
    @SerializedName("is_favorites") val isFavorite: Boolean,
    @SerializedName("title") val title: String,
    @SerializedName("price_without_discount") val rawPrice: Double,
    @SerializedName("discount_price") val price: Double,
    @SerializedName("picture") val image: String
)
