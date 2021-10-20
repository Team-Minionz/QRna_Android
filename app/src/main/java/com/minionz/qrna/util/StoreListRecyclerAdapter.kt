package com.minionz.qrna.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.minionz.qrna.data.StoreListData
import com.minionz.qrna.databinding.StoreListLayoutBinding

class StoreListRecyclerAdapter : RecyclerView.Adapter<StoreListRecyclerAdapter.ViewHolder>(){
    var items = ArrayList<StoreListData>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = StoreListLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int  = items.size

    override fun onBindViewHolder(holder: StoreListRecyclerAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ViewHolder(private val binding : StoreListLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : StoreListData) {
            binding.item = item
        }
    }
}