package com.uche.userapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uche.userapp.databinding.UserItemBinding
import com.uche.userapp.model.Item

class UserAdapter(var item: List<Item>) : RecyclerView.Adapter<UserAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val binding: UserItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindItem(item: Item) {
            binding.apply {
                tvId.text = item.id.toString()
                tvName.text = item.name
                tvPrice.text = item.price.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = UserItemBinding.inflate(LayoutInflater.from(parent.context))
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bindItem(item[position])
    }

    override fun getItemCount(): Int {
        return item.size
    }
}
