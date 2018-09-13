package com.example.mpe12.loyaltyrewards

import android.content.Intent
import android.os.Bundle

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import android.util.Log
import android.widget.TextView

import com.example.mpe12.loyaltyrewards.adapters.RewardAdapter
import com.example.mpe12.loyaltyrewards.api.Request
import com.example.mpe12.loyaltyrewards.controllers.RewardController
import com.example.mpe12.loyaltyrewards.models.Eligible
import com.example.mpe12.loyaltyrewards.models.Reward
import com.example.mpe12.loyaltyrewards.models.RewardsData
import com.example.mpe12.loyaltyrewards.mutators.RewardIntentMutator
import kotlinx.android.synthetic.main.activity_rewards.*

import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response


class RewardsActivity : AppCompatActivity() {
    private val request: Request = Request()
    private val rewardController: RewardController = RewardController()
    lateinit var adapter: RewardAdapter

    private fun loadRewardsView() {
        // Set Layout Manager for RecyclerView
        setContentView(R.layout.activity_rewards)

        backToHomeButton.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }

        val rewardRecyclerView: RecyclerView = findViewById(R.id.rewardsRecyclerView)
        rewardRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // Set Recycler View Adapter for RewardAdapter
        adapter = RewardAdapter(rewardController.rewards)
        rewardRecyclerView.adapter = adapter

        val accountNumberTextView: TextView = findViewById(R.id.accountNumber)
        accountNumberTextView.text = "Rewards for Account: ${intent.getStringExtra("accountNumber")}"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.loading)

        val (subscriptions, accountNumber) = RewardIntentMutator(intent)

        val callback = createRequestCallback()

        request.getService(callback, subscriptions, accountNumber)
    }

    private fun switchActivity(message : String?) {
        val intent = Intent(this@RewardsActivity, MainActivity::class.java)
        intent.putExtra("REWARDS_ACTIVITY_MESSAGE", message)
        startActivity(intent)
    }

    private fun responseAction(rewards: ArrayList<Reward>?, eligible: Eligible?) {
        if (eligible?.output == "CUSTOMER_ELIGIBLE") {
            rewardController.setRewards(rewards)
            loadRewardsView()
        } else {
            // For every other Eligibility Output than CUSTOMER_INELIGIBLE respond with output.
            val message = when(eligible?.output) {
                "CUSTOMER_INELIGIBLE" -> "Customer is not eligible"
                else -> eligible?.output
            }
            switchActivity(message)
        }
    }

    private fun createRequestCallback() : Callback<RewardsData> {
        return object : Callback<RewardsData> {
            override fun onResponse(call: Call<RewardsData>?, response: Response<RewardsData>?) {
                response?.isSuccessful.let {
                    if (it == true) {
                        val rewards : ArrayList<Reward>? = response?.body()?.rewards
                        val eligible : Eligible? = response?.body()?.eligibility

                        // Respond when rewards is empty and eligibility is present
                        responseAction(rewards, eligible)
                    } else {
                        Log.i("Response Failed", response?.code()?.toString())
                        switchActivity("")
                    }
                }
            }

            override fun onFailure(call: Call<RewardsData>?, t: Throwable?) {
                Log.i("Failure", t.toString())
                switchActivity("")
            }
        }
    }
}
