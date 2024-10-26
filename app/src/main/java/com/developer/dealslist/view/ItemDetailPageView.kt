package com.developer.dealslist.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.developer.dealslist.R
import com.developer.dealslist.model.ListingItem
import com.developer.dealslist.model.ViewState

@Composable
fun ItemDetailPageView(
    item: ListingItem
){

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = {
            TopBarView(title = stringResource(id = R.string.detail_page_title))
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
                    .fillMaxSize()
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

            Text(
                text = item.description,
                color = Color.Blue,
                style = TextStyle(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(top = 4.dp)
            )

            Button(onClick = {
                //TBD
            }) {
                Text(text = stringResource(id = R.string.add_to_cart_button_label))
            }
        }
    }
}