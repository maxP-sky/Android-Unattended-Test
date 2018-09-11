package com.example.mpe12.loyaltyrewards.mutators

import android.content.Intent

class RewardIntentMutator(private val intent : Intent) {
    private fun getSubscriptionsViaChannels(channels : ArrayList<String>) : String {
        return channels.joinToString(",")
    }
    operator fun component1() : String {
        val subscriptionChannels = intent.getStringArrayListExtra("channels")
        return getSubscriptionsViaChannels(subscriptionChannels)
    }
    operator fun component2() : String = intent.getStringExtra("accountNumber")
}