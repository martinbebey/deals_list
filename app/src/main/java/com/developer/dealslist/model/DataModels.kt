package com.developer.dealslist.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Composition/Attributes for various data objects used in the app
 **/

@Parcelize
data class ListingItem(
    var aisle: String = "",
    var availability: String = "",
    var description: String = "",
    var fulfillment: String = "",
    var id: Int = -1,
    var image_url: String = "",
    var regular_price: Price = Price(0, "", ""),
    var sale_price: Price = Price(0, "", ""),
    var title: String = ""
) : Parcelable

@Parcelize
data class Price(
    var amount_in_cents: Int,
    var currency_symbol: String,
    var display_string: String
) : Parcelable


data class DealsList (
    val products: List<ListingItem>
)

sealed interface ViewState {
    data object Loading: ViewState

    data class ItemNotFound(
        val code: String,
        val message: String
    ): ViewState

    data class Success(
        val itemList: DealsList
    ): ViewState
}

sealed interface DetailViewState {
    data object Loading: DetailViewState

    data class ItemNotFound(
        val code: String,
        val message: String
    ): DetailViewState

    data class Success(
        val item: ListingItem
    ): DetailViewState
}