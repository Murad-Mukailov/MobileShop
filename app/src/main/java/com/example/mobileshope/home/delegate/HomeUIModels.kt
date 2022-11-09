package com.example.mobileshope.home.delegate

sealed class HomeUIModels(
    open val identification: Long,
    open val data: Any? = null
)