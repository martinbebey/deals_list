package com.developer.dealslist.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developer.dealslist.R
import com.developer.dealslist.model.DetailViewState
import com.developer.dealslist.services.fetchService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * This is the viewmodel for the details page.
 * It fetches the description of the selected product using the API service
 **/
class ItemDetailPageViewModel : ViewModel() {
    private val _listingViewState: MutableState<DetailViewState> = mutableStateOf(DetailViewState.Loading)
    val listingViewState: State<DetailViewState> = _listingViewState

    /**
     * Fetches a single product detail using the API service in a non-blocking IO coroutine
     */
    fun fetchSingleProduct(dealId: String): DetailViewState {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                //Retrofit
                val fetchedProduct = fetchService.getSingleItem(dealId)

                _listingViewState.value = DetailViewState.Success(fetchedProduct)
            }
            catch (exception: Exception){
                _listingViewState.value = DetailViewState.ItemNotFound(
                    code = R.string.item_not_found_code.toString(),
                    message = R.string.item_not_found_message.toString()
                )
                exception.printStackTrace()
            }
        }

        return listingViewState.value
    }
}