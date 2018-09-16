package com.example.mpe12.loyaltyrewards

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule

import android.support.test.runner.AndroidJUnit4
import com.example.mpe12.loyaltyrewards.data.Data
import org.junit.Rule
import org.junit.Test
import org.junit.runner.*
import org.mockito.Mockito.*

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule @JvmField var activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun canSeeFirst4Channels() {
        // Button exists with text View Rewards
        onView(withId(R.id.viewRewardsButton)).check(matches(withText("View Rewards")))
        onView(withId(R.id.channelRecyclerView))
                .check(matches(hasDescendant(withText("News"))))
        onView(withId(R.id.channelRecyclerView))
                .check(matches(hasDescendant(withText("Movies"))))
        onView(withId(R.id.channelRecyclerView))
                .check(matches(hasDescendant(withText("Music"))))
        onView(withId(R.id.channelRecyclerView))
                .check(matches(hasDescendant(withText("Kids"))))
    }

}