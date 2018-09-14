package com.example.mpe12.loyaltyrewards.controllers

import com.example.mpe12.loyaltyrewards.controllers.data.ChannelController
import com.example.mpe12.loyaltyrewards.enums.Channel
import org.junit.Test
import org.junit.Assert.*

class ChannelControllerTest {
    @Test
    fun canSetChannels() {
        val channelController = ChannelController()
        assertEquals(channelController.channelsAsStrings.size, 0)
        assertEquals(channelController.channels.size, 0)

        val channelStrings = ArrayList<String>()
        channelStrings.add("SPORTS")
        channelStrings.add("KIDS")
        channelStrings.add("MOVIES")
        channelStrings.add("NEWS")
        channelStrings.add("SOMERANDOM")

        channelController.setChannels(channelStrings)

        assertEquals(channelController.channels.get(0), Channel.SPORTS)
        assertEquals(channelController.channels.get(1), Channel.KIDS)
        assertEquals(channelController.channels.get(2), Channel.MOVIES)
        assertEquals(channelController.channels.get(3), Channel.NEWS)
        assertEquals(channelController.channels.get(4), Channel.NONE)
    }
}