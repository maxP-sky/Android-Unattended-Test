package com.example.mpe12.loyaltyrewards

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mpe12.loyaltyrewards.data.Data
import com.example.mpe12.loyaltyrewards.controllers.data.ChannelController
import com.example.mpe12.loyaltyrewards.controllers.view.MainActivityViewController


class MainActivity : AppCompatActivity() {
    private val controller : ChannelController = ChannelController()
    private val viewController : MainActivityViewController = MainActivityViewController(this)

    init {
        // Set Fake Channels (subscriptions)
        controller.setChannels(Data.fakeRandomChannels)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set Layout default view for channels
        viewController.setLayoutView(controller)

        // If Message is present in intent show toast...
        val message : String = intent.getStringExtra("REWARDS_ACTIVITY_MESSAGE") ?: ""

        if (message != "") {
            Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
        }
    }
}
