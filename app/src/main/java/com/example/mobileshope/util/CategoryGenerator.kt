package com.example.mobileshope.util

import com.example.mobileshope.R
import com.example.mobileshope.home.presentation.domain.model.Category

object CategoryGenerator {
    fun generateCategory(): List<Category> {
        return listOf(
            Category(
                name = "Phones",
                imagePositive = R.drawable.ic_phone_gray,
                imageNegative = R.drawable.ic_phone_white
            ),
            Category(
                name = "Computer",
                imagePositive = R.drawable.ic_computer_gray,
                imageNegative = R.drawable.ic_computer_white
            ),
            Category(
                name = "Health",
                imagePositive = R.drawable.ic_health_gray,
                imageNegative = R.drawable.ic_health_white
            ),
            Category(
                name = "Books",
                imagePositive = R.drawable.ic_books_gray,
                imageNegative = R.drawable.ic_books_white
            )
        )
    }
}