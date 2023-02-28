package com.example.mobileshope.home.presentation.delegate

import android.graphics.Paint
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.example.mobileshope.databinding.ItemProductBinding
import com.example.mobileshope.home.presentation.data.api.Product
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

data class ProductUIModel(override val data: Product) :
    HomeUIModels(identification = data.id)

fun productDelegate() =
    adapterDelegateViewBinding<ProductUIModel, HomeUIModels, ItemProductBinding>(
        viewBinding = { layoutInflater, parent ->
            ItemProductBinding.inflate(layoutInflater, parent, false)
        }
    ) {
        with(binding) {
            bind {
                Glide.with(favoriteProductImage)
                    .load(item.data.image)
                    .into(favoriteProductImage)
                nameProductText.text = item.data.title
                favoriteProductIcon.isVisible = item.data.isFavorite
                discountPriceText.text = item.data.rawPrice.toString()
                discountPriceText.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                priceProductText.text = item.data.price.toString()


            }
        }
    }