package com.example.mobileshope.home.delegate

import androidx.recyclerview.widget.RecyclerView
import com.example.mobileshope.databinding.ItemHorizontalListBinding
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

data class HorizontalListUIModel<T : HomeUIModels>(
    override val identification: Long,
    val list: List<T>
) : HomeUIModels(identification)

fun horizontalListDelegate(
    recyclerFactory: RecyclerView.(HorizontalListUIModel<*>) -> Unit,
) = adapterDelegateViewBinding<HorizontalListUIModel<*>,
        HomeUIModels, ItemHorizontalListBinding>(
    viewBinding = { layoutInflater, parent ->
        ItemHorizontalListBinding.inflate(layoutInflater, parent, false)
    }
) {
    with(binding) {
        bind {
            recyclerView.recyclerFactory(item)
        }
    }
}
