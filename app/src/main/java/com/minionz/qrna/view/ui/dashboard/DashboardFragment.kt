package com.minionz.qrna.view.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.zxing.integration.android.IntentIntegrator
import com.minionz.qrna.R
import com.minionz.qrna.databinding.FragmentDashboardBinding
import com.minionz.qrna.view.qr.QrCodeReaderActivity

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private lateinit var binding : FragmentDashboardBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_dashboard,container,false)
        binding.lifecycleOwner = this
        dashboardViewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)
        binding.viewModel = dashboardViewModel

        binding.qrButton.setOnClickListener {
            val intent = Intent(this.requireActivity(),QrCodeReaderActivity::class.java)
            startActivity(intent)
        }
        return binding.root
    }
}