package com.minionz.qrna.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.minionz.qrna.data.ShopInfoData
import com.minionz.qrna.databinding.BookMarkItemListLayoutBinding

class SearchShopListRecyclerAdapter : RecyclerView.Adapter<SearchShopListRecyclerAdapter.ViewHolder>() {

    var items = ArrayList<ShopInfoData>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
       val binding = BookMarkItemListLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
       return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchShopListRecyclerAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(private val binding : BookMarkItemListLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : ShopInfoData) {
            binding.item = item
        }
    }
}