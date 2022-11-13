package com.example.mobileshope.home.delegate

import com.example.mobileshope.databinding.ItemCategoryBinding
import com.example.mobileshope.model.Category
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

data class CategoryUIModel(
    val chek: Boolean,
    override val data: Category,
) : HomeUIModels(identification = data.name.hashCode().toLong())

fun categoryDelegate() =
    adapterDelegateViewBinding<CategoryUIModel, HomeUIModels, ItemCategoryBinding>(
        viewBinding = { layoutInflater, parent ->
            ItemCategoryBinding.inflate(layoutInflater, parent, false)
        }

    ) {
        with(binding) {
            bind {
                itemCategoryImage.setImageDrawable(getDrawable(item.data.image))
                nameCategoryText.text = item.data.name
                itemCategoryImage.isSelected = item.chek
            }
        }
    }