package com.example.mobileshope.model

import androidx.annotation.DrawableRes

data class Category(
    val name: String,
    @DrawableRes val imagePositive: Int,
    @DrawableRes val imageNegative: Int
)
