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
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.developer.dealslist.R
import com.developer.dealslist.model.DetailViewState
import com.developer.dealslist.model.ListingItem
import com.developer.dealslist.model.ViewState
import com.developer.dealslist.ui.theme.ItemDetailDescriptionTextColour
import com.developer.dealslist.ui.theme.ItemDetailSeparatorColour
import com.developer.dealslist.ui.theme.ItemSeparatorColour
import com.developer.dealslist.ui.theme.SalePriceColour
import com.developer.dealslist.ui.theme.StatusBarColour
import com.developer.dealslist.ui.theme.TextColourDarkGrey
import com.developer.dealslist.ui.theme.TextColourLightGrey
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
                        modifier = Modifier.padding(top = 30.dp),
                        fontSize = 18.sp
                    )

                    Row(
                        modifier = Modifier.padding(top = 15.dp)
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
                        .height(15.dp)
                        .border(BorderStroke(0.dp, SolidColor(TextColourLightGrey))),
                    color = ItemDetailSeparatorColour
                )
            }

            item{
                LazyColumn(
                    modifier = Modifier
                        .padding(dimensionResource(id = R.dimen.dp_12))
                        .height(185.dp)
                ) {
                    item {
                        Text(
                            text = stringResource(id = R.string.product_details_label),
                            color = TextColourDarkGrey,
                            style = TextStyle(fontWeight = FontWeight.Bold),
                            modifier = Modifier.padding(top = 4.dp),
                            fontSize = 18.sp
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
                                        modifier = Modifier.padding(top = 20.dp)
                                    )
                                }
                            }
                        }
                    }

//                item{
//                    Button(onClick = {
//                            //TBD
//                        }) {
//                        Text(text = stringResource(id = R.string.add_to_cart_button_label))
//                    }
//                }
                }
            }

            item{
                Box{
                    Divider(
                        modifier = Modifier
                            .height(15.dp),
                        color = Color.LightGray
                    )
                    Column {

                        Spacer(modifier = Modifier
                            .height(1.dp)
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
                                    .padding(16.dp)
                                    .width(328.dp),
                                onClick = {},
                                shape = RoundedCornerShape(10),
                                colors = ButtonDefaults.buttonColors(containerColor = StatusBarColour)
                            ) {
                                Text(
                                    text = stringResource(id = R.string.add_to_cart_button_label),
                                    fontSize = 18.sp,
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