package com.example.mpe12.loyaltyrewards.enums

enum class ActivityMessage {
    REWARDS_ACTIVITY {
        override fun outputKey() = "REWARDS_ACTIVITY_MESSAGE"
        override fun response() = ""
    },
    REWARDS_OUTPUT_ELIGIBLE {
        override fun outputKey() = "CUSTOMER_ELIGIBLE"
        override fun response() = ""
    },
    REWARDS_OUTPUT_INELIGIBLE {
        override fun outputKey() = "CUSTOMER_INELIGIBLE"
        override fun response() = "Customer is not eligible"
    };

    abstract fun outputKey() : String
    abstract fun response() : String
}