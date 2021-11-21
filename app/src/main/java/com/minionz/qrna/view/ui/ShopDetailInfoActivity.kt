package com.minionz.qrna.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.minionz.qrna.R
import com.minionz.qrna.databinding.ActivityShopDetailInfoBinding
import com.minionz.qrna.viewModel.MainViewModel

class ShopDetailInfoActivity : AppCompatActivity() {

    private lateinit var binding : ActivityShopDetailInfoBinding
    private lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        binding = DataBindingUtil.setContentView(this,R.layout.activity_shop_detail_info)
        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.viewModel = viewModel

        viewModel.selectShopId.value = intent.getLongExtra("shopId",0)

        viewModel.selectedShopInfo.value = null
        viewModel.getDetailShopInfo()
        viewModel.getTableInfo()

    }
}