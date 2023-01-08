package com.example.mobileshope.home.presentation.domain.model

import com.google.gson.annotations.SerializedName

data class Sale(
    @SerializedName("id") val id: Long,
    @SerializedName("is_new") val new: Boolean,
    @SerializedName("title") val name: String,
    @SerializedName("subtitle") val description: String,
    @SerializedName("picture") val image: String,
    @SerializedName("is_buy") val isBuy: Boolean
)
