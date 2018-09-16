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

class MainActivityViewController(private val activity : MainActivity) {
    private lateinit var channelAdapter : ChannelAdapter
    private var account : String = Data.fakeRandomAccount

    fun setLayoutView(channelController : ChannelController) {
        activity.setContentView(R.layout.activity_main)
        activity.title = "Your subscriptions"

        val rewardsButton = activity.findViewById<Button>(R.id.viewRewardsButton)

        rewardsButton.setOnClickListener{
            val intent = Intent(activity, RewardsActivity::class.java)
            intent.putExtra("channels", channelController.channelsAsStrings)
            intent.putExtra("accountNumber", account)
            intent.putExtra("shouldGetData", true)
            activity.startActivity(intent)
        }

        val channelRecyclerView : RecyclerView = activity.findViewById(R.id.channelRecyclerView)
        channelRecyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)

        channelAdapter = ChannelAdapter(channelController.channels)
        channelRecyclerView.adapter = channelAdapter
    }
}