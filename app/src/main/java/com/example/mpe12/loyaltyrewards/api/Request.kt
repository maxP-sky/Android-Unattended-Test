package com.example.mpe12.loyaltyrewards.api

import com.example.mpe12.loyaltyrewards.enums.Config
import com.example.mpe12.loyaltyrewards.models.RewardsData

import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Only allow these methods for Request
interface RequestEnum {
    fun getService(callback: Callback<RewardsData>, subscription: String, accountNumber: String) : Unit
    fun getServiceViaTestMode(callback: Callback<RewardsData>, subscription : String, accountNumber : String, testMode : String) : Unit
}

fun createRequestService() : RequestService {
    val endpoint : String = Config.ENDPOINTS.getRewardsEndpoint()
    val retrofit  = Retrofit.Builder().baseUrl(endpoint).addConverterFactory(GsonConverterFactory.create()).build()
    return retrofit.create(RequestService::class.java)
}

class Request : RequestEnum {
    private val service : RequestService = createRequestService()

    override fun getService(callback: Callback<RewardsData>, subscription : String, accountNumber : String) {
        val call = service.getRewards(subscription, accountNumber)
        call.enqueue(callback)
    }
    override fun getServiceViaTestMode(callback: Callback<RewardsData>, subscription : String, accountNumber : String, testMode : String) {
        val call = service.getRewards(subscription, accountNumber, testMode)
        call.enqueue(callback)
    }
}