package com.developer.dealslist

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.developer.dealslist.model.ListingItem
import coil.compose.rememberAsyncImagePainter

/**
 * This controls what each item in the list will look like on the screen
 **/
@Composable
fun ListingPageItem(
    item: ListingItem
) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = rememberAsyncImagePainter(item.imageUrl),
                contentDescription = "product image",
                modifier = Modifier
                    .fillMaxSize()
                    .aspectRatio(1f)
            )

            Column {
                Row {
                    Text(
                        text = item.sale_price.displayingString,
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
                        text = item.regular_price.displayingString,
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

                Text(
                    text = item.title,
                    color = Color.Blue,
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(top = 4.dp)
                )

                Row {
                    Text(
                        text = stringResource(id = R.string.in_stock_label),
                        color = Color.Blue,
                        style = TextStyle(fontWeight = FontWeight.Bold),
                        modifier = Modifier.padding(top = 4.dp)
                    )

                    Text(
                        text = stringResource(id = R.string.in_aisle_label),
                        color = Color.Blue,
                        style = TextStyle(fontWeight = FontWeight.Bold),
                        modifier = Modifier.padding(top = 4.dp)
                    )

                    Text(
                        text = item.aisle,
                        color = Color.Blue,
                        style = TextStyle(fontWeight = FontWeight.Bold),
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
        }

        Divider(color = Color.Blue)
    }
}