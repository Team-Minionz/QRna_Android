package com.minionz.qrna.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.minionz.qrna.data.StoreListData
import com.minionz.qrna.databinding.OwnerStoreListLayoutBinding

class OwnerStoreListRecyclerAdapter : RecyclerView.Adapter<OwnerStoreListRecyclerAdapter.ViewHolder>(){

    var items = ArrayList<StoreListData>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = OwnerStoreListLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OwnerStoreListRecyclerAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(private val binding : OwnerStoreListLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : StoreListData) {
            binding.item = item
        }
    }
}