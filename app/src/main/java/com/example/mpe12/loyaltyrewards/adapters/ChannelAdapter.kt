package com.example.mpe12.loyaltyrewards.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.mpe12.loyaltyrewards.R
import com.example.mpe12.loyaltyrewards.enums.Channel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.channel_item.view.*

class ChannelAdapter(private val channels : ArrayList<Channel>) : RecyclerView.Adapter<ChannelAdapter.ChannelViewHolder>(){
    class ChannelViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val channelText : TextView = view.channelText
        val descriptionText : TextView = view.channelDescription
        val channelImage : ImageView = view.channelImageView
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ChannelViewHolder {
        return ChannelViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.channel_item, parent, false))
    }

    override fun onBindViewHolder(holder: ChannelViewHolder, position: Int) {
        val channel = channels[position]

        holder.channelText.text = channel.getTitle()
        holder.descriptionText.text = channel.getDescription()

        if (channel.hasImage()) {
            Picasso.get().load(channel.getImage()).into(holder.channelImage)
        }
    }

    override fun getItemCount(): Int = channels.size
}