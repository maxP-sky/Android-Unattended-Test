package com.example.mpe12.loyaltyrewards.enums

import java.lang.System

interface ConfigEnum {
    fun getRewardsEndpoint() : String
}

enum class Config : ConfigEnum {
    ENDPOINTS {
        override fun getRewardsEndpoint() = System.getenv("REWARDS_ENDPOINT") ?: "http://10.0.2.2:3000/"
    }
}