package com.example.mobileshope.home.delegate

import com.example.mobileshope.databinding.ItemCategoryBinding
import com.example.mobileshope.model.Category
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

data class CategoryUIModel(
    val chek: Boolean,
    override val data: Category,
) : HomeUIModels(identification = data.name.hashCode().toLong())

fun categoryDelegate(
    onItemClickListener: (CategoryUIModel) -> Any,
) = adapterDelegateViewBinding<CategoryUIModel, HomeUIModels, ItemCategoryBinding>(
    viewBinding = { layoutInflater, parent ->
        ItemCategoryBinding.inflate(layoutInflater, parent, false)
    }
) {
    with(binding) {
        itemCategoryImage.setOnClickListener { onItemClickListener.invoke(item) }

        bind {
            val categoryDrawable =
                if (item.chek) item.data.imageNegative
                else item.data.imagePositive
            itemCategoryImage.setImageDrawable(getDrawable(categoryDrawable))
            nameCategoryText.text = item.data.name
            itemCategoryImage.isSelected = item.chek

        }

    }

}