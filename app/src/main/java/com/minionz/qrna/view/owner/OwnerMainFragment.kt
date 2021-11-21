package com.minionz.qrna.view.owner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.minionz.qrna.R
import com.minionz.qrna.databinding.FragmentOwnerMainBinding

class OwnerMainFragment : Fragment() {

    private lateinit var binding : FragmentOwnerMainBinding
    private lateinit var viewModel : OwnerManageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_owner_main,container,false)
        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(requireActivity()).get(OwnerManageViewModel::class.java)
        binding.viewModel = viewModel

        viewModel.inquireShop()

        return binding.root
    }

}