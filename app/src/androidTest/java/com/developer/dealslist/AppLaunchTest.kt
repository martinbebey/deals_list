package com.developer.dealslist

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.developer.dealslist.view.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented app launch test, which will execute on an Android device.
 */
@RunWith(AndroidJUnit4::class)
class AppLaunchTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()
    var listPageTitle: String = ""

    @Before
    fun init(){
        listPageTitle = composeTestRule.activity.getString(R.string.listing_page_title)
    }

    @Test
    fun app_launches(){
        composeTestRule.onNodeWithText(listPageTitle).assertExists()
    }

    @Test
    fun app_launches_within_quarter_second(){
        composeTestRule.waitUntil(timeoutMillis = 250) {
            composeTestRule
                .onAllNodesWithText(listPageTitle)
                .fetchSemanticsNodes().size == 1
        }

        composeTestRule.onNodeWithText(listPageTitle).assertExists()
    }

    @Test
    fun app_launches_within_half_second(){
        composeTestRule.waitUntil(timeoutMillis = 500) {
            composeTestRule
                .onAllNodesWithText(listPageTitle)
                .fetchSemanticsNodes().size == 1
        }

        composeTestRule.onNodeWithText(listPageTitle).assertExists()
    }
    @Test
    fun app_launches_within_1_second(){
        composeTestRule.waitUntil(timeoutMillis = 1000) {
            composeTestRule
                .onAllNodesWithText(listPageTitle)
                .fetchSemanticsNodes().size == 1
        }

        composeTestRule.onNodeWithText(listPageTitle).assertExists()
    }

    @Test
    fun app_launches_within_2_second(){
        composeTestRule.waitUntil(timeoutMillis = 2000) {
            composeTestRule
                .onAllNodesWithText(listPageTitle)
                .fetchSemanticsNodes().size == 1
        }

        composeTestRule.onNodeWithText(listPageTitle).assertExists()
    }

    @Test
    fun app_launches_within_3_second(){
        composeTestRule.waitUntil(timeoutMillis = 3000) {
            composeTestRule
                .onAllNodesWithText(listPageTitle)
                .fetchSemanticsNodes().size == 1
        }

        composeTestRule.onNodeWithText(listPageTitle).assertExists()
    }

    @Test
    fun app_launches_within_4_second(){
        composeTestRule.waitUntil(timeoutMillis = 4000) {
            composeTestRule
                .onAllNodesWithText(listPageTitle)
                .fetchSemanticsNodes().size == 1
        }

        composeTestRule.onNodeWithText(listPageTitle).assertExists()
    }

    @Test
    fun app_launches_within_5_second(){
        composeTestRule.waitUntil(timeoutMillis = 5000) {
            composeTestRule
                .onAllNodesWithText(listPageTitle)
                .fetchSemanticsNodes().size == 1
        }

        composeTestRule.onNodeWithText(listPageTitle).assertExists()
    }
}