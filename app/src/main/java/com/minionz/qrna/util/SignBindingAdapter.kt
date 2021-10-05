package com.minionz.qrna.util

import android.app.Activity
import android.content.Intent
import android.telephony.PhoneNumberFormattingTextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.BindingAdapter
import com.minionz.qrna.data.LoginRequestData
import com.minionz.qrna.data.LoginResponseData
import com.minionz.qrna.data.SignUpResponseData
import com.minionz.qrna.data.SignUpRequestData
import com.minionz.qrna.network.RetrofitBuilder
import com.minionz.qrna.signUp.SignUpActivity
import com.minionz.qrna.view.MainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object SignBindingAdapter {

    @BindingAdapter("signUp")
    @JvmStatic
    fun signUpActivity(button: Button, userId : String?) {
        button.setOnClickListener {
            val intent = Intent(button.context,SignUpActivity::class.java)
            button.context.startActivity(intent)
        }
    }

    @BindingAdapter("phoneEdit")
    @JvmStatic
    fun phoneEdit(editText: EditText, phone : String?) {
        editText.addTextChangedListener(PhoneNumberFormattingTextWatcher())
    }

    @BindingAdapter(value = ["signUpName","signUpEmail","signUpNickName","signUpPhone","signUpPassword"],
    requireAll = true)
    @JvmStatic
    fun signUp(button: Button, signUpName : String?, signUpEmail : String?, signUpNickName : String?,
               signUpPhone : String?, signUpPassword : String?) {
        button.setOnClickListener {

            Log.e("???",signUpPhone.toString())

            val errorMessage = Toast.makeText(button.context,"회원가입에 실패했습니다",Toast.LENGTH_SHORT)
            val signUpRequestBody = SignUpRequestData(signUpName.toString(),signUpEmail.toString(),
            signUpNickName.toString(),signUpPhone.toString(),signUpPassword.toString())

            RetrofitBuilder.networkService.signUp(signUpRequestBody).enqueue(object : Callback<SignUpResponseData> {
                override fun onFailure(call: Call<SignUpResponseData>, t: Throwable) {
                    errorMessage.show()
                }

                override fun onResponse(
                    call: Call<SignUpResponseData>,
                    response: Response<SignUpResponseData>
                ) {
                    val res = response.body()

                    when(res?.statusCode) {
                        0 -> {
                            Toast.makeText(button.context,"회원가입에 성공했습니다",Toast.LENGTH_SHORT).show()
                            (button.context as Activity).finish()
                        }
                        else -> errorMessage.show()
                    }

                }
            })
        }
    }

    @BindingAdapter("signUpCancel")
    @JvmStatic
    fun signUpCancel(button: Button, userId : Int) {
        button.setOnClickListener { (button.context as Activity).finish() }
    }

    @BindingAdapter("loginId","loginPw")
    @JvmStatic
    fun login(button: Button, loginId : String?, loginPassword : String?) {
        button.setOnClickListener {
            val loginRequestBody = LoginRequestData(loginId.toString(),loginPassword.toString())

            RetrofitBuilder.networkService.login(loginRequestBody).enqueue(object : Callback<LoginResponseData>{
                override fun onFailure(call: Call<LoginResponseData>, t: Throwable) {
                    Toast.makeText(button.context,"로그인에 실패했습니다",Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<LoginResponseData>,
                    response: Response<LoginResponseData>
                ) {
                    val res = response.body()!!
                    if(res.statusCode == 200) {
                        val intent = Intent(button.context,MainActivity::class.java)
                        button.context.startActivity(intent)
                    }
                }
            })
        }
    }
}