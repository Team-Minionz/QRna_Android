package com.minionz.qrna.util

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.minionz.qrna.SingleTon
import com.minionz.qrna.data.AddBookMarkRequestData
import com.minionz.qrna.data.DefaultResponseData
import com.minionz.qrna.data.StoreListData
import com.minionz.qrna.databinding.StoreListLayoutBinding
import com.minionz.qrna.network.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StoreListRecyclerAdapter : RecyclerView.Adapter<StoreListRecyclerAdapter.ViewHolder>(){
    var items = ArrayList<StoreListData>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = StoreListLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int  = items.size

    override fun onBindViewHolder(holder: StoreListRecyclerAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class ViewHolder(private val binding : StoreListLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : StoreListData) {
            binding.item = item

            binding.bookmarkBtn.setOnClickListener {
                if(binding.bookmarkBtn.isSelected) {
                    binding.bookmarkBtn.isSelected = false
                    RetrofitBuilder.networkService.deleteBookMark(SingleTon.prefs.userId,item.shopId).enqueue(
                        object : Callback<DefaultResponseData> {
                            override fun onFailure(call: Call<DefaultResponseData>, t: Throwable) {

                            }

                            override fun onResponse(
                                call: Call<DefaultResponseData>,
                                response: Response<DefaultResponseData>
                            ) {
                                if(response.isSuccessful){
                                    if(response.body()?.message == "즐겨찾기 등록 성공") Toast.makeText(binding.root.context,"즐겨찾기에 등록되었습니다",Toast.LENGTH_SHORT).show()
                               }
                            }
                        }
                    )
                }
                else {
                    binding.bookmarkBtn.isSelected = true
                    val requestData = AddBookMarkRequestData(item.shopId,SingleTon.prefs.userId)
                    RetrofitBuilder.networkService.addBookMark(requestData).enqueue(object : Callback<DefaultResponseData> {
                        override fun onFailure(call: Call<DefaultResponseData>, t: Throwable) {

                        }

                        override fun onResponse(
                            call: Call<DefaultResponseData>,
                            response: Response<DefaultResponseData>
                        ) {
                            if(response.isSuccessful){
                                if(response.body()?.message == "즐겨찾기 삭제 성공") Toast.makeText(binding.root.context,"즐겨찾기에서 삭제되었습니다",Toast.LENGTH_SHORT).show()
                            }
                        }
                    })
                }
            }
        }
    }
}