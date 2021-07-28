package com.myapps.simplecaching.ui.restaurants

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.myapps.simplecaching.data.Restaurant
import com.myapps.simplecaching.databinding.RestaurantCustomItemBinding

class RestaurantAdapter : ListAdapter<Restaurant, RestaurantAdapter.ViewHolder>(RestaurantComparator()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            RestaurantCustomItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ViewHolder(private val binding: RestaurantCustomItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Restaurant) {
            binding.apply {
                Glide.with(itemView)
                    .load(item.logo)
                    .into(logoImg)
                nameTxt.text = item.name
                addressTxt.text = item.address
                typeTxt.text = item.type

            }
        }
    }

    class RestaurantComparator() : DiffUtil.ItemCallback<Restaurant>() {
        override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant) =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant) =
            oldItem == newItem
    }
}