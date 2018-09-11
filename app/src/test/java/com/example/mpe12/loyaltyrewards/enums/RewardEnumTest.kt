package com.example.mpe12.loyaltyrewards.enums

import org.junit.Test
import org.junit.Assert.*

class RewardEnumTest {
    @Test
    fun championsLeagueEnum() {
        val enum : BaseEnum = RewardEnum.CHAMPIONS_LEAGUE_FINAL_TICKET
        assertEquals(enum.getTitle(), "Champions League Final")
        assertEquals(enum.getCode(), "CHAMPIONS_LEAGUE_FINAL_TICKET")
        assertEquals(enum.getDescription(), "Champions League Final Ticket: Chelsea Vs Manchester United.")
        assertEquals(enum.getImage(), "https://s3.amazonaws.com/spotonit/images/fifa/championsleague.jpg")
        assertEquals(enum.hasImage(), true)
    }
    @Test
    fun karaokeMicrophoneEnum() {
        val enum : BaseEnum = RewardEnum.KARAOKE_PRO_MICROPHONE
        assertEquals(enum.getTitle(), "Karaoke Microphone")
        assertEquals(enum.getCode(), "KARAOKE_PRO_MICROPHONE")
        assertEquals(enum.getDescription(), "Sony 150W microphone with surround sound beats.")
        assertEquals(enum.getImage(), "https://images-na.ssl-images-amazon.com/images/I/81GzTMOKjNL._SX425_.jpg")
        assertEquals(enum.hasImage(), true)
    }
    @Test
    fun piratesOfTheCaribbeanCollectionEnum() {
        val enum : BaseEnum = RewardEnum.PIRATES_OF_THE_CARIBBEAN_COLLECTION
        assertEquals(enum.getTitle(), "Pirates of the Caribbean")
        assertEquals(enum.getCode(), "PIRATES_OF_THE_CARIBBEAN_COLLECTION")
        assertEquals(enum.getDescription(), "Pirates of the Carribean Collection DVD's, are you ready to Shiver me Timbers")
        assertEquals(enum.getImage(), "https://cdn3.movieweb.com/i/article/TfiyNyDRdYmLPJATz2q2Sbtvc78WvN/798:50/Pirates-Of-The-Caribbean-6-Production-Disney-Johnny.jpg")
        assertEquals(enum.hasImage(), true)
    }
    @Test
    fun noneCollection() {
        val enum : BaseEnum = RewardEnum.NONE
        assertEquals(enum.getTitle(), "None")
        assertEquals(enum.getCode(), "NONE")
        assertEquals(enum.getDescription(), "No Deal for this package.")
        assertEquals(enum.getImage(), "")
        assertEquals(enum.hasImage(), false)
    }
}