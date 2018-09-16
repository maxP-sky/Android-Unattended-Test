package com.example.mpe12.loyaltyrewards.enums

import org.junit.Test
import org.junit.Assert.*

class ActivityMessageTest {
    @Test
    fun rewardsActivity() {
        val enum = ActivityMessage.REWARDS_ACTIVITY
        assertEquals(enum.outputKey(), "REWARDS_ACTIVITY_MESSAGE")
        assertEquals(enum.response(), "")
    }
    @Test
    fun rewardsOutputEligible() {
        val enum = ActivityMessage.REWARDS_OUTPUT_ELIGIBLE
        assertEquals(enum.outputKey(), "CUSTOMER_ELIGIBLE")
        assertEquals(enum.response(), "")
    }
    @Test
    fun rewardsOutputInEligible() {
        val enum = ActivityMessage.REWARDS_OUTPUT_INELIGIBLE
        assertEquals(enum.outputKey(), "CUSTOMER_INELIGIBLE")
        assertEquals(enum.response(), "Customer is not eligible")
    }
}