package com.example.mpe12.loyaltyrewards.enums

import org.junit.Test
import org.junit.Assert.*

class ChannelTest {
    @Test
    fun sportsEnum() {
        val enum : BaseEnum = Channel.SPORTS
        assertEquals(enum.getTitle(), "Sports")
        assertEquals(enum.getCode(), "SPORTS")
        assertEquals(enum.getDescription(), "Watch the best live coverage of your favourite sports: Football, Golf, Rugby, Cricket, Tennis, F1 and Boxing.")
        assertEquals(enum.getImage(), "https://cdn.footballbloggingawards.co.uk/wp-content/uploads/2018/05/sky-sports-logo-e1513690953801.png")
        assertEquals(enum.hasImage(), true)
    }
    @Test
    fun kidsEnum() {
        val enum : BaseEnum = Channel.KIDS
        assertEquals(enum.getTitle(), "Kids")
        assertEquals(enum.getCode(), "KIDS")
        assertEquals(enum.getDescription(), "Add Kids to our Sky Entertainment pack and keep the children entertained with 11 live channels and over 5,000 episodes on demand.")
        assertEquals(enum.getImage(), "https://dm8eklel4s62k.cloudfront.net/images/sky/large/sky-kids-logo-17032016-1.png")
        assertEquals(enum.hasImage(), true)
    }
    @Test
    fun musicEnum() {
        val enum : BaseEnum = Channel.MUSIC
        assertEquals(enum.getTitle(), "Music")
        assertEquals(enum.getCode(), "MUSIC")
        assertEquals(enum.getDescription(), "Watch all the latest MTV shows, check out all the biggest and best music videos, and read all the breaking celebrity and entertainment news.")
        assertEquals(enum.getImage(), "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Sky_Music_-_Logo_2015.svg/1280px-Sky_Music_-_Logo_2015.svg.png")
        assertEquals(enum.hasImage(), true)
    }
    @Test
    fun newsEnum() {
        val enum : BaseEnum = Channel.NEWS
        assertEquals(enum.getTitle(), "News")
        assertEquals(enum.getCode(), "NEWS")
        assertEquals(enum.getDescription(), "Expert comment and analysis on the latest UK news")
        assertEquals(enum.getImage(), "https://news.sky.com/assets/2018/sky-news-logo.png?bypass-service-worker")
        assertEquals(enum.hasImage(), true)
    }
    @Test
    fun moviesEnum() {
        val enum : BaseEnum = Channel.MOVIES
        assertEquals(enum.getTitle(), "Movies")
        assertEquals(enum.getCode(), "MOVIES")
        assertEquals(enum.getDescription(), "Sky Cinema. Choose from over 1,000 movies on demand in stunning HD.")
        assertEquals(enum.getImage(), "https://dm8eklel4s62k.cloudfront.net/images/sky/large/sky_cinema_on_white.png")
        assertEquals(enum.hasImage(), true)
    }
    @Test
    fun noneEnum() {
        val enum : BaseEnum = Channel.NONE
        assertEquals(enum.getTitle(), "N/A")
        assertEquals(enum.getCode(), "NONE")
        assertEquals(enum.getDescription(), "No Package")
        assertEquals(enum.getImage(), "")
        assertEquals(enum.hasImage(), false)
    }
}
