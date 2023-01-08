package com.example.mobileshope.home.presentation.delegate

import com.example.mobileshope.databinding.ItemSearchBinding
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

data class SearchUIModel(
    val find: String,
) : HomeUIModels(identification = find.hashCode().toLong())

fun searchDelegate() = adapterDelegateViewBinding<SearchUIModel, HomeUIModels, ItemSearchBinding>(
    viewBinding = { layoutInflater, parent ->
        ItemSearchBinding.inflate(layoutInflater, parent, false)
    }
) {

}