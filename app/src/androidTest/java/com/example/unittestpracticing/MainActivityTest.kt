package com.example.unittestpracticing

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.activityScenarioRule
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.core.AllOf.allOf
import org.junit.Rule
import org.junit.Test

class MainActivityTest {


    @get:Rule
    val activityScenarioRule = activityScenarioRule<MainActivity>()


    @Test
    fun testNextButton_expectedCorrectOwnerName() {
        onView(withId(R.id.nextButton)).perform(click())
        onView(withId(R.id.ownerName)).check(matches(withText("ricardo.ricardo0")))
    }

    @Test
    fun testPrevButton_expectedCorrectOwnerName() {
        onView(withId(R.id.nextButton)).perform(click())
        onView(withId(R.id.nextButton)).perform(click())
        onView(withId(R.id.nextButton)).perform(click())
        onView(withId(R.id.prevButton)).perform(click())
        onView(withId(R.id.ownerName)).check(matches(withText("ricardo.ricardo2")))
    }

    @Test
    fun testShareButton_expectedIntentChooser() {
        Intents.init()
        val expected = allOf(hasAction(Intent.ACTION_SEND))
        onView(withId(R.id.ownerName)).perform(click())
        intended(chooser(expected))
        Intents.release()
    }

    private fun chooser(matcher: Matcher<Intent>): Matcher<Intent> {
        return allOf(
            hasAction(Intent.ACTION_CHOOSER),
            hasExtra(`is`(Intent.EXTRA_INTENT), matcher))
    }
}