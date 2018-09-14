package com.example.mpe12.loyaltyrewards.controllers

import com.example.mpe12.loyaltyrewards.controllers.data.RewardController
import com.example.mpe12.loyaltyrewards.enums.RewardEnum
import com.example.mpe12.loyaltyrewards.models.Reward
import org.junit.Test
import org.junit.Assert.*

class RewardControllerTest {
    @Test
    fun canSetRewards() {
        val rewardController = RewardController()
        val rewardDataArray = ArrayList<Reward>()

        // Check ArrayList<Rewards> is empty
        assertEquals(rewardController.rewards.size, 0)

        rewardDataArray.add(Reward("CHAMPIONS_LEAGUE_FINAL_TICKET"))
        rewardDataArray.add(Reward("KARAOKE_PRO_MICROPHONE"))
        rewardDataArray.add(Reward("PIRATES_OF_THE_CARIBBEAN_COLLECTION"))
        rewardDataArray.add(Reward("REWARD_THAT_DOESN'T EXIST"))

        assertEquals(rewardController.rewards.get(0), RewardEnum.CHAMPIONS_LEAGUE_FINAL_TICKET)
        assertEquals(rewardController.rewards.get(1), RewardEnum.KARAOKE_PRO_MICROPHONE)
        assertEquals(rewardController.rewards.get(2), RewardEnum.PIRATES_OF_THE_CARIBBEAN_COLLECTION)

        // Should not have REWARD_THAT_DOESN'T EXIST
        assertEquals(rewardController.rewards.size, 3)
    }
}