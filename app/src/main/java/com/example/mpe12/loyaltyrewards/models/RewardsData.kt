package com.example.mpe12.loyaltyrewards.models

import java.io.Serializable

data class RewardsData(val rewards: ArrayList<Reward>, val error : String) : Serializable {
}