package com.example.mpe12.loyaltyrewards

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import com.example.mpe12.loyaltyrewards.adapters.RewardAdapter
import com.example.mpe12.loyaltyrewards.api.Request
import com.example.mpe12.loyaltyrewards.controllers.RewardController
import com.example.mpe12.loyaltyrewards.enums.RewardEnum
import com.example.mpe12.loyaltyrewards.models.Reward
import retrofit2.Callback
import com.example.mpe12.loyaltyrewards.models.RewardsData
import retrofit2.Call
import retrofit2.Response

class RewardsActivity : AppCompatActivity() {
    private val request : Request = Request()
    private val rewardController : RewardController = RewardController()
    lateinit var adapter : RewardAdapter
    lateinit var rewardRecyclerView: RecyclerView

    private fun getSubscriptionsViaChannels(channels : ArrayList<String>) : String {
        return channels.joinToString(",")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rewards)

        rewardRecyclerView = findViewById(R.id.rewardsRecyclerView)
        rewardRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        // Set Recycler View Adapter for  RewardAdapter
        adapter = RewardAdapter(rewardController.rewards)
        rewardRecyclerView.adapter = adapter

        // Pull channels Intent from MainActivity
        val stringArray : ArrayList<String> = intent.getStringArrayListExtra("channels")

        // Convert ArrayList to channels Query!!
        val subscriptions = getSubscriptionsViaChannels(stringArray)

        // Pull accountNumber from MainActivity
        val accountNumber = intent.getStringExtra("accountNumber")

        // Create request callback
        val callback : Callback<RewardsData> = createRequestCallback()

        // Call callback
        request.getService(callback, subscriptions, accountNumber)
    }

    private fun createRequestCallback() : Callback<RewardsData> {
        return object : Callback<RewardsData> {
            override fun onResponse(call: Call<RewardsData>?, response: Response<RewardsData>?) {
                response?.isSuccessful.let {
                    val rewards : ArrayList<Reward>? = response?.body()?.rewards
                    Log.i("RewardsActivity", rewards.toString())
                    rewardController.setRewards(rewards)
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<RewardsData>?, t: Throwable?) {
                Log.i("RewardsActivity", t.toString())
            }
        }
    }
}
