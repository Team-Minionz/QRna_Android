package com.minionz.qrna.view.owner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.minionz.qrna.R
import com.minionz.qrna.databinding.ActivityStoreAdditionBinding

class StoreAdditionActivity : AppCompatActivity() {

    private lateinit var binding : ActivityStoreAdditionBinding
    private lateinit var viewModel : OwnerManageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()
    }

    private fun init() {
        binding = DataBindingUtil.setContentView(this,R.layout.activity_store_addition)
        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(this).get(OwnerManageViewModel::class.java)
        binding.viewModel = viewModel
    }
}