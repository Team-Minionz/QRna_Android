package com.minionz.qrna.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.minionz.qrna.data.TableInfoData
import com.minionz.qrna.databinding.TableInfoLayoutBinding

class TableInfoRecyclerAdapter : RecyclerView.Adapter<TableInfoRecyclerAdapter.ViewHolder>(){
    var items = ArrayList<TableInfoData>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
       val binding = TableInfoLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
       return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TableInfoRecyclerAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(private val binding : TableInfoLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : TableInfoData) {
            binding.item = item
        }
    }
}