package com.example.unittestpracticing

import android.content.Intent
import android.service.autofill.FieldClassification.Match
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.intent.matcher.IntentMatchers.toPackage
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.activityScenarioRule
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test


class NoteActivityTest {

    @get:Rule
    val activityScenarioRule = activityScenarioRule<NoteActivity>()

    @Test
    fun testInvalidNoteData_expectedNoIntent() {
        Intents.init()
        onView(withId(R.id.displayNote)).perform(click())
        Intents.assertNoUnverifiedIntents()
        Intents.release()
    }

    @Test
    fun testValidNoteData_expectedIntent() {
        onView(withId(R.id.noteTitle)).perform(typeText("Hello"))
        onView(withId(R.id.noteDesc)).perform(typeText("World"), closeSoftKeyboard())

        onView(withId(R.id.displayNote)).perform(click())

        onView(withId(R.id.noteDetails)).check(matches(withText("Title: Hello, Description: World")))
    }
}