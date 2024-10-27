package com.developer.dealslist.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.developer.dealslist.R
import com.developer.dealslist.model.ListingItem
import com.developer.dealslist.model.ViewState

/**
 * This controls what is displayed on the list screen.
 * A loading indicator is shown while the data is being fetched.
 * An error is shown to the user if the fetching operation fails.
 * Otherwise, if all goes well, then the data is shown
 *
 * @param modifier the composable modifier
 * @param listingViewState the state of the fetching operation
 * @param navigateToDetailScreen the screen transition operation when an item is selected from the list
 **/
@Composable
fun ListingPageView(
    navigateToDetailScreen: (ListingItem) -> Unit,
    listingViewState: ViewState,
    modifier: Modifier = Modifier
) {

    val scaffoldState = rememberScaffoldState()

    Box{
        when (listingViewState) {
            ViewState.Loading -> {
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
    }
}