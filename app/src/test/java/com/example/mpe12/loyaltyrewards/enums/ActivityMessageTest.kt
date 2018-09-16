package com.example.mpe12.loyaltyrewards.enums

import org.junit.Test
import org.junit.Assert.*

class ActivityMessageTest {
    @Test
    fun rewardsActivity() {
        val enum = ActivityMessage.REWARDS_ACTIVITY
        assertEquals("REWARDS_ACTIVITY_MESSAGE", enum.outputKey())
        assertEquals( "", enum.response())
    }
    @Test
    fun rewardsOutputEligible() {
        val enum = ActivityMessage.REWARDS_OUTPUT_ELIGIBLE
        assertEquals("CUSTOMER_ELIGIBLE", enum.outputKey())
        assertEquals("", enum.response())
    }
    @Test
    fun rewardsOutputInEligible() {
        val enum = ActivityMessage.REWARDS_OUTPUT_INELIGIBLE
        assertEquals("CUSTOMER_INELIGIBLE", enum.outputKey())
        assertEquals("Customer is not eligible", enum.response())
    }
}