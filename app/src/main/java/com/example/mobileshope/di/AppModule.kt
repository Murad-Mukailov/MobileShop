package com.example.mobileshope.di

import com.example.mobileshope.view.model.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.scope.get
import org.koin.dsl.module
import retrofit2.Retrofit

fun homeModule() = module {
    viewModelOf(::HomeViewModel)
    single {
        get<Retrofit>(Retrofit::class.java)
    }
}