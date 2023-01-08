package com.example.mobileshope.home.presentation.delegate

import androidx.recyclerview.widget.RecyclerView
import com.example.mobileshope.databinding.ItemProductListBinding
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

data class ProductListUIModel<T : HomeUIModels>(

    override val identification: Long,
    val list: List<T>
) : HomeUIModels(identification)

fun productListDelegate(
    recyclerFactory: RecyclerView.(ProductListUIModel<*>) -> Unit,
) = adapterDelegateViewBinding<ProductListUIModel<*>, HomeUIModels, ItemProductListBinding>(
    viewBinding = { layoutInflater, parent ->
        ItemProductListBinding.inflate(layoutInflater, parent, false)
    }
) {
    with(binding) {
        bind {
            recyclerViewProduct.recyclerFactory(item)

        }
    }
}