package com.example.mpe12.loyaltyrewards.mutators

import android.content.Intent
import com.example.mpe12.loyaltyrewards.enums.IntentEnum

class RewardIntentMutator(private val intent : Intent) {
    private val channelsEnum
            = IntentEnum.REWARD_INTENT_CHANNELS.getKey()
    private val accountEnum
            = IntentEnum.REWARD_INTENT_ACCOUNT.getKey()
    private val shouldGetData
            = IntentEnum.REWARD_INTENT_CHECK.getKey()

    private fun getSubscriptionsViaChannels(channels : ArrayList<String>) : String {
        return channels.joinToString(",")
    }
    private fun getChannels() : ArrayList<String> {
        return intent.getStringArrayListExtra(channelsEnum) ?: ArrayList()
    }
    operator fun component1() : String = getSubscriptionsViaChannels(getChannels())
    operator fun component2() : String = intent.getStringExtra(accountEnum) ?: ""
    operator fun component3() : Boolean = intent.getBooleanExtra(shouldGetData, false)
}