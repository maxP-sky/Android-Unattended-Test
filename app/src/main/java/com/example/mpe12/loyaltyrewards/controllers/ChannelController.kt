package com.example.mpe12.loyaltyrewards.controllers

import com.example.mpe12.loyaltyrewards.enums.Channel

fun getChannel(channel : String) : Channel {
    return when(channel) {
        "SPORTS" -> Channel.SPORTS
        "KIDS" -> Channel.KIDS
        "MUSIC" -> Channel.MUSIC
        "NEWS" -> Channel.NEWS
        "MOVIES" -> Channel.MOVIES
        else -> Channel.NONE
    }
}

class ChannelController {
    var channelsAsStrings : ArrayList<String> = ArrayList()
    val channels : ArrayList<Channel> = ArrayList()

    fun setChannels(newChannels : ArrayList<String>) {
        channelsAsStrings = newChannels
        newChannels.forEach { channels.add(getChannel(it)) }
    }
}