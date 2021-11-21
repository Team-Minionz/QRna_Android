package com.minionz.qrna.util

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.minionz.qrna.data.DefaultResponseData
import com.minionz.qrna.data.MyShopInfoData
import com.minionz.qrna.data.StoreListData
import com.minionz.qrna.databinding.OwnerStoreListLayoutBinding
import com.minionz.qrna.network.RetrofitBuilder
import com.minionz.qrna.view.owner.TableManageActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OwnerStoreListRecyclerAdapter : RecyclerView.Adapter<OwnerStoreListRecyclerAdapter.ViewHolder>(){

    var items = ArrayList<MyShopInfoData>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = OwnerStoreListLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OwnerStoreListRecyclerAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(private val binding : OwnerStoreListLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : MyShopInfoData) {
            binding.item = item

            binding.shopDeleteBtn.setOnClickListener {
                RetrofitBuilder.networkService.deleteShop(item.id).enqueue(object : Callback<DefaultResponseData>{
                    override fun onFailure(call: Call<DefaultResponseData>, t: Throwable) {

                    }

                    override fun onResponse(
                        call: Call<DefaultResponseData>,
                        response: Response<DefaultResponseData>
                    ) {
                        if(response.isSuccessful) {
                            items.remove(item)
                            this@OwnerStoreListRecyclerAdapter.notifyDataSetChanged()
                        }
                    }
                })
            }

            binding.root.setOnClickListener {
                val intent = Intent(it.context,TableManageActivity::class.java)
                intent.putExtra("name",item.name)
                intent.putExtra("id",item.id)
                (it.context as Activity).startActivity(intent)
            }
        }
    }
}