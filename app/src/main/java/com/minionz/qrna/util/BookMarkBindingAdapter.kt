package com.minionz.qrna.util

import android.util.Log
import android.widget.ImageButton
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.minionz.qrna.R
import com.minionz.qrna.SingleTon
import com.minionz.qrna.data.AddBookMarkRequestData
import com.minionz.qrna.data.DefaultResponseData
import com.minionz.qrna.data.ShopInfoData
import com.minionz.qrna.network.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

    @BindingAdapter("is_bookmarked","shopId")
    @JvmStatic
    fun setBookMark(imageView: ImageButton, isBookMarked : Boolean, shopId : Long?) {
        val retrofit = RetrofitBuilder
        val requestData = AddBookMarkRequestData(shopId!!, SingleTon.prefs.userId)

        imageView.apply {
            if (isBookMarked) {
                this.setImageDrawable(this.resources.getDrawable(R.drawable.ic_favorite_fill_24,null))
                setOnClickListener {
                    retrofit.networkService.deleteBookMark(SingleTon.prefs.userId,shopId).enqueue(object : Callback<DefaultResponseData>{
                        override fun onFailure(call: Call<DefaultResponseData>, t: Throwable) {

                        }

                        override fun onResponse(
                            call: Call<DefaultResponseData>,
                            response: Response<DefaultResponseData>
                        ) {
                            setImageDrawable(resources.getDrawable(R.drawable.ic_favorite_24,null))
                        }
                    })
                }
            }
            else {
                this.setImageDrawable(this.resources.getDrawable(R.drawable.ic_favorite_24,null))
                setOnClickListener {
                    retrofit.networkService.addBookMark(requestData).enqueue(object : Callback<DefaultResponseData>{
                        override fun onFailure(call: Call<DefaultResponseData>, t: Throwable) {

                        }

                        override fun onResponse(
                            call: Call<DefaultResponseData>,
                            response: Response<DefaultResponseData>
                        ) {
                            setImageDrawable(resources.getDrawable(R.drawable.ic_favorite_fill_24,null))

                        }

                    })
                }
            }
        }
    }
}