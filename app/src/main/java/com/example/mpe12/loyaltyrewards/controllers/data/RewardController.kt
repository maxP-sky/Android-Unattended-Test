package com.example.mpe12.loyaltyrewards.controllers.data

import android.content.Intent
import android.util.Log
import android.widget.Toast

import com.example.mpe12.loyaltyrewards.RewardsActivity
import com.example.mpe12.loyaltyrewards.api.Request
import com.example.mpe12.loyaltyrewards.enums.RewardEnum
import com.example.mpe12.loyaltyrewards.models.Eligible
import com.example.mpe12.loyaltyrewards.models.Reward
import com.example.mpe12.loyaltyrewards.models.RewardsData
import com.example.mpe12.loyaltyrewards.mutators.RewardIntentMutator

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun getReward(rewardCode : String) : RewardEnum {
    return when(rewardCode) {
        RewardEnum.CHAMPIONS_LEAGUE_FINAL_TICKET.getCode() -> RewardEnum.CHAMPIONS_LEAGUE_FINAL_TICKET
        RewardEnum.KARAOKE_PRO_MICROPHONE.getCode() -> RewardEnum.KARAOKE_PRO_MICROPHONE
        RewardEnum.PIRATES_OF_THE_CARIBBEAN_COLLECTION.getCode() -> RewardEnum.PIRATES_OF_THE_CARIBBEAN_COLLECTION
        RewardEnum.NONE.getCode() -> RewardEnum.NONE
        else -> RewardEnum.ERROR
    }
}

class RewardController {
    val rewards: ArrayList<RewardEnum> = ArrayList()
    private val request: Request = Request()

    fun setRewards(newRewards: ArrayList<Reward>?) {
        if (rewards.size >= 1) rewards.clear()

        newRewards?.forEach {
            val rewardEnum = getReward(it.code)

            if (rewardEnum != RewardEnum.ERROR) {
                rewards.add(rewardEnum)
            }
        }
    }

    fun getData(activity: RewardsActivity, intent : Intent) {
        val (subscriptions, accountNumber, shouldGetData) = RewardIntentMutator(intent)

        if (shouldGetData) {
            request.getService(createRequestCallback(activity), subscriptions, accountNumber)
        }
    }

    private fun createRequestCallback(activity: RewardsActivity) : Callback<RewardsData> {
        return object : Callback<RewardsData> {
            override fun onResponse(call: Call<RewardsData>?, response: Response<RewardsData>?) {
                response?.isSuccessful.let {
                    if (it == true) {
                        val rewards : ArrayList<Reward>? = response?.body()?.rewards
                        val eligible : Eligible? = response?.body()?.eligibility

                        activity.respondToResponse(rewards, eligible)
                    } else {
                        Log.i("Request Failed", response?.code()?.toString())
                        activity.switchActivity("")
                    }
                }
            }

            override fun onFailure(call: Call<RewardsData>?, t: Throwable?) {
                if (t.toString().contains("Failed to connect")) {
                    Toast.makeText(activity.applicationContext, "Server has disconnected, please wait", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}