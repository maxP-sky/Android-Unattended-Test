package com.example.mpe12.loyaltyrewards.enums

interface ChannelInterface {
    fun getCode() : String
    fun getHumanized() : String
    fun getDescription() : String
    fun getImage() : String
    fun hasImage() : Boolean
}

enum class Channel : ChannelInterface {
    SPORTS {
        override fun getCode() = "SPORTS"
        override fun getHumanized() = "Sports"
        override fun getDescription() = "Sports Package"
        override fun getImage() = "https://cdn.footballbloggingawards.co.uk/wp-content/uploads/2018/05/sky-sports-logo-e1513690953801.png"
        override fun hasImage() = true
    },
    KIDS {
        override fun getCode() = "KIDS"
        override fun getHumanized() = "Kids"
        override fun getDescription() = "Kids Package"
        override fun getImage() = "https://dm8eklel4s62k.cloudfront.net/images/sky/large/sky-kids-logo-17032016-1.png"
        override fun hasImage() = true
    },
    MUSIC {
        override fun getCode() = "MUSIC"
        override fun getHumanized() = "Music"
        override fun getDescription() = "Music Package"
        override fun getImage() = "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Sky_Music_-_Logo_2015.svg/1280px-Sky_Music_-_Logo_2015.svg.png"
        override fun hasImage() = true
    },
    NEWS {
        override fun getCode() = "NEWS"
        override fun getHumanized() = "News"
        override fun getDescription() = "News Package"
        override fun getImage() = "https://news.sky.com/assets/2018/sky-news-logo.png?bypass-service-worker"
        override fun hasImage() = true
    },
    MOVIES {
        override fun getCode() = "MOVIES"
        override fun getHumanized() = "Movies"
        override fun getDescription() = "Movies Package"
        override fun getImage() = "https://dm8eklel4s62k.cloudfront.net/images/sky/large/sky_cinema_on_white.png"
        override fun hasImage() = true
    },
    NONE {
        override fun getCode() = "N/A"
        override fun getHumanized() = "N/A"
        override fun getDescription() = "No Package"
        override fun getImage() = ""
        override fun hasImage() = false
    }
}