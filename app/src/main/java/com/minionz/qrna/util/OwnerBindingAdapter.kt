package com.minionz.qrna.util

import android.app.Activity
import android.content.Intent
import android.widget.Button
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.minionz.qrna.SingleTon
import com.minionz.qrna.data.*
import com.minionz.qrna.network.RetrofitBuilder
import com.minionz.qrna.view.owner.StoreAdditionActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

    @BindingAdapter("bindTable")
    @JvmStatic
    fun bindTable(recyclerView: RecyclerView, items: ObservableArrayList<TableInfoData>) {
        if(recyclerView.adapter == null) {
            val lm = LinearLayoutManager(recyclerView.context)
            val adapter = TableInfoRecyclerAdapter()
            recyclerView.layoutManager = lm
            recyclerView.adapter = adapter
        }
        (recyclerView.adapter as TableInfoRecyclerAdapter).items = items
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

    @BindingAdapter("shopName","storeTelNum","zipCode","street","city","tableList")
    @JvmStatic
    fun storeRegister(button: Button, name : String?, storeTelNum : String?,zipCode : String? ,
                      street : String?, city : String?,tableList : ObservableArrayList<TableInfoData>) {
        button.setOnClickListener {
            val addressInfo = AddressInfo(zipCode.toString(),street.toString(),city.toString())
            val shopBody = ShopRegisterRequestData(SingleTon.prefs.userId,name.toString(),
            addressInfo,storeTelNum.toString(),tableList)

            RetrofitBuilder.networkService.registerShop(shopBody).enqueue(object : Callback<DefaultResponseData>{
                override fun onFailure(call: Call<DefaultResponseData>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<DefaultResponseData>,
                    response: Response<DefaultResponseData>
                ) {
                    if(response.isSuccessful) {
                        Toast.makeText(button.context,"성공적으로 등록되었습니다",Toast.LENGTH_SHORT).show()
                        (button.context as Activity).finish()
                    }
                }
            })


        }
    }
}