package com.developer.dealslist.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.developer.dealslist.R
import com.developer.dealslist.model.DetailViewState
import com.developer.dealslist.model.ListingItem
import com.developer.dealslist.ui.theme.ItemDetailDescriptionTextColour
import com.developer.dealslist.ui.theme.ItemDetailSeparatorColour
import com.developer.dealslist.ui.theme.SalePriceColour
import com.developer.dealslist.ui.theme.StatusBarColour
import com.developer.dealslist.ui.theme.TextColourDarkGrey
import com.developer.dealslist.ui.theme.TextColourLightGrey
import com.developer.dealslist.viewmodel.ItemDetailPageViewModel

/**
 * This controls what is displayed on the details screen.
 * A loading indicator is shown in place of the description while the description is being fetched.
 * All other items are immediately displayed as they were already loaded from the list screen
 *
 * @param modifier the composable modifier
 * @param item the product being viewed
 * @param navController the navigation controller
 * @param productDetailViewModel the viewmodel for this page
 **/
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
        LazyColumn {
            item{
                Column(
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.dp_12))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(item.image_url),
                            contentDescription = "product image",
                            modifier = Modifier
                                .size(dimensionResource(id = R.dimen.deal_detail_image_size))
                                .clip(RoundedCornerShape(dimensionResource(id = R.dimen.dp_8)))
                                .padding(it)
                        )
                    }

                    Text(
                        text = item.title,
                        color = Color.Black,
                        modifier = Modifier.padding(top = dimensionResource(id = R.dimen.detail_page_title_padding)),
                        fontSize = dimensionResource(id = R.dimen.detail_page_title_fontSize).value.sp
                    )

                    Row(
                        modifier = Modifier.padding(top = dimensionResource(id = R.dimen.dp_15))
                    ) {
                        Text(
                            text = item.sale_price.display_string,
                            color = SalePriceColour,
                            style = TextStyle(fontWeight = FontWeight.Bold),
                            fontSize = dimensionResource(id = R.dimen.sp_21).value.sp,
                        )

                        Text(
                            text = stringResource(id = R.string.reg_price_label),
                            color = TextColourDarkGrey,
                            modifier = Modifier.padding(dimensionResource(id = R.dimen.dp_4)),
                            fontSize = dimensionResource(id = R.dimen.sp_12).value.sp
                        )

                        Text(
                            text = item.regular_price.display_string,
                            color = TextColourDarkGrey,
                            modifier = Modifier.padding(top = dimensionResource(id = R.dimen.dp_4)),
                            fontSize = dimensionResource(id = R.dimen.sp_12).value.sp
                        )
                    }

                    Text(
                        text = stringResource(id = R.string.online_label),
                        color = TextColourLightGrey,
                        fontSize = dimensionResource(id = R.dimen.sp_14).value.sp
                    )
                }
            }

            item{
                Divider(
                    modifier = Modifier
                        .height(dimensionResource(id = R.dimen.dp_15))
                        .border(
                            BorderStroke(
                                dimensionResource(id = R.dimen.detail_page_divider_border_stroke_width),
                                SolidColor(TextColourLightGrey)
                            )
                        ),
                    color = ItemDetailSeparatorColour
                )
            }

            item{
                LazyColumn(
                    modifier = Modifier
                        .padding(dimensionResource(id = R.dimen.dp_12))
                        .height(dimensionResource(id = R.dimen.detail_page_description_lazy_padding))
                ) {
                    item {
                        Text(
                            text = stringResource(id = R.string.product_details_label),
                            color = TextColourDarkGrey,
                            style = TextStyle(fontWeight = FontWeight.Bold),
                            modifier = Modifier.padding(top = dimensionResource(id = R.dimen.dp_4)),
                            fontSize = dimensionResource(id = R.dimen.detail_page_title_fontSize).value.sp
                        )
                    }

                    item{
                        Box {
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
                                        color = ItemDetailDescriptionTextColour,
                                        style = TextStyle(fontWeight = FontWeight.Bold),
                                        modifier = Modifier.padding(top = dimensionResource(id = R.dimen.detail_page_description_padding))
                                    )
                                }
                            }
                        }
                    }
                }
            }

            item{
                Box{
                    Divider(
                        modifier = Modifier
                            .height(dimensionResource(id = R.dimen.dp_15)),
                        color = Color.LightGray
                    )
                    Column {

                        Spacer(modifier = Modifier
                            .height(dimensionResource(id = R.dimen.dp_1))
                        )
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(dimensionResource(id = R.dimen.dp_16)))
                                .background(color = Color.White)
                                .fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {

                            Button(
                                modifier = Modifier
                                    .padding(dimensionResource(id = R.dimen.dp_16))
                                    .width(dimensionResource(id = R.dimen.detail_page_add_to_cart_button_width)),
                                onClick = {},
                                shape = RoundedCornerShape(10),
                                colors = ButtonDefaults.buttonColors(containerColor = StatusBarColour)
                            ) {
                                Text(
                                    text = stringResource(id = R.string.add_to_cart_button_label),
                                    fontSize = dimensionResource(id = R.dimen.detail_page_title_fontSize).value.sp,
                                    color = Color.White,
                                    style = TextStyle(fontWeight = FontWeight.Bold)
                                )
                            }
                        }
                    }
                }
            }


        }
    }
}