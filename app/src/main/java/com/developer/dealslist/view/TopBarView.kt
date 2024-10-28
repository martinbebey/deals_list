package com.developer.dealslist.view

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.developer.dealslist.R
import com.developer.dealslist.ui.theme.StatusBarColour
import com.developer.dealslist.ui.theme.TopAppBarColour
import com.developer.dealslist.ui.theme.TopBarTitleColour

/**
 * The top navigation bar
 * @param title the current page title
 * @param onBackNavClicked: the action performed when the back button is pressed
 **/
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

/**
 * The top bar navigation back button icon
 * @param title the current page title
 * @param onBackNavClicked: the action performed when the back button is pressed
 **/
@Composable
fun NavigationIcon(
    title: String,
    onBackNavClicked: () -> Unit = {}
){
    if(!title.contains(stringResource(id = R.string.listing_page_title))) {
        IconButton(onClick = { onBackNavClicked() }, modifier = Modifier.testTag(stringResource(id = R.string.back_button_tag))) {
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