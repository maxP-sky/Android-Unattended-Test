package com.example.mpe12.loyaltyrewards

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule

import android.support.test.runner.AndroidJUnit4

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Rule @JvmField var activityTestRule = ActivityTestRule(MainActivity::class.java)


    @Test
    fun canSeeFirst4Channels() {
        // Get channels from activity initialisation and check if rendered in recycler view
        activityTestRule.activity.controller.channels.forEachIndexed { index, channel ->
            if (index <= 3 ) {
                onView(withId(R.id.channelRecyclerView))
                        .check(matches(hasDescendant(withText(channel.getTitle()))))
                onView(withId(R.id.channelRecyclerView))
                        .check(matches(hasDescendant(withText(channel.getDescription()))))
            }
        }

        // Button exists with text View Rewards
        onView(withId(R.id.viewRewardsButton)).check(matches(withText("View Rewards")))
    }

}