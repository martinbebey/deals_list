package com.developer.dealslist

import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.developer.dealslist.view.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented details page test, which will execute on an Android device.
 */
@RunWith(AndroidJUnit4::class)
class DetailsPageTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()
    lateinit var item: SemanticsMatcher
    var addToCartButtonLabel: String = ""
    var detailsPageTitle: String = ""

    @Before
    fun init(){
        item  = hasText( composeTestRule.activity.getString(R.string.random_deal_price)) and
                hasText(composeTestRule.activity.getString(R.string.online_label))
        addToCartButtonLabel = composeTestRule.activity.getString(R.string.add_to_cart_button_label)
        detailsPageTitle = composeTestRule.activity.getString(R.string.detail_page_title)
    }

    @Before
    fun navigate_to_details_page(){
        composeTestRule.onNode(item).performClick()
        composeTestRule.onNodeWithText(detailsPageTitle).assertExists()
    }

    @Test
    fun add_to_cart_button_is_clickable(){
        composeTestRule.onNodeWithText(addToCartButtonLabel).performClick()
    }
}