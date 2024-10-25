package com.developer.dealslist.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.developer.dealslist.R
import com.developer.dealslist.model.ListingItem

@Composable
fun ItemDetailPageView(
    item: ListingItem
){
    Scaffold(
        topBar = {
            TopBarView(title = stringResource(id = R.string.listing_page_title))
        },
        scaffoldState = scaffoldState,
    ) {
        Column {
            LazyColumn(modifier = Modifier
                .padding(it)
            ) {
                items(listingViewState.itemList.products) { productFromList ->
                    ListingPageItem(
                        item = productFromList,
                        navigateToDetailScreen = navigateToDetailScreen
                    )
                }
            }
        }
    }
}