package com.developer.dealslist.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.developer.dealslist.model.ListingItem
import coil.compose.rememberAsyncImagePainter
import com.developer.dealslist.R
import com.developer.dealslist.ui.theme.ItemSeparatorColour
import com.developer.dealslist.ui.theme.SalePriceColour
import com.developer.dealslist.ui.theme.TextColourDarkGrey
import com.developer.dealslist.ui.theme.TextColourLightGrey

/**
 * This controls what each item in the list will look like on the screen
 **/
@Composable
fun ListingPageItem(
    item: ListingItem,
    navigateToDetailScreen: (ListingItem) -> Unit
) {
    Column(
        modifier = Modifier.clickable { navigateToDetailScreen(item) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
//                .drawBehind {
//
//                    val strokeWidth = 10.0f
//                    val y = size.height - strokeWidth / 2
//
//                    drawLine(
//                        Color.LightGray,
//                        Offset(0f, y),
//                        Offset(size.width, y),
//                        strokeWidth
//                    )
//                }
        ) {
            Image(
                painter = rememberAsyncImagePainter(item.image_url),
                contentDescription = "product image",
                modifier = Modifier
                    .size(140.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Column(
                modifier = Modifier
                    .padding(start = 8.dp)
            ) {
                Row {
                    Text(
                        text = item.sale_price.display_string,
                        color = SalePriceColour,
                        style = TextStyle(fontWeight = FontWeight.Bold),
                        fontSize = 21.sp,
                    )

                    Text(
                        text = stringResource(id = R.string.reg_price_label),
                        color = TextColourDarkGrey,
                        modifier = Modifier.padding(4.dp),
                        fontSize = 12.sp
                    )

                    Text(
                        text = item.regular_price.display_string,
                        color = TextColourDarkGrey,
                        modifier = Modifier.padding(top = 4.dp),
                        fontSize = 12.sp
                    )
                }

                Text(
                    text = stringResource(id = R.string.online_label),
                    color = TextColourLightGrey,
                    fontSize = 12.sp
                )

                Text(
                    text = item.title,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 12.dp),
                    fontSize = 14.sp
                )

                Row(
                    modifier = Modifier.padding(top = 12.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.in_stock_label),
                        color = Color.Green,
                        fontSize = 12.sp
                    )

                    Text(
                        text = stringResource(id = R.string.in_aisle_label),
                        color = TextColourLightGrey,
                        modifier = Modifier.padding(horizontal = 4.dp),
                        fontSize = 12.sp
                    )

                    Text(
                        text = item.aisle,
                        color = TextColourLightGrey,
                        fontSize = 12.sp
                    )
                }
            }
        }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .padding(start = 16.dp),
            color = ItemSeparatorColour
        )
    }
}