package com.minionz.qrna.util

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.minionz.qrna.SingleTon
import com.minionz.qrna.data.AddBookMarkRequestData
import com.minionz.qrna.data.DefaultResponseData
import com.minionz.qrna.data.ShopInfoData
import com.minionz.qrna.data.StoreListData
import com.minionz.qrna.databinding.StoreListLayoutBinding
import com.minionz.qrna.network.RetrofitBuilder
import com.minionz.qrna.view.ui.ShopDetailInfoActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StoreListRecyclerAdapter : RecyclerView.Adapter<StoreListRecyclerAdapter.ViewHolder>(){
    var items = ArrayList<ShopInfoData>()

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
        fun bind(item : ShopInfoData) {
            binding.item = item

            binding.root.setOnClickListener {
                val intent = Intent(it.context, ShopDetailInfoActivity::class.java)
                intent.putExtra("shopId",item.id)
                it.context.startActivity(intent)
            }
        }
    }
}