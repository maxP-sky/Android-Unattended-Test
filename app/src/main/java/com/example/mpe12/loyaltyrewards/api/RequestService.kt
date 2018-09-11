package com.example.mpe12.loyaltyrewards.api

import com.example.mpe12.loyaltyrewards.models.RewardsData
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call

interface RequestService {
    @GET("/rewards")
    fun getRewards(
            @Query("subscriptions") subscriptions: String,
            @Query("accountNumber") accountNumber : String
    ) : Call<RewardsData>
    fun getRewards(
            @Query("subscriptions") subscriptions: String,
            @Query("accountNumber") accountNumber : String,
            @Query("testMode") testMode : String
    ) : Call<RewardsData>
}