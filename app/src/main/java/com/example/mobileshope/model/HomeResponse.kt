package com.example.mobileshope.model

import com.google.gson.annotations.SerializedName

data class HomeResponse(
    @SerializedName("home_store") val homeStoreProducts: List<Product>,
    @SerializedName("best_seller") val bestSellerProducts: List<Product>
)
