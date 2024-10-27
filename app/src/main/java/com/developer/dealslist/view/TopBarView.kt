package com.developer.dealslist.view

import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.developer.dealslist.R

@Composable
fun TopBarView(
    title: String,
    onBackNavClicked: () -> Unit = {}
){
    TopAppBar(
        title = {
            Text(
                text = title,
                color = colorResource(id = R.color.white)
            )
        },

        backgroundColor = colorResource(id = R.color.purple_200),
        navigationIcon = { NavigationIcon(title = title, onBackNavClicked = onBackNavClicked) }
    )
}

@Composable
fun NavigationIcon(
    title: String,
    onBackNavClicked: () -> Unit = {}
){
    if(!title.contains(stringResource(id = R.string.listing_page_title))) {
        IconButton(onClick = { onBackNavClicked() }) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                tint = Color.White,
                contentDescription = null
            )
        }
    }
    else{
        null
    }
}