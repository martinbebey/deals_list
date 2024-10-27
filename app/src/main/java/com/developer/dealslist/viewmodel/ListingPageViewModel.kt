package com.developer.dealslist.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developer.dealslist.R
import com.developer.dealslist.model.ViewState
import com.developer.dealslist.services.fetchService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * This is the viewmodel for the lsit page.
 * It fetches the list of deals using the API service
 **/
class ListingPageViewModel: ViewModel() {
    private val _listingViewState: MutableState<ViewState> = mutableStateOf(ViewState.Loading)
    val listingViewState: State<ViewState> = _listingViewState

    init {
        fetchProducts()
    }

    /**
     * Fetches the list of deals using the API service in a non-blocking IO coroutine
     */
    private fun fetchProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                //Retrofit
                val fetchedProducts = fetchService.getDealsListItems()

                _listingViewState.value = ViewState.Success(fetchedProducts)
            }
            catch (exception: Exception){
                _listingViewState.value = ViewState.ItemNotFound(
                    code = R.string.item_not_found_code.toString(),
                    message = R.string.item_not_found_message.toString()
                )
                exception.printStackTrace()
            }
        }
    }
}