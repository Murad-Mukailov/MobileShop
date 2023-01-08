package com.example.mobileshope.home.presentation.delegate

import com.example.mobileshope.databinding.ItemTitleBinding
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

data class TitleUIModel(
    val text: String,
    val action: String
) : HomeUIModels(identification = text.hashCode().toLong())

fun titleDelegate() = adapterDelegateViewBinding<TitleUIModel, HomeUIModels, ItemTitleBinding>(
    viewBinding = { layoutInflater, parent ->
        ItemTitleBinding.inflate(layoutInflater, parent, false)
    }
) {
    with(binding) {
        bind {
            itemTitleText.text = item.text
            viewTitleText.text = item.action
        }
    }
}