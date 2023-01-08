package com.example.mobileshope.home.presentation.domain.model

import androidx.annotation.DrawableRes

data class Category(
    val name: String,
    @DrawableRes val imagePositive: Int,
    @DrawableRes val imageNegative: Int
)
