package com.example.mpe12.loyaltyrewards.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.mpe12.loyaltyrewards.R
import com.example.mpe12.loyaltyrewards.enums.RewardEnum
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.reward_item.view.*

class RewardAdapter(private val rewards : ArrayList<RewardEnum>) : RecyclerView.Adapter<RewardAdapter.RewardViewHolder>() {
    class RewardViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val rewardText : TextView = view.rewardText
        val rewardDescription : TextView = view.rewardDescription
        val rewardImage : ImageView = view.rewardImageView
        val rewardCode : TextView = view.rewardCode
    }

    override fun getItemCount(): Int = rewards.size

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): RewardViewHolder {
        return RewardViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.reward_item, parent, false))
    }

    override fun onBindViewHolder(holder: RewardViewHolder, position: Int) {
        val reward = rewards[position]

        holder.rewardText.text = reward.getTitle()
        holder.rewardDescription.text = reward.getDescription()
        holder.rewardCode.text = "REWARD CODE: ${reward.getCode()}"

        // Check if image is active
        if (reward.hasImage()) {
            Picasso.get().load(reward.getImage()).into(holder.rewardImage)
        }
    }
}