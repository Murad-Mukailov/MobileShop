package com.example.mobileshope.api

import com.example.mobileshope.model.HomeResponse
import retrofit2.http.GET

interface MainAPI {
    @GET("654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getHome(): HomeResponse
}