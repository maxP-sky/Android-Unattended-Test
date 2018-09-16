package com.example.mpe12.loyaltyrewards.enums

import org.junit.Test
import org.junit.Assert.*

class RewardEnumTest {
    @Test
    fun championsLeagueEnum() {
        val enum : BaseEnum = RewardEnum.CHAMPIONS_LEAGUE_FINAL_TICKET
        assertEquals( "Champions League Final", enum.getTitle())
        assertEquals( "CHAMPIONS_LEAGUE_FINAL_TICKET", enum.getCode())
        assertEquals( "Champions League Final Ticket: Chelsea Vs Manchester United.", enum.getDescription())
        assertEquals( "https://s3.amazonaws.com/spotonit/images/fifa/championsleague.jpg", enum.getImage())
        assertEquals( true, enum.hasImage())
    }
    @Test
    fun karaokeMicrophoneEnum() {
        val enum : BaseEnum = RewardEnum.KARAOKE_PRO_MICROPHONE
        assertEquals( "Karaoke Microphone", enum.getTitle())
        assertEquals( "KARAOKE_PRO_MICROPHONE", enum.getCode())
        assertEquals( "Sony 150W microphone with surround sound beats.", enum.getDescription())
        assertEquals( "https://images-na.ssl-images-amazon.com/images/I/81GzTMOKjNL._SX425_.jpg", enum.getImage())
        assertEquals( true, enum.hasImage())
    }
    @Test
    fun piratesOfTheCaribbeanCollectionEnum() {
        val enum : BaseEnum = RewardEnum.PIRATES_OF_THE_CARIBBEAN_COLLECTION
        assertEquals( "Pirates of the Caribbean", enum.getTitle())
        assertEquals( "PIRATES_OF_THE_CARIBBEAN_COLLECTION", enum.getCode())
        assertEquals( "Pirates of the Carribean Collection DVD's, are you ready to Shiver me Timbers", enum.getDescription())
        assertEquals( "https://cdn3.movieweb.com/i/article/TfiyNyDRdYmLPJATz2q2Sbtvc78WvN/798:50/Pirates-Of-The-Caribbean-6-Production-Disney-Johnny.jpg", enum.getImage())
        assertEquals( true, enum.hasImage())
    }
    @Test
    fun noneCollection() {
        val enum : BaseEnum = RewardEnum.NONE
        assertEquals( "No Rewards", enum.getTitle())
        assertEquals( "NONE", enum.getCode())
        assertEquals( "No Rewards with these subscriptions", enum.getDescription())
        assertEquals( "", enum.getImage())
        assertEquals( false, enum.hasImage())
    }
}