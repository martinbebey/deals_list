package com.developer.dealslist.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.developer.dealslist.R
import com.developer.dealslist.model.ListingItem
import com.developer.dealslist.model.ViewState

@Composable
fun ListingPageView(
    navigateToDetailScreen: (ListingItem) -> Unit,
    navController: NavController,
    listingViewState: ViewState,
    modifier: Modifier = Modifier
) {

    val scaffoldState = rememberScaffoldState()

    Box{
        when (listingViewState) {
            is ViewState.Loading -> {
                    CircularProgressIndicator(modifier.align(Alignment.Center))
            }

            is ViewState.ItemNotFound -> {
                Text(text = listingViewState.message, color = Color.Red)
            }

            is ViewState.Success -> {

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
                            items(listingViewState.itemList) { productFromList ->
                                ListingPageItem(
                                    item = productFromList,
                                    navigateToDetailScreen = navigateToDetailScreen
                                )
                            }
                        }
                    }
                }

            }
        }
    }
}