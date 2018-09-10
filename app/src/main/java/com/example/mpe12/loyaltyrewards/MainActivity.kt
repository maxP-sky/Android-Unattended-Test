package com.example.mpe12.loyaltyrewards

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Button
import com.example.mpe12.loyaltyrewards.adapters.ChannelAdapter
import com.example.mpe12.loyaltyrewards.data.Data
import com.example.mpe12.loyaltyrewards.controllers.ChannelController


class MainActivity : AppCompatActivity() {
    private val account : String
    private val channelController : ChannelController = ChannelController()
    lateinit var channelRecyclerView: RecyclerView
    lateinit var channelAdpater : ChannelAdapter

    init {
        // Set Fake Channels (subscriptions)
        channelController.setChannels(Data.fakeRandomChannels)
        account = Data.fakeRandomAccount
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rewardsButton = findViewById<Button>(R.id.viewRewardsButton)

        // Set rewards button to pass accountNumber & channels through to RewardsActivity..
        rewardsButton.setOnClickListener{
            val intent = Intent(this@MainActivity, RewardsActivity::class.java)
            intent.putExtra("channels", channelController.channelsAsStrings)
            intent.putExtra("accountNumber", account)
            startActivity(intent)
        }

        channelRecyclerView = findViewById(R.id.channelRecyclerView)
        channelRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        channelAdpater = ChannelAdapter(channelController.channels)
        channelRecyclerView.adapter = channelAdpater

    }
}
