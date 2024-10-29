package com.developer.dealslist

import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.developer.dealslist.view.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 */
@RunWith(AndroidJUnit4::class)
class DealsTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()
    lateinit var item: SemanticsMatcher
    var listPageTitle: String = ""
    var detailsPageTitle: String = ""
    var onlineLabel: String = ""
    var backButtonTag: String = ""
    var apiErrorMessage: String = "someString"

    @Before
    fun init(){
        item  = hasText( composeTestRule.activity.getString(R.string.random_deal_price)) and
                hasText(composeTestRule.activity.getString(R.string.online_label))
        listPageTitle = composeTestRule.activity.getString(R.string.listing_page_title)
        detailsPageTitle = composeTestRule.activity.getString(R.string.detail_page_title)
        onlineLabel = composeTestRule.activity.getString(R.string.online_label)
        backButtonTag = composeTestRule.activity.getString(R.string.back_button_tag)
        apiErrorMessage = composeTestRule.activity.getString(R.string.item_not_found_message)
    }

    @Test
    fun launch_itemClick_navToDetails_backClick_navToList() {
        composeTestRule.onNode(item).performClick()
        composeTestRule.onNodeWithTag(backButtonTag).performClick()
        composeTestRule.onNodeWithText(listPageTitle).assertExists()
    }

    @Test
    fun check_if_app_launches_within_5_seconds(){
        composeTestRule.onNodeWithText(listPageTitle).assertExists()
    }

    @Test
    fun check_if_a_list_item_is_clickable(){
        composeTestRule.onNode(item).performClick()
    }

    @Test
    fun check_if_list_api_call_does_not_return_an_error(){
        composeTestRule.onNodeWithText(apiErrorMessage).assertDoesNotExist()
    }

    @Test
    fun check_if_home_screen_title_is_list(){
        composeTestRule.onNodeWithText(listPageTitle).assertExists()
    }

    @Test
    fun back_button_not_showing_on_home_screens(){
        composeTestRule.onNodeWithTag(backButtonTag).assertDoesNotExist()
    }
}