package com.minionz.qrna.view.ui.myinfo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyInfoViewModel : ViewModel() {

    val userId = MutableLiveData<Int>().apply { this.value = 0 }

}