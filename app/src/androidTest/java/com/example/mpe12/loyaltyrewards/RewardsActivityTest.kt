package com.example.mpe12.loyaltyrewards

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4

import com.example.mpe12.loyaltyrewards.enums.RewardEnum
import com.example.mpe12.loyaltyrewards.models.Eligible
import com.example.mpe12.loyaltyrewards.models.Reward

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RewardsActivityTest {
    @Rule
    @JvmField var activityTestRule = ActivityTestRule(RewardsActivity::class.java)
    @Test
    fun loadingPage() {
        onView(ViewMatchers.withId(R.id.loadingTextView)).check(ViewAssertions.matches(withText("Loading ...")))
    }
    @Test
    fun whenEligibleAndRewardsAreGiven() {
        val fakeRewards = ArrayList<Reward>()
        fakeRewards.add(Reward("CHAMPIONS_LEAGUE_FINAL_TICKET"))
        fakeRewards.add(Reward("KARAOKE_PRO_MICROPHONE"))
        fakeRewards.add(Reward("PIRATES_OF_THE_CARIBBEAN_COLLECTION"))
        fakeRewards.add(Reward("RANDOM_REWARD!!!!"))

        val fakeEligibility = Eligible("CUSTOMER_ELIGIBLE")

        activityTestRule.runOnUiThread{
            // Call respondToResponse to check that rewards render with CUSTOMER_ELIGIBLE
            activityTestRule.activity.respondToResponse(fakeRewards, fakeEligibility)
        }

        onView(ViewMatchers.withId(R.id.rewardsRecyclerView))
            .check(ViewAssertions.matches(ViewMatchers.hasDescendant(withText(RewardEnum.CHAMPIONS_LEAGUE_FINAL_TICKET.getTitle()))))
        onView(ViewMatchers.withId(R.id.rewardsRecyclerView))
                .check(ViewAssertions.matches(ViewMatchers.hasDescendant(withText(RewardEnum.KARAOKE_PRO_MICROPHONE.getTitle()))))
        onView(ViewMatchers.withId(R.id.rewardsRecyclerView))
                .check(ViewAssertions.matches(ViewMatchers.hasDescendant(withText(RewardEnum.PIRATES_OF_THE_CARIBBEAN_COLLECTION.getTitle()))))
    }
    @Test
    fun whenNotEligibleLoadMainActivity() {
        val fakeRewards = ArrayList<Reward>()
        val fakeEligibility = Eligible("CUSTOMER_INELIGIBLE")

        activityTestRule.runOnUiThread{
            activityTestRule.activity.respondToResponse(fakeRewards, fakeEligibility)
        }
        onView(ViewMatchers.withId(R.id.viewRewardsButton)).check(ViewAssertions.matches(withText("View Rewards")))
    }
}