package com.minionz.qrna.signUp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel() {

    val signUpName = MutableLiveData<String>()
    val signUpEmail = MutableLiveData<String>()
    val signUpNickName = MutableLiveData<String>()
    val signUpPhone = MutableLiveData<String>()
    val signUpPassword = MutableLiveData<String>()

    val userId = MutableLiveData<Int>().apply { value = 1 }

}