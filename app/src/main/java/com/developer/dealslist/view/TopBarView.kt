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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.developer.dealslist.R
import com.developer.dealslist.ui.theme.StatusBarColour
import com.developer.dealslist.ui.theme.TopAppBarColour
import com.developer.dealslist.ui.theme.TopBarTitleColour

@Composable
fun TopBarView(
    title: String,
    onBackNavClicked: () -> Unit = {}
){
    TopAppBar(
        title = {
            Text(
                text = title,
                color = TopBarTitleColour,
                fontWeight = FontWeight.ExtraBold
            )
        },

        backgroundColor = TopAppBarColour,
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
                tint = StatusBarColour,
                contentDescription = null
            )
        }
    }
    else{
        null
    }
}