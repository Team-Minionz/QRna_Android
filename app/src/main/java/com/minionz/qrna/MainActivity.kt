package com.minionz.qrna

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.minionz.qrna.databinding.ActivityMainBinding
import com.minionz.qrna.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()
    }

    private fun init() {
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }
}