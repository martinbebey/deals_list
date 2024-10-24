package com.developer.dealslist.model

data class ListingItem(
    var aisle: String,
    var availability: String,
    var description: String,
    var fulfillment: String,
    var id: Int,
    var imageUrl: String,
    var regular_price: Price,
    var sale_price: Price,
    var title: String
)

data class Price(
    var amountInCents: Int,
    var currencySymbol: String,
    var displayingString: String
)
sealed interface ViewState {
    data object Loading: ViewState

    data class ItemNotFound(
        val code: String,
        val message: String
    ): ViewState

    data class Success(
        val itemList: List<ListingItem>
    ): ViewState
}