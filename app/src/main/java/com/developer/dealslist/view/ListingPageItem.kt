package com.developer.dealslist.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
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
 * @param item each item on the deals list
 * @param navigateToDetailScreen the screen transition operation when an item is selected from the list
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
                .padding(dimensionResource(id = R.dimen.dp_15))
        ) {
            Image(
                painter = rememberAsyncImagePainter(item.image_url),
                contentDescription = "product image",
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.deals_list_image_size))
                    .clip(RoundedCornerShape(dimensionResource(id = R.dimen.dp_8)))
            )

            Column(
                modifier = Modifier
                    .padding(start = dimensionResource(id = R.dimen.dp_8))
            ) {
                Row {
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
                    fontSize = dimensionResource(id = R.dimen.sp_12).value.sp
                )

                Text(
                    text = item.title,
                    color = Color.Black,
                    modifier = Modifier.padding(top = dimensionResource(id = R.dimen.dp_12)),
                    fontSize = dimensionResource(id = R.dimen.sp_14).value.sp
                )

                Row(
                    modifier = Modifier.padding(top = dimensionResource(id = R.dimen.dp_12))
                ) {
                    Text(
                        text = stringResource(id = R.string.in_stock_label),
                        color = Color.Green,
                        fontSize = dimensionResource(id = R.dimen.sp_12).value.sp
                    )

                    Text(
                        text = stringResource(id = R.string.in_aisle_label),
                        color = TextColourLightGrey,
                        modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.dp_4)),
                        fontSize = dimensionResource(id = R.dimen.sp_12).value.sp
                    )

                    Text(
                        text = item.aisle,
                        color = TextColourLightGrey,
                        fontSize = dimensionResource(id = R.dimen.sp_12).value.sp
                    )
                }
            }
        }

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(dimensionResource(id = R.dimen.dp_1))
                .padding(start = dimensionResource(id = R.dimen.dp_16)),
            color = ItemSeparatorColour
        )
    }
}