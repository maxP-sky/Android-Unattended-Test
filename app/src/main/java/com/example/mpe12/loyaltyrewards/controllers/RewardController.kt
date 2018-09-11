package com.example.mpe12.loyaltyrewards.controllers

import com.example.mpe12.loyaltyrewards.enums.RewardEnum
import com.example.mpe12.loyaltyrewards.models.Reward

fun getReward(rewardCode : String) : RewardEnum {
    return when(rewardCode) {
        "CHAMPIONS_LEAGUE_FINAL_TICKET" -> RewardEnum.CHAMPIONS_LEAGUE_FINAL_TICKET
        "KARAOKE_PRO_MICROPHONE" -> RewardEnum.KARAOKE_PRO_MICROPHONE
        "PIRATES_OF_THE_CARIBBEAN_COLLECTION" -> RewardEnum.PIRATES_OF_THE_CARIBBEAN_COLLECTION
        else -> RewardEnum.NONE
    }
}

class RewardController {
    val rewards : ArrayList<RewardEnum> = ArrayList()

    fun setRewards(newRewards : ArrayList<Reward>?) {
        newRewards?.forEach {
            val rewardEnum = getReward(it.code)

            if (rewardEnum != RewardEnum.NONE) {
                rewards.add(rewardEnum)
            }
        }
    }
}