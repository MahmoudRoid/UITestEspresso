package mahmoudroid.uitestespresso

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import mahmoudroid.uitestespresso.MainActivity.Companion.buildToastMessage
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{


    @Test
    fun test_showDialog_captureNameInput() {
        // GIVEN
        val activityScenatio = ActivityScenario.launch(MainActivity::class.java)
        val text = "Tito"

        onView(withId(R.id.text_name)).check(matches(withText("")))
        onView(withId(R.id.button_launch_dialog)).perform(click())

        // check for show dialog
        onView(withText(R.string.text_enter_name)).check(matches(isDisplayed()))

        // check for click ok with empty edt ==> should not disappear
        onView(withText(R.string.text_ok)).perform(click())
        onView(withText(R.string.text_enter_name)).check(matches(isDisplayed()))

        // type data into InputLayout and click ==> dialog should disappear
        onView(withId(R.id.md_input_message)).perform(typeText(text))
        onView(withText(R.string.text_ok)).perform(click())
        onView(withText(R.string.text_enter_name)).check((doesNotExist()))

        // check text view text
        onView(withId(R.id.text_name)).check(matches(withText(text)))

        // Is toast displayed and is the message correct?
        onView(withText(buildToastMessage(text))).inRoot(ToastMatcher())
            .check(matches(isDisplayed()))

    }

}