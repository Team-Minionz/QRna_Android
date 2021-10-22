package com.minionz.qrna.signUp

import android.view.View
import android.widget.AdapterView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel() {

    val signUpName = MutableLiveData<String>()
    val signUpEmail = MutableLiveData<String>()
    val signUpNickName = MutableLiveData<String>()
    val signUpPhone = MutableLiveData<String>()
    val signUpPassword = MutableLiveData<String>()
    val signUpZipCode = MutableLiveData<String>()
    val signUpStreet = MutableLiveData<String>()
    val signUpCity = MutableLiveData<String>()
    val userType = MutableLiveData<String>()

    val userId = MutableLiveData<Int>().apply { value = 1 }

    val spinnerClick = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            when(position) {
                1 -> userType.value = "USER"
                2 -> userType.value = "OWNER"
            }

        }

        override fun onNothingSelected(p0: AdapterView<*>?) {

        }
    }
}