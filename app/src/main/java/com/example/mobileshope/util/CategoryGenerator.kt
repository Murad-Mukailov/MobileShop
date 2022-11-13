package com.example.mobileshope.util

import com.example.mobileshope.R
import com.example.mobileshope.model.Category

object CategoryGenerator {
    fun generateCategory(): List<Category> {
        return listOf(
            Category(
                name = "Phones",
                image = R.drawable.ic_phone
            ),
            Category(
                name = "Computer",
                image = R.drawable.ic_computer
            ),
            Category(
                name = "Health",
                image = R.drawable.ic_health
            ),
            Category(
                name = "Books",
                image = R.drawable.ic_books
            ), Category(
                name = "Phones",
                image = R.drawable.ic_computer
            ), Category(
                name = "Health",
                image = R.drawable.ic_health
            ), Category(
                name = "Computer",
                image = R.drawable.ic_computer
            ), Category(
                name = "Phones",
                image = R.drawable.ic_phone
            ), Category(
                name = "Health",
                image = R.drawable.ic_health
            ), Category(
                name = "Computer",
                image = R.drawable.ic_computer
            ), Category(
                name = "Phones",
                image = R.drawable.ic_books
            )
        )
    }
}