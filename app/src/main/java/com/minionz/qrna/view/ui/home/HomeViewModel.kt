package com.minionz.qrna.view.ui.home

import android.util.Log
import android.widget.Toast
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModel
import com.minionz.qrna.data.StoreListData
import com.minionz.qrna.network.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    var storeList = ObservableArrayList<StoreListData>()

    fun inquireShop() {
        storeList.clear()

        RetrofitBuilder.networkService.inquireShop().enqueue(object :
            Callback<List<StoreListData>> {
            override fun onFailure(call: Call<List<StoreListData>>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<List<StoreListData>>,
                response: Response<List<StoreListData>>
            ) {
                Log.e(",,,",response.body()!!.toString())
                if(response.isSuccessful) {
                    repeat(response.body()!!.size) {
                        storeList.add(response.body()!![it])
                    }
                }
            }
        })
    }
}