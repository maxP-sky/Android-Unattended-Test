package com.example.mpe12.loyaltyrewards.controllers.data

import android.util.Log
import android.widget.Toast
import com.example.mpe12.loyaltyrewards.RewardsActivity
import com.example.mpe12.loyaltyrewards.enums.RewardEnum
import com.example.mpe12.loyaltyrewards.models.Eligible
import com.example.mpe12.loyaltyrewards.models.Reward
import com.example.mpe12.loyaltyrewards.models.RewardsData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun getReward(rewardCode : String) : RewardEnum {
    return when(rewardCode) {
        "CHAMPIONS_LEAGUE_FINAL_TICKET" -> RewardEnum.CHAMPIONS_LEAGUE_FINAL_TICKET
        "KARAOKE_PRO_MICROPHONE" -> RewardEnum.KARAOKE_PRO_MICROPHONE
        "PIRATES_OF_THE_CARIBBEAN_COLLECTION" -> RewardEnum.PIRATES_OF_THE_CARIBBEAN_COLLECTION
        else -> RewardEnum.NONE
    }
}

class RewardController(val parent : RewardsActivity) {
    val rewards : ArrayList<RewardEnum> = ArrayList()

    private fun setRewards(newRewards : ArrayList<Reward>?) {
        newRewards?.forEach {
            val rewardEnum = getReward(it.code)

            if (rewardEnum != RewardEnum.NONE) {
                rewards.add(rewardEnum)
            }
        }
    }

    private fun responseAction(rewards: ArrayList<Reward>?, eligible: Eligible?) {
        if (eligible?.output == "CUSTOMER_ELIGIBLE") {
            setRewards(rewards)
            parent.setRewardsView()
        } else {
            // For every other Eligibility Output than CUSTOMER_INELIGIBLE respond with output.
            if (eligible?.output == "CUSTOMER_INELIGIBLE") {
                parent.switchActivity("Customer is not eligible")
            } else {
                parent.switchActivity(eligible?.output)
            }
        }
    }

    fun createRequestCallback() : Callback<RewardsData> {
        return object : Callback<RewardsData> {
            override fun onResponse(call: Call<RewardsData>?, response: Response<RewardsData>?) {
                response?.isSuccessful.let {
                    if (it == true) {
                        val rewards : ArrayList<Reward>? = response?.body()?.rewards
                        val eligible : Eligible? = response?.body()?.eligibility

                        // Respond when rewards is empty and eligibility is present
                        responseAction(rewards, eligible)
                    } else {
                        Log.i("Response Failed", response?.code()?.toString())
                        parent.switchActivity("")
                    }
                }
            }

            override fun onFailure(call: Call<RewardsData>?, t: Throwable?) {
                Log.i("Failure", t.toString())
                if (t.toString().contains("Failed to connect")) {
                    Toast.makeText(parent.applicationContext, "Server has disconnected, Please wait", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}