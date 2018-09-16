package com.example.mpe12.loyaltyrewards

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.example.mpe12.loyaltyrewards.data.Data
import com.example.mpe12.loyaltyrewards.controllers.data.ChannelController
import com.example.mpe12.loyaltyrewards.controllers.view.MainActivityViewController
import com.example.mpe12.loyaltyrewards.enums.ActivityMessage


class MainActivity : AppCompatActivity() {
    val controller : ChannelController = ChannelController()
    private val viewController : MainActivityViewController = MainActivityViewController(this)
    private val intentMessageKey : String = ActivityMessage.REWARDS_ACTIVITY.outputKey()
    private val channels : ArrayList<String> = Data().fakeRandomChannels()

    init {
        // Set Channels
        controller.setChannels(channels)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set Layout default view for channels
        viewController.setLayoutView(controller)

        // If Message is present in intent show toast...
        val message = intent.getStringExtra(intentMessageKey)
                ?: ""

        if (message != "") {
            Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
        }
    }
}
