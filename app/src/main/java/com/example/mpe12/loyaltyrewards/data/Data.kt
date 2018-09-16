package com.example.mpe12.loyaltyrewards.data

import com.example.mpe12.loyaltyrewards.enums.Channel

fun createRandomNumber() : Int = (1..5).shuffled().last()

fun selectAChannel(number : Int) : String {
    return when(number) {
        1 -> Channel.NEWS.getCode()
        2 -> Channel.MOVIES.getCode()
        3 -> Channel.MUSIC.getCode()
        4 -> Channel.KIDS.getCode()
        5 -> Channel.SPORTS.getCode()
        else -> ""
    }
}

fun createRandomAccount() : String {
    val number : Int = (1234567 * createRandomNumber()) + (12 * createRandomNumber()) + 5200
    return number.toString()
}

fun createMockChannels() : ArrayList<String> {
    val arrayOfChannels : ArrayList<String> = ArrayList()
    val randomSelection = createRandomNumber() // Change this to 1,2,3,4,5 to check what rewards match up to.
    /*
        Options:

        1) News, Music and Sports subscriptions.
        2) Movies and Kids subscriptions.
        3) News and Sports subscriptions.
        4) News and Movies subscriptions.
        5) All subscriptions.
    */

    if (randomSelection == 1) {
        arrayOfChannels.add(selectAChannel(1))
        arrayOfChannels.add(selectAChannel(3))
        arrayOfChannels.add(selectAChannel(5))
    } else if (randomSelection == 2) {
        arrayOfChannels.add(selectAChannel(2))
        arrayOfChannels.add(selectAChannel(4))
    } else if (randomSelection == 3) {
        arrayOfChannels.add(selectAChannel(1))
        arrayOfChannels.add(selectAChannel(5))
    } else if (randomSelection == 4) {
        arrayOfChannels.add(selectAChannel(1))
        arrayOfChannels.add(selectAChannel(2))
    } else {
        arrayOfChannels.add(selectAChannel(1))
        arrayOfChannels.add(selectAChannel(2))
        arrayOfChannels.add(selectAChannel(3))
        arrayOfChannels.add(selectAChannel(4))
        arrayOfChannels.add(selectAChannel(5))

    }
    return arrayOfChannels
}

class Data {
    fun fakeRandomChannels() : ArrayList<String> {
        return createMockChannels()
    }
    fun fakeRandomAccount() : String {
        return createRandomAccount()
    }
}