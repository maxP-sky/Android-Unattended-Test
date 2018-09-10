package com.example.mpe12.loyaltyrewards.api

import com.example.mpe12.loyaltyrewards.enums.Config
import com.example.mpe12.loyaltyrewards.models.RewardsData
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun createRequestService() : RequestService {
    val endpoint : String = Config.ENDPOINTS.getRewardsEndpoint()
    val retrofit  = Retrofit.Builder().baseUrl(endpoint).addConverterFactory(GsonConverterFactory.create()).build()
    return retrofit.create(RequestService::class.java)
}

class Request {
    private val service : RequestService = createRequestService()

    fun getService(callback: Callback<RewardsData>, subscription : String, accountNumber : String) {
        val call = service.getRewards(subscription, accountNumber)
        call.enqueue(callback)
    }
}