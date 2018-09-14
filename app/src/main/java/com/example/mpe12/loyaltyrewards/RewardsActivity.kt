package com.example.mpe12.loyaltyrewards

import android.content.Intent
import android.os.Bundle

import android.support.v7.app.AppCompatActivity

import com.example.mpe12.loyaltyrewards.api.Request
import com.example.mpe12.loyaltyrewards.controllers.data.RewardController
import com.example.mpe12.loyaltyrewards.controllers.view.RewardsActivityViewController
import com.example.mpe12.loyaltyrewards.mutators.RewardIntentMutator

class RewardsActivity : AppCompatActivity() {
    private val request: Request = Request()
    private val controller: RewardController = RewardController(this)
    private val viewController : RewardsActivityViewController = RewardsActivityViewController(this)

    fun setRewardsView() {
        // Set Rewards view for loaded activities
        setContentView(R.layout.activity_rewards)
        viewController.setRewardsLayoutView(controller, intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewController.setLayoutView(controller)

        // Set request for controller
        val (subscriptions, accountNumber) = RewardIntentMutator(intent)
        request.getService(controller.createRequestCallback(), subscriptions, accountNumber)
    }

    fun switchActivity(message : String?) {
        val intent = Intent(this@RewardsActivity, MainActivity::class.java)
        intent.putExtra("REWARDS_ACTIVITY_MESSAGE", message)
        startActivity(intent)
    }
}
