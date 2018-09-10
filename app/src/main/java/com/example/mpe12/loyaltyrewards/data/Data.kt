package com.example.mpe12.loyaltyrewards.data

import com.example.mpe12.loyaltyrewards.enums.Channel

fun createRandomNumber() : Int {
    return  (1..5).shuffled().last()
}

fun selectAChannel(number : Int) : String {
    return when(number) {
        1 -> "NEWS"
        2 -> "MOVIES"
        3 -> "MUSIC"
        4 -> "KIDS"
        5 -> "SPORTS"
        else -> ""
    }
}

fun createRandomAccount() : String {
    val number : Int = (1234567 * createRandomNumber()) + (12 * createRandomNumber()) + 5200
    return number.toString()
}

fun createMockChannels() : ArrayList<String> {
    val arrayOfChannels : ArrayList<String> = ArrayList()
    val randomSelection = createRandomNumber()

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
    companion object {
        val fakeRandomChannels = createMockChannels()
        val fakeRandomAccount = createRandomAccount()
    }
}