package com.minionz.qrna.util

import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.minionz.qrna.data.ShopInfoData

object SearchBindingAdapter {

    @BindingAdapter("search_list")
    @JvmStatic
    fun setSearchList(recyclerView: RecyclerView, items : ObservableArrayList<ShopInfoData>) {
        if(recyclerView.adapter == null) {
            val lm = LinearLayoutManager(recyclerView.context)
            val adapter = SearchShopListRecyclerAdapter()
            recyclerView.layoutManager = lm
            recyclerView.adapter = adapter
        }
        (recyclerView.adapter as SearchShopListRecyclerAdapter).items = items
        recyclerView.adapter?.notifyDataSetChanged()
    }
}