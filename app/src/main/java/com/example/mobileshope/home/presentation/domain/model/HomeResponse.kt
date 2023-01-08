package com.example.mobileshope.home.presentation.domain.model

import com.google.gson.annotations.SerializedName

data class HomeResponse(
    @SerializedName("home_store") val sales: List<Sale>,
    @SerializedName("best_seller") val products: List<Product>
)
