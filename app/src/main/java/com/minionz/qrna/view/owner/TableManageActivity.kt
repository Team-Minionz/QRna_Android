package com.minionz.qrna.view.owner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.minionz.qrna.R
import com.minionz.qrna.databinding.ActivityTableManageBinding

class TableManageActivity : AppCompatActivity() {

    private lateinit var binding : ActivityTableManageBinding
    private val viewModel : OwnerManageViewModel by lazy {
        ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                OwnerManageViewModel() as T
        }).get(OwnerManageViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_table_manage)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModel.currentStoreName.value = intent.getStringExtra("name")
        viewModel.inquireShopTable(intent.getLongExtra("id",0))


    }
}