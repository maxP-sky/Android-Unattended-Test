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

        assertEquals(Channel.SPORTS, channelController.channels.get(0))
        assertEquals(Channel.KIDS, channelController.channels.get(1))
        assertEquals(Channel.MOVIES, channelController.channels.get(2))
        assertEquals(Channel.NEWS, channelController.channels.get(3))
        assertEquals(Channel.NONE, channelController.channels.get(4))
    }
}