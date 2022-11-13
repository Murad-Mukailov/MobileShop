package com.example.mobileshope.home.delegate

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
    with(binding) {
        bind {
            bindSearchText.selectAll()
        }
    }
}