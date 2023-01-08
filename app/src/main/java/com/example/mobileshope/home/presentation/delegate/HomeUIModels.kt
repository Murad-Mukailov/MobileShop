package com.example.mobileshope.home.presentation.delegate

sealed class HomeUIModels(
    open val identification: Long,
    open val data: Any? = null
)