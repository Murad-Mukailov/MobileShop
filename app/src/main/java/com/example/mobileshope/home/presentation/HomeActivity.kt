package com.example.mobileshope.home.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.mobileshope.databinding.ActivityHomeBinding
import com.example.mobileshope.home.presentation.delegate.*
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {
    private val viewModel by viewModel<HomeViewModel>()
    private lateinit var binding: ActivityHomeBinding

    private val horizontalAdapters = hashMapOf<Long, AsyncListDifferDelegationAdapter<*>>()
    private val productAdapters = hashMapOf<Long, AsyncListDifferDelegationAdapter<*>>()

    private fun createHorizontalCategoryAdapter() = AsyncListDifferDelegationAdapter(
        object : DiffUtil.ItemCallback<HomeUIModels>() {
            override fun areItemsTheSame(oldItem: HomeUIModels, newItem: HomeUIModels): Boolean {
                return oldItem.identification == newItem.identification
            }

            override fun areContentsTheSame(oldItem: HomeUIModels, newItem: HomeUIModels): Boolean {
                return oldItem == newItem
            }
        },
        categoryDelegate(
            onItemClickListener = {
                viewModel.onCategoryClicked(it)
            }
        )
    )

    private fun createHorizontalSaleAdapter() = AsyncListDifferDelegationAdapter(
        object : DiffUtil.ItemCallback<HomeUIModels>() {
            override fun areItemsTheSame(oldItem: HomeUIModels, newItem: HomeUIModels): Boolean {
                return oldItem.identification == newItem.identification
            }

            override fun areContentsTheSame(oldItem: HomeUIModels, newItem: HomeUIModels): Boolean {
                return oldItem == newItem
            }
        },
        salesDelegate()
    )

    private fun createProductAdapter() = AsyncListDifferDelegationAdapter(
        object : DiffUtil.ItemCallback<HomeUIModels>() {
            override fun areItemsTheSame(oldItem: HomeUIModels, newItem: HomeUIModels): Boolean {
                return oldItem.identification == newItem.identification
            }

            override fun areContentsTheSame(oldItem: HomeUIModels, newItem: HomeUIModels): Boolean {
                return oldItem == newItem
            }

        }, productDelegate()
    )

    private val homeAdapter = AsyncListDifferDelegationAdapter(
        object : DiffUtil.ItemCallback<HomeUIModels>() {
            override fun areItemsTheSame(oldItem: HomeUIModels, newItem: HomeUIModels): Boolean {
                return oldItem.identification == newItem.identification
            }

            override fun areContentsTheSame(oldItem: HomeUIModels, newItem: HomeUIModels): Boolean {
                return oldItem == newItem
            }
        },
        titleDelegate(),
        searchDelegate(),
        horizontalListDelegate(
            recyclerFactory = { horizontalListUIModel ->
                val key = horizontalListUIModel.identification
                val listUiModels = horizontalListUIModel.list
                val isCategory = listUiModels.first() is CategoryUIModel
                val isSales = listUiModels.first() is SaleUIModel
                if (isCategory) {
                    val adapter = horizontalAdapters.getOrPut(
                        key, ::createHorizontalCategoryAdapter
                    ).also { it.items = listUiModels }
                    this.adapter = adapter
                }
                if (isSales) {
                    val adapter = horizontalAdapters.getOrPut(
                        key, ::createHorizontalSaleAdapter
                    ).also { it.items = listUiModels }
                    this.adapter = adapter
                    PagerSnapHelper().attachToRecyclerView(this)
                }
            }
        ),
        productListDelegate(
            recyclerFactory = { productListUIModel ->
                layoutManager = GridLayoutManager(context, 2)
                val key = productListUIModel.identification
                val listUIModels = productListUIModel.list
                val isProduct = listUIModels.first() is ProductUIModel
                if (isProduct) {
                    val adapter = productAdapters.getOrPut(
                        key, ::createProductAdapter
                    ).also { it.items = listUIModels }
                    this.adapter = adapter

                }
            }
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        with(binding) {
            contentHomeList.adapter = homeAdapter
        }

        with(viewModel) {
            content.observe(this@HomeActivity) {
                homeAdapter.items = it
            }
        }
        binding.filterHomeImage.setOnClickListener { filterDialog() }
    }

    private fun filterDialog() {
        val dialog = FilterDialogFragment()
        dialog.show(supportFragmentManager, null)
    }
}