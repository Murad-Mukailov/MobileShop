package com.example.mobileshope.model

import androidx.annotation.DrawableRes

data class Category(
    val name: String,
    val chek: Boolean,
    @DrawableRes val image: Int
)
