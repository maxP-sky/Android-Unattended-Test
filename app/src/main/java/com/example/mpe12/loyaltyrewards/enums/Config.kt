package com.example.mpe12.loyaltyrewards.enums

import java.lang.System

enum class Config {
    ENDPOINTS {
        override fun getRewardsEndpoint() = System.getenv("REWARDS_ENDPOINT") ?: "http://10.0.2.2:3000/"
    };
    abstract fun getRewardsEndpoint() : String
}