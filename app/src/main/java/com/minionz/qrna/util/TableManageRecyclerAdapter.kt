package com.minionz.qrna.util

import android.graphics.Color.red
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.ObservableArrayList
import androidx.recyclerview.widget.RecyclerView
import com.minionz.qrna.R
import com.minionz.qrna.data.DefaultResponseData
import com.minionz.qrna.data.ShopTableData
import com.minionz.qrna.databinding.TableManageItemLayoutBinding
import com.minionz.qrna.network.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TableManageRecyclerAdapter : RecyclerView.Adapter<TableManageRecyclerAdapter.ViewHolder>() {

    var items = ObservableArrayList<ShopTableData>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = TableManageItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: TableManageRecyclerAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(private val binding : TableManageItemLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        @RequiresApi(Build.VERSION_CODES.M)
        fun bind(item : ShopTableData) {
            binding.item = item

            if(item.useStatus == "USING") {
                binding.tableExitBtn.setBackgroundColor(binding.root.resources.getColor(R.color.red,null))
                binding.tableExitBtn.isEnabled = true
                binding.tableExitBtn.setOnClickListener {
                    RetrofitBuilder.networkService.tableExit(item.tableId).enqueue(object : Callback<DefaultResponseData>{
                        override fun onFailure(call: Call<DefaultResponseData>, t: Throwable) {

                        }

                        override fun onResponse(
                            call: Call<DefaultResponseData>,
                            response: Response<DefaultResponseData>
                        ) {
                            item.useStatus = "EMPTY"
                            binding.tableExitBtn.setBackgroundColor(binding.root.resources.getColor(R.color.red,null))
                            binding.tableExitBtn.isEnabled = true
                        }
                    })
                }
            }
            else {
                binding.tableExitBtn.setBackgroundColor(binding.root.resources.getColor(R.color.grey,null))
                binding.tableExitBtn.isEnabled = false
            }
        }
    }
}