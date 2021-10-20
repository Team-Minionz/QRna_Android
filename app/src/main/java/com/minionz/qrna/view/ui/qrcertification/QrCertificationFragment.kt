package com.minionz.qrna.view.ui.qrcertification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.zxing.integration.android.IntentIntegrator
import com.minionz.qrna.R
import com.minionz.qrna.databinding.FragmentQrCertificationBinding

class QrCertificationFragment : Fragment() {

    private lateinit var certificationViewModel: QrCertificationViewModel
    private lateinit var binding : FragmentQrCertificationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_qr_certification,container,false)
        binding.lifecycleOwner = this
        certificationViewModel = ViewModelProvider(this).get(QrCertificationViewModel::class.java)
        binding.viewModel = certificationViewModel

        initQrCodeScan()

        return binding.root
    }

    private fun initQrCodeScan() {

        val integrator = IntentIntegrator(requireActivity())
        integrator.setBeepEnabled(false)
        integrator.setOrientationLocked(true)
        integrator.setPrompt("QR코드를 인증해주세요")
        integrator.initiateScan()

    }
}