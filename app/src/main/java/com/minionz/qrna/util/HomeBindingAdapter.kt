package com.minionz.qrna.util

import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.minionz.qrna.data.ShopInfoData
import com.minionz.qrna.data.StoreListData
import com.minionz.qrna.data.VisitShopInfo

object HomeBindingAdapter {

    @BindingAdapter("itemList")
    @JvmStatic
    fun bindItem(recyclerView: RecyclerView, items: ObservableArrayList<ShopInfoData>) {
        if(recyclerView.adapter == null) {
            val lm = LinearLayoutManager(recyclerView.context)
            val adapter = StoreListRecyclerAdapter()
            recyclerView.layoutManager = lm
            recyclerView.adapter = adapter
        }
        (recyclerView.adapter as StoreListRecyclerAdapter).items = items
        recyclerView.adapter?.notifyDataSetChanged()
    }

    @BindingAdapter("visitList")
    @JvmStatic
    fun bindVisitItem(recyclerView: RecyclerView, items: ObservableArrayList<VisitShopInfo>) {
        if(recyclerView.adapter == null) {
            val lm = LinearLayoutManager(recyclerView.context)
            val adapter = VisitInfoRecyclerAdapter()
            recyclerView.layoutManager = lm
            recyclerView.adapter = adapter
        }
        (recyclerView.adapter as VisitInfoRecyclerAdapter).items = items
        recyclerView.adapter?.notifyDataSetChanged()
    }
}