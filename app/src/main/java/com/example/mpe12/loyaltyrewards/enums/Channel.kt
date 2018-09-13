package com.example.mpe12.loyaltyrewards.enums

enum class Channel : BaseEnum {
    SPORTS {
        override fun getTitle() = "Sports"
        override fun getCode() = "SPORTS"
        override fun getDescription() = "Watch the best live coverage of your favourite sports: Football, Golf, Rugby, Cricket, Tennis, F1 and Boxing."
        override fun getImage() = "https://cdn.footballbloggingawards.co.uk/wp-content/uploads/2018/05/sky-sports-logo-e1513690953801.png"
        override fun hasImage() = true
    },
    KIDS {
        override fun getTitle() = "Kids"
        override fun getCode() = "KIDS"
        override fun getDescription() = "Add Kids to our Sky Entertainment pack and keep the children entertained with 11 live channels and over 5,000 episodes on demand."
        override fun getImage() = "https://dm8eklel4s62k.cloudfront.net/images/sky/large/sky-kids-logo-17032016-1.png"
        override fun hasImage() = true
    },
    MUSIC {
        override fun getTitle() = "Music"
        override fun getCode() = "MUSIC"
        override fun getDescription() = "Watch all the latest MTV shows, check out all the biggest and best music videos, and read all the breaking celebrity and entertainment news."
        override fun getImage() = "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Sky_Music_-_Logo_2015.svg/1280px-Sky_Music_-_Logo_2015.svg.png"
        override fun hasImage() = true
    },
    NEWS {
        override fun getTitle() = "News"
        override fun getCode() = "NEWS"
        override fun getDescription() = "Expert comment and analysis on the latest UK news"
        override fun getImage() = "https://news.sky.com/assets/2018/sky-news-logo.png?bypass-service-worker"
        override fun hasImage() = true
    },
    MOVIES {
        override fun getTitle() = "Movies"
        override fun getCode() = "MOVIES"
        override fun getDescription() = "Sky Cinema. Choose from over 1,000 movies on demand in stunning HD."
        override fun getImage() = "https://dm8eklel4s62k.cloudfront.net/images/sky/large/sky_cinema_on_white.png"
        override fun hasImage() = true
    },
    NONE {
        override fun getTitle() = "N/A"
        override fun getCode() = "NONE"
        override fun getDescription() = "No Package"
        override fun getImage() = ""
        override fun hasImage() = false
    }
}