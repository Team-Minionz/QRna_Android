package com.minionz.qrna.util

import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.minionz.qrna.data.ShopInfoData

object BookMarkBindingAdapter {

    @BindingAdapter("bookmark_list")
    @JvmStatic
    fun setBookMarkList(recyclerView: RecyclerView, items : ObservableArrayList<ShopInfoData>) {
        if(recyclerView.adapter == null) {
            val lm = LinearLayoutManager(recyclerView.context)
            val adapter = BookMarkRecyclerAdapter()
            recyclerView.layoutManager = lm
            recyclerView.adapter = adapter
        }
        (recyclerView.adapter as BookMarkRecyclerAdapter).items = items
        recyclerView.adapter?.notifyDataSetChanged()
    }
}