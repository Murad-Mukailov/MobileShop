package com.example.mobileshope.util

import com.example.mobileshope.R
import com.example.mobileshope.model.Category

object CategoryGenerator {
    fun generateCategory(): List<Category> {
        return listOf(
            Category(
                name = "Phones",
                chek = true,
                image = R.drawable.ic_phone
            ),
            Category(
                name = "Computer",
                chek = false,
                image = R.drawable.ic_computer
            ),
            Category(
                name = "Phones",
                chek = false,
                image = R.drawable.ic_health
            ),
            Category(
                name = "Phones",
                chek = false,
                image = R.drawable.ic_books
            )
        )
    }
}