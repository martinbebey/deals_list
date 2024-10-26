package com.developer.dealslist.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.developer.dealslist.model.ListingItem
import com.developer.dealslist.view.ItemDetailPageView
import com.developer.dealslist.view.ListingPageView
import com.developer.dealslist.viewmodel.ItemDetailPageViewModel
import com.developer.dealslist.viewmodel.ListingPageViewModel

@Composable
fun DealsAppNavigation(
){

    val navController = rememberNavController()
    val listingPageViewModel: ListingPageViewModel = viewModel()
    val itemDetailPageViewModel: ItemDetailPageViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.ItemListingPage.route,
    ){
        composable(route = Screen.ItemListingPage.route){
            ListingPageView(
                navController = navController,
                listingViewState = listingPageViewModel.listingViewState.value,
                navigateToDetailScreen = {
                    navController.currentBackStackEntry?.savedStateHandle?.set("product", it)
                    navController.navigate(Screen.itemDetailPage.route)
                }
            )
        }

        composable(route = Screen.itemDetailPage.route){
            val product = navController.previousBackStackEntry?.savedStateHandle?.get<ListingItem>("product")?: ListingItem()
            ItemDetailPageView(item = product, navController = navController, productDetailViewModel = itemDetailPageViewModel)
        }
    }
}