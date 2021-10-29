package com.minionz.qrna.view.ui.myinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.minionz.qrna.R
import com.minionz.qrna.databinding.FragmentMyInfoBinding

class MyInfoFragment : Fragment() {

    private lateinit var myInfoViewModel: MyInfoViewModel
    private lateinit var binding : FragmentMyInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_my_info,container,false)
        myInfoViewModel = ViewModelProvider(this).get(MyInfoViewModel::class.java)
        binding.lifecycleOwner = this
        binding.viewModel = myInfoViewModel

        myInfoViewModel.getMyInfo()

        return binding.root
    }
}