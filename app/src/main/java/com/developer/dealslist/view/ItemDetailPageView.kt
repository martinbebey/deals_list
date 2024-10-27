package com.developer.dealslist.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.developer.dealslist.R
import com.developer.dealslist.model.DetailViewState
import com.developer.dealslist.model.ListingItem
import com.developer.dealslist.model.ViewState
import com.developer.dealslist.viewmodel.ItemDetailPageViewModel

@Composable
fun ItemDetailPageView(
    item: ListingItem,
    navController: NavController,
    productDetailViewModel: ItemDetailPageViewModel,
    modifier: Modifier = Modifier
){

    val scaffoldState = rememberScaffoldState()
    val detailViewState = productDetailViewModel.listingViewState.value

    Scaffold(
        topBar = {
            TopBarView(title = stringResource(id = R.string.detail_page_title)){
                navController.popBackStack()
            }
        },
        scaffoldState = scaffoldState,
    ) {
        Column (
            modifier = Modifier.padding(it)
        ){
            Image(
                painter = rememberAsyncImagePainter(item.image_url),
                contentDescription = "product image",
                modifier = Modifier
                    .size(100.dp)
                    .aspectRatio(1f)
            )

            Text(
                text = item.title,
                color = Color.Blue,
                style = TextStyle(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(top = 4.dp)
            )

            Row {
                Text(
                    text = item.sale_price.display_string,
                    color = Color.Blue,
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(top = 4.dp)
                )

                Text(
                    text = stringResource(id = R.string.reg_price_label),
                    color = Color.Blue,
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(top = 4.dp)
                )

                Text(
                    text = item.regular_price.display_string,
                    color = Color.Blue,
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(top = 4.dp)
                )
            }

            Text(
                text = stringResource(id = R.string.online_label),
                color = Color.Blue,
                style = TextStyle(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(top = 4.dp)
            )

            Divider(color = Color.Blue)

            Text(
                text = stringResource(id = R.string.product_details_label),
                color = Color.Blue,
                style = TextStyle(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(top = 4.dp)
            )

            Box{
                productDetailViewModel.fetchSingleProduct(item.id.toString())

                when (detailViewState) {
                    DetailViewState.Loading -> {
                        CircularProgressIndicator(modifier.align(Alignment.Center))
                    }

                    is DetailViewState.ItemNotFound -> {
                        CircularProgressIndicator(modifier.align(Alignment.Center))
                    }

                    is DetailViewState.Success -> {
                        Text(
                            text = detailViewState.item.description,
                            color = Color.Blue,
                            style = TextStyle(fontWeight = FontWeight.Bold),
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }
                }
            }

            Button(onClick = {
                //TBD
            }) {
                Text(text = stringResource(id = R.string.add_to_cart_button_label))
            }
        }
    }
}