package com.example.mobileshope.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobileshope.api.MainAPI
import com.example.mobileshope.home.delegate.*
import com.example.mobileshope.util.CategoryGenerator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(private val mainAPI: MainAPI) : ViewModel() {

    private var categoriesUI: List<CategoryUIModel>? = null

    private val _content = MutableLiveData<List<HomeUIModels>>()
    val content: LiveData<List<HomeUIModels>> get() = _content

    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val home = mainAPI.getHome()

                val categories = CategoryGenerator.generateCategory()

                categoriesUI = categories.mapIndexed { index, category ->
                    CategoryUIModel(index == 0, category)
                }

                val salesUI = home.sales.map { sale -> SaleUIModel(sale) }
                val productUI = home.products.map { product -> ProductUIModel(product) }

                withContext(Dispatchers.Main) {
                    _content.value = listOf(
                        TitleUIModel("Category", "Show all"),
                        HorizontalListUIModel(1, categoriesUI!!),
                        SearchUIModel(find = String()),
                        TitleUIModel("Hot sales", "See more"),
                        HorizontalListUIModel(2, salesUI),
                        TitleUIModel("Best Seller", "See more"),
                        ProductListUIModel(2, productUI)

                    )
                }
            } catch (e: Exception) {

            }
        }
    }

    fun onCategoryClicked(categoryUI: CategoryUIModel) {
        val categories = categoriesUI!!.map {
            it.copy(chek = categoryUI.identification == it.identification)
        }
        val content = content.value!!.toMutableList()
        content.removeAt(1)
        content.add(1, HorizontalListUIModel(1, categories))
        _content.value = content

        if (categoryUI.equals(check(true))) {

        }

    }
}