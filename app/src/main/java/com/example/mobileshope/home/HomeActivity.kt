package com.example.mobileshope.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DiffUtil
import com.example.mobileshope.databinding.ActivityHomeBinding
import com.example.mobileshope.home.delegate.HomeUIModels
import com.example.mobileshope.home.delegate.horizontalListDelegate
import com.example.mobileshope.home.delegate.titleDelegate
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    private val viewModel by viewModel<HomeViewModel>()
    private lateinit var binding: ActivityHomeBinding

    // создание HashMap
    private val horizontalAdapters = hashMapOf<Long, AsyncListDifferDelegationAdapter<*>>()
    private fun createHorizontalCategoryAdapter() = AsyncListDifferDelegationAdapter(
        object : DiffUtil.ItemCallback<HomeUIModels>() {
            override fun areItemsTheSame(oldItem: HomeUIModels, newItem: HomeUIModels): Boolean {
                return oldItem.identification == newItem.identification
            }

            override fun areContentsTheSame(oldItem: HomeUIModels, newItem: HomeUIModels): Boolean {
                return oldItem == newItem
            }
        },

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
        horizontalListDelegate(
            recyclerFactory = {

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
    }

}