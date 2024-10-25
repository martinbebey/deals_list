package com.developer.dealslist.model

data class ListingItem(
    var aisle: String = "",
    var availability: String = "",
    var description: String = "",
    var fulfillment: String = "",
    var id: Int = -1,
    var imageUrl: String = "",
    var regular_price: Price = Price(0, "", ""),
    var sale_price: Price = Price(0, "", ""),
    var title: String = ""
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