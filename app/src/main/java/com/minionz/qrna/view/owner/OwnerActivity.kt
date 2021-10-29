package com.minionz.qrna.view.owner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.minionz.qrna.R
import com.minionz.qrna.databinding.ActivityOwnerBinding

class OwnerActivity : AppCompatActivity() {

    private lateinit var binding : ActivityOwnerBinding
    private lateinit var viewModel : OwnerManageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()
    }

    private fun init() {
        binding = DataBindingUtil.setContentView(this,R.layout.activity_owner)
        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(this).get(OwnerManageViewModel::class.java)
        binding.viewModel = viewModel

        viewModel.storeList.clear()
        viewModel.inquireShop()
    }
}