package com.developer.dealslist.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developer.dealslist.model.ListingItem
import com.developer.dealslist.model.ViewState
import com.developer.dealslist.services.fetchService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ListingPageViewModel(
//    private val repository: ProductRepository = ProductRepository(apiClient = KtorApiClient())
): ViewModel() {
    private val _productsList = MutableStateFlow<List<ListingItem>>(emptyList())
    private val _listingViewState: MutableState<ViewState> = mutableStateOf(ViewState.Loading)
    val listingViewState: State<ViewState> = _listingViewState
    val productList: StateFlow<List<ListingItem>> = _productsList

    init {
        fetchProducts()
    }

    private fun fetchProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                //Ktor
//                val fetchedProducts = repository.getProducts()
//                _productsList.emit(fetchedProducts)

                //Retrofit
                val fetchedProducts = fetchService.getDealsListItems()
                println("shit" + fetchedProducts.products[1])

                _listingViewState.value = ViewState.Success(fetchedProducts)
            }
            catch (exception: Exception){
                _listingViewState.value = ViewState.ItemNotFound(code = "RED", message = "Error loading products")
                exception.printStackTrace()
            }
        }
    }
}