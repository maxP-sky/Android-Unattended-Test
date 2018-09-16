package com.example.mpe12.loyaltyrewards.controllers.view

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Button
import com.example.mpe12.loyaltyrewards.MainActivity
import com.example.mpe12.loyaltyrewards.R
import com.example.mpe12.loyaltyrewards.RewardsActivity
import com.example.mpe12.loyaltyrewards.adapters.ChannelAdapter
import com.example.mpe12.loyaltyrewards.controllers.data.ChannelController
import com.example.mpe12.loyaltyrewards.data.Data
import com.example.mpe12.loyaltyrewards.enums.IntentEnum

class MainActivityViewController(private val activity : MainActivity) {
    private lateinit var channelAdapter : ChannelAdapter
    private var account : String = Data().fakeRandomAccount()

    private val channelsEnum
            = IntentEnum.REWARD_INTENT_CHANNELS.getKey()
    private val accountEnum
            = IntentEnum.REWARD_INTENT_ACCOUNT.getKey()
    private val shouldGetDataEnum
            = IntentEnum.REWARD_INTENT_CHECK.getKey()

    fun setLayoutView(channelController : ChannelController) {
        activity.setContentView(R.layout.activity_main)
        activity.title = "Your subscriptions"

        val rewardsButton = activity.findViewById<Button>(R.id.viewRewardsButton)

        onClick(rewardsButton, channelController)

        val channelRecyclerView : RecyclerView = activity.findViewById(R.id.channelRecyclerView)
        channelRecyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        channelAdapter = ChannelAdapter(channelController.channels)
        channelRecyclerView.adapter = channelAdapter
    }

    private fun onClick(button : Button, controller : ChannelController) {
        button.setOnClickListener{
            val intent = Intent(activity, RewardsActivity::class.java)

            intent.putExtra(channelsEnum, controller.channelsAsStrings)
            intent.putExtra(accountEnum, account)
            intent.putExtra(shouldGetDataEnum, true)

            activity.startActivity(intent)
        }
    }
}