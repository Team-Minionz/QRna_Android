package com.minionz.qrna.view.ui.bookmark

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.minionz.qrna.R
import com.minionz.qrna.databinding.FragmentBookMarkBinding

class BookMarkFragment : Fragment() {

    private lateinit var binding : FragmentBookMarkBinding
    private lateinit var viewModel : BookMarkViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_book_mark,container,false)
        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(requireActivity()).get(BookMarkViewModel::class.java)
        binding.viewModel = viewModel

        return binding.root
    }

}