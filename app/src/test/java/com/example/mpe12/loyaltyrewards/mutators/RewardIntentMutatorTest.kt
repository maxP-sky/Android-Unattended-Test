package com.example.mpe12.loyaltyrewards.mutators

import android.content.Intent
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mockito.*

class RewardIntentMutatorTest {
    @Test
    fun intentAccountNumberAndChannelsTest() {
        // fake data
        val fakeAccountNumber : String = "1234567"
        val fakeChannels : ArrayList<String> = ArrayList()

        fakeChannels.add("STR1")
        fakeChannels.add("STR2")

        val intent : Intent = mock(Intent::class.java)
        `when`(intent.getStringArrayListExtra("channels")).thenReturn(fakeChannels)
        `when`(intent.getStringExtra("accountNumber")).thenReturn(fakeAccountNumber)
        `when`(intent.getBooleanExtra("shouldGetData", false)).thenReturn(true)

        val (channels, accountNumber, shouldGetData) = RewardIntentMutator(intent)
        assertEquals(accountNumber, fakeAccountNumber)
        assertEquals(channels, "STR1,STR2")
        assertEquals(shouldGetData, true)
    }
}