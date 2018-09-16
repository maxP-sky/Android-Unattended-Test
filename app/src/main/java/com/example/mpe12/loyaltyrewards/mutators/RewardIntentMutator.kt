package com.example.mpe12.loyaltyrewards.mutators

import android.content.Intent

class RewardIntentMutator(private val intent : Intent) {
    private fun getSubscriptionsViaChannels(channels : ArrayList<String>) : String {
        return channels.joinToString(",")
    }
    private fun getChannels() : ArrayList<String> {
        return intent.getStringArrayListExtra("channels") ?: ArrayList()
    }
    operator fun component1() : String = getSubscriptionsViaChannels(getChannels())
    operator fun component2() : String = intent.getStringExtra("accountNumber") ?: ""
    operator fun component3() : Boolean = intent.getBooleanExtra("shouldGetData", false)
}