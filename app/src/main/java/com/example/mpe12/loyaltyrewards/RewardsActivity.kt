package com.example.mpe12.loyaltyrewards

import android.os.Bundle

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import android.util.Log

import com.example.mpe12.loyaltyrewards.adapters.RewardAdapter
import com.example.mpe12.loyaltyrewards.api.Request
import com.example.mpe12.loyaltyrewards.controllers.RewardController
import com.example.mpe12.loyaltyrewards.models.Reward
import com.example.mpe12.loyaltyrewards.models.RewardsData
import com.example.mpe12.loyaltyrewards.mutators.RewardIntentMutator

import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response

class RewardsActivity : AppCompatActivity() {
    private val request : Request = Request()
    private val rewardController : RewardController = RewardController()
    lateinit var adapter : RewardAdapter

    private fun loadRewardsView() {
        // Set Layout Manager for RecyclerView
        setContentView(R.layout.activity_rewards)

        val rewardRecyclerView : RecyclerView = findViewById(R.id.rewardsRecyclerView)
        rewardRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // Set Recycler View Adapter for RewardAdapter
        adapter = RewardAdapter(rewardController.rewards)
        rewardRecyclerView.adapter = adapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loading)

        val (subscriptions, accountNumber) = RewardIntentMutator(intent)

        val callback = createRequestCallback()

        request.getService(callback, subscriptions, accountNumber)
    }

    private fun createRequestCallback() : Callback<RewardsData> {
        return object : Callback<RewardsData> {
            override fun onResponse(call: Call<RewardsData>?, response: Response<RewardsData>?) {
                response?.isSuccessful.let {
                    if (it == true) {
                        val rewards : ArrayList<Reward>? = response?.body()?.rewards
                        rewardController.setRewards(rewards)
                        loadRewardsView()
                    } else {
                        Log.i("Response Failed", response?.code()?.toString())
                    }
                }
            }

            override fun onFailure(call: Call<RewardsData>?, t: Throwable?) {
                Log.i("Failure", t.toString())
            }
        }
    }
}
