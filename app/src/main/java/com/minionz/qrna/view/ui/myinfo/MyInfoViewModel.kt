package com.minionz.qrna.view.ui.myinfo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.minionz.qrna.SingleTon
import com.minionz.qrna.data.UserInfoData
import com.minionz.qrna.network.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyInfoViewModel : ViewModel() {

    val myInfo = MutableLiveData<UserInfoData>()

    fun getMyInfo() {
        RetrofitBuilder.networkService.getMyInfo(SingleTon.prefs.userId,"USER").enqueue(object : Callback<UserInfoData> {
            override fun onFailure(call: Call<UserInfoData>, t: Throwable) {

            }

            override fun onResponse(call: Call<UserInfoData>, response: Response<UserInfoData>) {
                Log.e("??",response.raw().message())
                if(response.isSuccessful) {
                    myInfo.value = response.body()!!
                }
            }
        })

    }

}