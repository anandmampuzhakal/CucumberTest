package modularization.features.onboardingtest

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test

class UserRegistrationFlowTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(UserRegistrationActivity::class.java)

    @Test
    fun loginFlowTest() {
        onView(withId(R.id.button_user_registration_start)).perform(click())
        onView(withId(R.id.username)).perform(
            ViewActions.typeText("Anand M Joseph test"),
            ViewActions.closeSoftKeyboard()
        )
        onView(withId(R.id.amount)).perform(
            ViewActions.typeText("123.45"),
            ViewActions.closeSoftKeyboard()
        )
        onView(withId(R.id.button_register)).perform(click())
        onView(withId(R.id.button_login_toapp)).check(matches(isDisplayed()))
    }
}
