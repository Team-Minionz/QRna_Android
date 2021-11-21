package com.minionz.qrna.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView
import com.minionz.qrna.data.ShopTableData
import com.minionz.qrna.databinding.CurrentUseTableItemLayoutBinding

class CurrentTableInfoRecyclerAdapter : RecyclerView.Adapter<CurrentTableInfoRecyclerAdapter.ViewHolder>() {

    var items = ObservableArrayList<ShopTableData>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
       val binding = CurrentUseTableItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
       return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: CurrentTableInfoRecyclerAdapter.ViewHolder,
        position: Int
    ) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(private val binding : CurrentUseTableItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : ShopTableData) {
            binding.item = item
        }
    }

}