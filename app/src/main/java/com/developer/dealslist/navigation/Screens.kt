package com.developer.dealslist.navigation

/**
 * All navigation screen routes are listed here
 **/
sealed class Screen(val route: String) {
    object ItemListingPage: Screen("item_List_screen")

    object itemDetailPage: Screen("item_detail_screen")
}