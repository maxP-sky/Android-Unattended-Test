package com.example.mpe12.loyaltyrewards.enums

import org.junit.Test
import org.junit.Assert.*

class ChannelTest {
    @Test
    fun sportsEnum() {
        val enum : BaseEnum = Channel.SPORTS
        assertEquals( "Sports", enum.getTitle())
        assertEquals( "SPORTS", enum.getCode())
        assertEquals( "Watch the best live coverage of your favourite sports: Football, Golf, Rugby, Cricket, Tennis, F1 and Boxing.", enum.getDescription())
        assertEquals( "https://cdn.footballbloggingawards.co.uk/wp-content/uploads/2018/05/sky-sports-logo-e1513690953801.png", enum.getImage())
        assertEquals( true, enum.hasImage())
    }
    @Test
    fun kidsEnum() {
        val enum : BaseEnum = Channel.KIDS
        assertEquals( "Kids", enum.getTitle())
        assertEquals( "KIDS", enum.getCode())
        assertEquals( "Add Kids to our Sky Entertainment pack and keep the children entertained with 11 live channels and over 5,000 episodes on demand.", enum.getDescription())
        assertEquals( "https://dm8eklel4s62k.cloudfront.net/images/sky/large/sky-kids-logo-17032016-1.png", enum.getImage())
        assertEquals( true, enum.hasImage())
    }
    @Test
    fun musicEnum() {
        val enum : BaseEnum = Channel.MUSIC
        assertEquals( "Music", enum.getTitle())
        assertEquals( "MUSIC", enum.getCode())
        assertEquals( "Watch all the latest MTV shows, check out all the biggest and best music videos, and read all the breaking celebrity and entertainment news.", enum.getDescription())
        assertEquals( "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Sky_Music_-_Logo_2015.svg/1280px-Sky_Music_-_Logo_2015.svg.png", enum.getImage())
        assertEquals( true, enum.hasImage())
    }
    @Test
    fun newsEnum() {
        val enum : BaseEnum = Channel.NEWS
        assertEquals( "News", enum.getTitle())
        assertEquals( "NEWS", enum.getCode())
        assertEquals( "Expert comment and analysis on the latest UK news", enum.getDescription())
        assertEquals( "https://news.sky.com/assets/2018/sky-news-logo.png?bypass-service-worker", enum.getImage())
        assertEquals( true, enum.hasImage())
    }
    @Test
    fun moviesEnum() {
        val enum : BaseEnum = Channel.MOVIES
        assertEquals( "Movies", enum.getTitle())
        assertEquals( "MOVIES", enum.getCode())
        assertEquals( "Sky Cinema. Choose from over 1,000 movies on demand in stunning HD.", enum.getDescription())
        assertEquals( "https://dm8eklel4s62k.cloudfront.net/images/sky/large/sky_cinema_on_white.png", enum.getImage())
        assertEquals( true, enum.hasImage())
    }
    @Test
    fun noneEnum() {
        val enum : BaseEnum = Channel.NONE
        assertEquals( "N/A", enum.getTitle())
        assertEquals( "NONE", enum.getCode())
        assertEquals( "No Package", enum.getDescription())
        assertEquals( "", enum.getImage())
        assertEquals( false, enum.hasImage())
    }
}
