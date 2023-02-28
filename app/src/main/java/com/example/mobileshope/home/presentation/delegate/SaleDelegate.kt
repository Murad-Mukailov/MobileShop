package com.example.mobileshope.home.presentation.delegate

import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.example.mobileshope.databinding.ItemSaleBinding
import com.example.mobileshope.home.presentation.data.api.Sale
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

data class SaleUIModel(
    override val data: Sale,
) : HomeUIModels(identification = data.id)

fun salesDelegate() = adapterDelegateViewBinding<SaleUIModel, HomeUIModels, ItemSaleBinding>(
    viewBinding = { layoutInflater, parent ->
        ItemSaleBinding.inflate(layoutInflater, parent, false)
    }

) {
    with(binding) {
        bind {
            Glide.with(previewHorizontalImage)
                .load(item.data.image)
                .into(previewHorizontalImage)
            newHorizontalImage.isVisible = item.data.new
            nameHorizontalText.text = item.data.name
            descriptionHorizontalText.text = item.data.description
        }
    }
}