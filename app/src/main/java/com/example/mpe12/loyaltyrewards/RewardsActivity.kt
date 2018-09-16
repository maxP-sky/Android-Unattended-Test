package com.example.mpe12.loyaltyrewards

import android.content.Intent
import android.os.Bundle

import android.support.v7.app.AppCompatActivity

import com.example.mpe12.loyaltyrewards.controllers.data.RewardController
import com.example.mpe12.loyaltyrewards.controllers.view.RewardsActivityViewController
import com.example.mpe12.loyaltyrewards.enums.ActivityMessage
import com.example.mpe12.loyaltyrewards.enums.RewardEnum
import com.example.mpe12.loyaltyrewards.models.*

class RewardsActivity : AppCompatActivity() {
    private val controller: RewardController = RewardController()
    private val viewController : RewardsActivityViewController = RewardsActivityViewController(this)

    private fun setRewardsView() {
        // Set Rewards view for loaded activities
        setContentView(R.layout.activity_rewards)
        viewController.setRewardsLayoutView(controller, intent)
    }

    fun respondToResponse(rewards: ArrayList<Reward>?, eligible: Eligible?) {
        if (eligible?.output == ActivityMessage.REWARDS_OUTPUT_ELIGIBLE.outputKey()) {
            if (rewards?.size == 0) rewards.add(Reward(RewardEnum.NONE.getCode()))
            controller.setRewards(rewards)
            setRewardsView()
        } else {
            val outputEnum = ActivityMessage.REWARDS_OUTPUT_INELIGIBLE

            if (eligible?.output == outputEnum.outputKey()) {
                switchActivity(outputEnum.response())
            } else {
                switchActivity(eligible?.output)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewController.setLayoutView(controller)
        controller.getData(this, intent)
    }

    fun switchActivity(message : String?) {
        val intent = Intent(this@RewardsActivity, MainActivity::class.java)
        intent.putExtra(ActivityMessage.REWARDS_ACTIVITY.outputKey(), message)
        startActivity(intent)
    }
}
