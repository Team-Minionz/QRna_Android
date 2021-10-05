package com.minionz.qrna.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val userId = MutableLiveData<String>().apply { this.value = "" }

    val loginId = MutableLiveData<String>()
    val loginPassword = MutableLiveData<String>()

}