package com.developer.dealslist

import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.espresso.Espresso
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.developer.dealslist.view.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented screen navigation test, which will execute on an Android device.
 */
@RunWith(AndroidJUnit4::class)
class NavigationTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()
    lateinit var item: SemanticsMatcher
    var listPageTitle: String = ""
    var detailsPageTitle: String = ""

    @Before
    fun init(){
        item  = hasText( composeTestRule.activity.getString(R.string.random_deal_price)) and
                hasText(composeTestRule.activity.getString(R.string.online_label))
        listPageTitle = composeTestRule.activity.getString(R.string.listing_page_title)
        detailsPageTitle = composeTestRule.activity.getString(R.string.detail_page_title)
    }

    @Test
    fun navigates_to_detail_page_on_item_press(){
        composeTestRule.onNode(item).performClick()
        composeTestRule.onNodeWithText(detailsPageTitle).assertExists()
    }

    @Test
    fun navigates_back_to_list_page_on_back_press(){
        navigates_to_detail_page_on_item_press()
        Espresso.pressBack()
        composeTestRule.onNodeWithText(listPageTitle).assertExists()
    }
}