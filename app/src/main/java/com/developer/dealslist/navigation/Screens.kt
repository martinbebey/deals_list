package com.developer.dealslist.navigation

sealed class Screen(val route: String) {
    object ItemListingPage: Screen("item_List_screen")

    object itemDetailPage: Screen("item_detail_screen")
}