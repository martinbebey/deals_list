package com.developer.dealslist.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.developer.dealslist.model.ViewState

class ListingPageViewModel(

): ViewModel() {
    private val _listingViewState: MutableState<ViewState> = mutableStateOf(ViewState.Loading)
    val listingViewState: State<ViewState> = _listingViewState
}