package com.example.mpe12.loyaltyrewards.controllers.data

import com.example.mpe12.loyaltyrewards.enums.Channel

fun getChannel(channel : String) : Channel {
    return when(channel) {
        Channel.SPORTS.getCode() -> Channel.SPORTS
        Channel.KIDS.getCode()-> Channel.KIDS
        Channel.MUSIC.getCode() -> Channel.MUSIC
        Channel.NEWS.getCode() -> Channel.NEWS
        Channel.MOVIES.getCode() -> Channel.MOVIES
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