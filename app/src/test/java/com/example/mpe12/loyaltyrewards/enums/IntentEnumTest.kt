package com.example.mpe12.loyaltyrewards.enums

import org.junit.Test
import org.junit.Assert.*

class IntentEnumTest {
    @Test
    fun channel() {
        val enum = IntentEnum.REWARD_INTENT_CHANNELS
        assertEquals("channels", enum.getKey())
    }
    @Test
    fun accountNumber() {
        val enum = IntentEnum.REWARD_INTENT_ACCOUNT
        assertEquals("accountNumber", enum.getKey())
    }
    @Test
    fun shouldGetData() {
        val enum = IntentEnum.REWARD_INTENT_CHECK
        assertEquals("shouldGetData", enum.getKey())
    }
}