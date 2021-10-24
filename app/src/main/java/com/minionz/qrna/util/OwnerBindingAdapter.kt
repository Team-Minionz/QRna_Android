package com.minionz.qrna.util

import android.app.Activity
import android.content.Intent
import android.widget.Button
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.minionz.qrna.data.StoreListData
import com.minionz.qrna.data.TableInfoData
import com.minionz.qrna.view.owner.StoreAdditionActivity

object OwnerBindingAdapter {

    @BindingAdapter("bindItem")
    @JvmStatic
    fun bindItem(recyclerView: RecyclerView, items: ObservableArrayList<StoreListData>) {
        if(recyclerView.adapter == null) {
            val lm = LinearLayoutManager(recyclerView.context)
            val adapter = OwnerStoreListRecyclerAdapter()
            recyclerView.layoutManager = lm
            recyclerView.adapter = adapter
        }
        (recyclerView.adapter as OwnerStoreListRecyclerAdapter).items = items
        recyclerView.adapter?.notifyDataSetChanged()
    }

    @BindingAdapter("addStore")
    @JvmStatic
    fun addStore(button: Button, userId : String?) {
        button.setOnClickListener {
            val intent = Intent(button.context, StoreAdditionActivity::class.java)
            (button.context as Activity).startActivity(intent)
        }
    }

    @BindingAdapter("name","storeNum","tableInfo")
    @JvmStatic
    fun storeRegister(button: Button, name : String?, storeNum : String?, tableInfo : List<TableInfoData>) {
        button.setOnClickListener {



        }
    }
}