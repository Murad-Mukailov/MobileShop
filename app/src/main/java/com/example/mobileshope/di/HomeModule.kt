package com.example.mobileshope.di

import com.example.mobileshope.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

fun homeModule() = module {
    viewModelOf(::HomeViewModel)
}