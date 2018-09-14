package com.example.mpe12.loyaltyrewards.controllers.view

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Button
import android.widget.TextView
import com.example.mpe12.loyaltyrewards.MainActivity
import com.example.mpe12.loyaltyrewards.R
import com.example.mpe12.loyaltyrewards.RewardsActivity
import com.example.mpe12.loyaltyrewards.adapters.RewardAdapter
import com.example.mpe12.loyaltyrewards.controllers.data.RewardController


class RewardsActivityViewController(private val activity : RewardsActivity) {
    fun setLayoutView(rewardController: RewardController) {
        activity.setContentView(R.layout.loading)
        activity.title = "Rewards"
    }
    fun setRewardsLayoutView(rewardController: RewardController, intent : Intent) {

        val backToHomeButton = activity.findViewById<Button>(R.id.backToHomeButton)
        backToHomeButton.setOnClickListener {
            val intent = Intent(activity, MainActivity::class.java)
            activity.startActivity(intent)
        }

        val rewardRecyclerView: RecyclerView = activity.findViewById(R.id.rewardsRecyclerView)
        rewardRecyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        // Set Recycler View Adapter for RewardAdapter
        val adapter = RewardAdapter(rewardController.rewards)
        rewardRecyclerView.adapter = adapter

        val accountNumberTextView: TextView = activity.findViewById(R.id.accountNumber)
        accountNumberTextView.text = "Rewards for Account: ${intent.getStringExtra("accountNumber")}"
    }
}