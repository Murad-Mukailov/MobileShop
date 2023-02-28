package com.example.mobileshope.home.presentation.data.api.api

import com.example.mobileshope.home.presentation.data.api.HomeResponse
import retrofit2.http.GET

interface MainAPI {
    @GET("654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getHome(): HomeResponse
}