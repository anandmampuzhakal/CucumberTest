package com.nz.anand.cucumbertest


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test

/**
 * @author Anand M Joseph (anandmampuzhakal@hotmail.com)
 */

class AppFlowTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun test_criticalUserFlow_throughoutEntireApp() {
        onView(withId(R.id.button_user_registration_start)).perform(click())
        onView(withId(R.id.username)).perform(typeText("Anand M Joseph test"), closeSoftKeyboard())
        onView(withId(R.id.amount)).perform(typeText("123.45"), closeSoftKeyboard())
        onView(withId(R.id.button_register)).perform(click())
        onView(withId(R.id.button_login_toapp)).perform(click())
        onView(withId(R.id.action_item)).perform(click())
        onView(withId(R.id.action_sharing)).perform(click())
        onView(withId(R.id.button_social_facebook)).perform(click())
        onView(withId(R.id.recyclerView_sharing_contacts)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}
