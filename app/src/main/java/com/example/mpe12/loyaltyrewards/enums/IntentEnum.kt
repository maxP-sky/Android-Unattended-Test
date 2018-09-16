package com.example.mpe12.loyaltyrewards.enums

enum class IntentEnum {
    REWARD_INTENT_CHANNELS {
        override fun getKey() = "channels"
    },
    REWARD_INTENT_ACCOUNT {
        override fun getKey() = "accountNumber"
    },
    REWARD_INTENT_CHECK {
        override fun getKey() = "shouldGetData"
    };

    abstract fun getKey() : String
}