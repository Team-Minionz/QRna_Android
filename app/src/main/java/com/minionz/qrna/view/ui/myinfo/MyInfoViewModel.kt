package com.minionz.qrna.view.ui.myinfo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyInfoViewModel : ViewModel() {

    val userEmail = MutableLiveData<String>().apply { this.value = "" }

}