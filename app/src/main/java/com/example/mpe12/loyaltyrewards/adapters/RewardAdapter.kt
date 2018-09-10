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
import kotlinx.android.synthetic.main.channel_item.view.*


class RewardAdapter(val rewards : ArrayList<RewardEnum>) : RecyclerView.Adapter<RewardAdapter.RewardViewHolder>(){
    class RewardViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val channelText : TextView = view.channelText
        val descriptionText : TextView = view.descriptionText
        val rewardImage : ImageView = view.channelImageView
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): RewardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.channel_item, parent, false)
        return RewardViewHolder(view)
    }

    override fun onBindViewHolder(holder: RewardViewHolder, position: Int) {
        val reward = rewards[position]

        holder.channelText.text = reward.getCode()
        holder.descriptionText.text = reward.getDescription()

        // Check if image is active
        if (reward.hasImage()) {
            Picasso.get().load(reward.getImage()).into(holder.rewardImage)
        }
    }

    override fun getItemCount(): Int = rewards.size
}