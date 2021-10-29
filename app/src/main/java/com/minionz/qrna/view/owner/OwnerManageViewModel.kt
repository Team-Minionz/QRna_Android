package com.minionz.qrna.view.owner

import android.widget.Button
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.minionz.qrna.data.AddressInfo
import com.minionz.qrna.data.StoreListData
import com.minionz.qrna.data.TableInfoData
import com.minionz.qrna.network.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OwnerManageViewModel : ViewModel(){

    val storeList = ObservableArrayList<StoreListData>()
    val currentTableMaxUser = MutableLiveData<String>()
    val tableInfo = ObservableArrayList<TableInfoData>()

    val storeName = MutableLiveData<String>()
    val storeZipCode = MutableLiveData<String>()
    val storeStreet = MutableLiveData<String>()
    val storeCity = MutableLiveData<String>()
    val storeTelNum = MutableLiveData<String>()

    fun inquireShop() {
        storeList.clear()

        RetrofitBuilder.networkService.inquireShop().enqueue(object : Callback<List<StoreListData>> {
            override fun onFailure(call: Call<List<StoreListData>>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<List<StoreListData>>,
                response: Response<List<StoreListData>>
            ) {
                if(response.isSuccessful) {
                    repeat(response.body()!!.size) {
                        storeList.add(response.body()!![it])
                    }
                }
            }
        })
    }

    fun addTable(button: Button,tableMaxUser : String) {
        button.setOnClickListener {
            tableInfo.add(TableInfoData(tableMaxUser.toInt()))
            currentTableMaxUser.value = ""
        }
    }
}