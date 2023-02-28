package com.example.mobileshope.di

import com.example.mobileshope.home.presentation.data.api.api.MainAPI
import okhttp3.OkHttpClient
import org.koin.core.scope.get
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun networkModule() = module {

    single { OkHttpClient.Builder().build() }

    single { GsonConverterFactory.create() }

    single {
        Retrofit.Builder()
            .baseUrl("https://run.mocky.io/v3/")
            .addConverterFactory(get(GsonConverterFactory::class.java))
            .client(get())
            .build()
    }

    single { get<Retrofit>(Retrofit::class.java).create(MainAPI::class.java) }
}
