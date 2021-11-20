package com.minionz.qrna.view.ui.bookmark

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModel
import com.minionz.qrna.SingleTon
import com.minionz.qrna.data.ShopInfoData
import com.minionz.qrna.network.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookMarkViewModel : ViewModel() {

    val bookMarkList = ObservableArrayList<ShopInfoData>()

    fun inquireBookMark() {
        RetrofitBuilder.networkService.inquireBookMark(SingleTon.prefs.userId).enqueue(object : Callback<List<ShopInfoData>>{
            override fun onFailure(call: Call<List<ShopInfoData>>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<List<ShopInfoData>>,
                response: Response<List<ShopInfoData>>
            ) {
                response.body()?.forEach {
                    bookMarkList.add(it)
                }
            }

        })


    }

}