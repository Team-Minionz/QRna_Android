package com.minionz.qrna.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.minionz.qrna.data.VisitShopInfo
import com.minionz.qrna.databinding.VisitInfoItemLayoutBinding

class VisitInfoRecyclerAdapter : RecyclerView.Adapter<VisitInfoRecyclerAdapter.ViewHolder>() {
    var items = ArrayList<VisitShopInfo>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = VisitInfoItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VisitInfoRecyclerAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(private val binding : VisitInfoItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : VisitShopInfo) {
            binding.item = item
        }
    }
}