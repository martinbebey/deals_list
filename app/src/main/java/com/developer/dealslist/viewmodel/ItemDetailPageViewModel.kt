package com.developer.dealslist.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developer.dealslist.model.DetailViewState
import com.developer.dealslist.model.ListingItem
import com.developer.dealslist.model.ViewState
import com.developer.dealslist.services.fetchService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ItemDetailPageViewModel(

): ViewModel() {
    private val _listingViewState: MutableState<DetailViewState> = mutableStateOf(DetailViewState.Loading)
    val listingViewState: State<DetailViewState> = _listingViewState

    fun fetchSingleProduct(dealId: String): DetailViewState {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                //Ktor
//                val fetchedProducts = repository.getProducts()
//                _productsList.emit(fetchedProducts)

                //Retrofit
                val fetchedProduct = fetchService.getSingleItem(dealId)

                _listingViewState.value = DetailViewState.Success(fetchedProduct)
            }
            catch (exception: Exception){
                _listingViewState.value = DetailViewState.ItemNotFound(code = "RED", message = "Error loading products")
                exception.printStackTrace()
            }
        }

        return listingViewState.value
    }
}