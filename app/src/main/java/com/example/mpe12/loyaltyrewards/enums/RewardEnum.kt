package com.example.mpe12.loyaltyrewards.enums

enum class RewardEnum : BaseEnum {
    CHAMPIONS_LEAGUE_FINAL_TICKET {
        override fun getTitle() = "Champions League Final"
        override fun getCode() = "CHAMPIONS_LEAGUE_FINAL_TICKET"
        override fun getDescription() = "Champions League Final Ticket: Chelsea Vs Manchester United."
        override fun getImage() = "https://s3.amazonaws.com/spotonit/images/fifa/championsleague.jpg"
        override fun hasImage() = true
    },
    KARAOKE_PRO_MICROPHONE {
        override fun getTitle() = "Karaoke Microphone"
        override fun getCode() = "KARAOKE_PRO_MICROPHONE"
        override fun getDescription() = "Sony 150W microphone with surround sound beats."
        override fun getImage() = "https://images-na.ssl-images-amazon.com/images/I/81GzTMOKjNL._SX425_.jpg"
        override fun hasImage() = true
    },
    PIRATES_OF_THE_CARIBBEAN_COLLECTION {
        override fun getTitle() = "Pirates of the Caribbean"
        override fun getCode() = "PIRATES_OF_THE_CARIBBEAN_COLLECTION"
        override fun getDescription() = "Pirates of the Carribean Collection DVD's, are you ready to Shiver me Timbers"
        override fun getImage() = "https://cdn3.movieweb.com/i/article/TfiyNyDRdYmLPJATz2q2Sbtvc78WvN/798:50/Pirates-Of-The-Caribbean-6-Production-Disney-Johnny.jpg"
        override fun hasImage() = true
    },
    NONE {
        override fun getTitle() = "None"
        override fun getCode() = "NONE"
        override fun getDescription() = "No Deal for this package."
        override fun getImage() = ""
        override fun hasImage() = false
    },
}