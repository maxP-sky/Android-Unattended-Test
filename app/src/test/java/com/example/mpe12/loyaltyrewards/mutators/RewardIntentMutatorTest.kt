package com.example.mpe12.loyaltyrewards.mutators

import android.content.Intent
import com.example.mpe12.loyaltyrewards.enums.IntentEnum
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mockito.*

class RewardIntentMutatorTest {
    @Test
    fun intentAccountNumberAndChannelsTest() {
        val fakeAccountNumber = "1234567"
        val fakeChannels : ArrayList<String> = ArrayList()

        val channelsEnum = IntentEnum.REWARD_INTENT_CHANNELS.getKey()
        val accountNumberEnum = IntentEnum.REWARD_INTENT_ACCOUNT.getKey()
        val shouldGetDataEnum = IntentEnum.REWARD_INTENT_CHECK.getKey()

        fakeChannels.add("STR1")
        fakeChannels.add("STR2")

        val intent : Intent = mock(Intent::class.java)
        `when`(intent.getStringArrayListExtra(channelsEnum)).thenReturn(fakeChannels)
        `when`(intent.getStringExtra(accountNumberEnum)).thenReturn(fakeAccountNumber)
        `when`(intent.getBooleanExtra(shouldGetDataEnum, false)).thenReturn(true)

        val (channels, accountNumber, shouldGetData) = RewardIntentMutator(intent)

        assertEquals(fakeAccountNumber, accountNumber)
        assertEquals("STR1,STR2", channels)
        assertEquals(true, shouldGetData)
    }
}