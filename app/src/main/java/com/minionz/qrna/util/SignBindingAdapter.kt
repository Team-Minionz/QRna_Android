package com.minionz.qrna.util

import android.app.Activity
import android.content.Intent
import android.telephony.PhoneNumberFormattingTextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.BindingAdapter
import com.minionz.qrna.data.*
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

    @BindingAdapter(value = ["signUpName","signUpEmail","signUpNickName","signUpPhone","signUpPassword",
                            "signUpZipCode","signUpStreet","signUpCity"],
    requireAll = true)
    @JvmStatic
    fun signUp(button: Button, signUpName : String?, signUpEmail : String?, signUpNickName : String?,
               signUpPhone : String?, signUpPassword : String?, signUpZipCode: String?, signUpStreet : String?,
    signUpCity : String?) {
        button.setOnClickListener {

            val errorMessage = Toast.makeText(button.context,"회원가입에 실패했습니다",Toast.LENGTH_SHORT)

            when {
                signUpName.isNullOrBlank() -> Toast.makeText(button.context,"이름을 입력하세요",Toast.LENGTH_SHORT).show()
                signUpEmail.isNullOrBlank() -> Toast.makeText(button.context,"이메일을 입력하세요",Toast.LENGTH_SHORT).show()
                signUpNickName.isNullOrBlank() -> Toast.makeText(button.context,"닉네임을 입력하세요",Toast.LENGTH_SHORT).show()
                signUpPhone.isNullOrBlank() -> Toast.makeText(button.context,"전화번호를 입력하세요",Toast.LENGTH_SHORT).show()
                signUpPassword.isNullOrBlank() -> Toast.makeText(button.context,"비밀번호를 입력하세요",Toast.LENGTH_SHORT).show()
                signUpZipCode.isNullOrBlank() -> Toast.makeText(button.context,"주소를 입력하세요",Toast.LENGTH_SHORT).show()
                signUpStreet.isNullOrBlank() -> Toast.makeText(button.context,"주소를 입력하세요",Toast.LENGTH_SHORT).show()
                signUpCity.isNullOrBlank() -> Toast.makeText(button.context,"주소를 입력하세요",Toast.LENGTH_SHORT).show()

                else -> {
                    val address = AddressInfo(signUpZipCode.toString(),signUpStreet.toString(),signUpCity.toString())
                    val signUpRequestBody = SignUpRequestData(signUpName.toString(),signUpEmail.toString(),
                        signUpNickName.toString(),signUpPhone.toString(),signUpPassword.toString(),address)


                    RetrofitBuilder.networkService.signUp(signUpRequestBody).enqueue(object : Callback<DefaultResponseData> {
                        override fun onFailure(call: Call<DefaultResponseData>, t: Throwable) {
                            errorMessage.show()
                        }

                        override fun onResponse(
                            call: Call<DefaultResponseData>,
                            response: Response<DefaultResponseData>
                        ) {
                            when(response.code()) {
                                201 -> {
                                    Toast.makeText(button.context,"회원가입에 성공했습니다",Toast.LENGTH_SHORT).show()
                                    (button.context as Activity).finish()
                                }
                                400 -> Toast.makeText(button.context,"중복된 이메일입니다",Toast.LENGTH_SHORT).show()
                                else -> errorMessage.show()
                            }
                        }
                    })
                }

            }

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

            RetrofitBuilder.networkService.login(loginRequestBody).enqueue(object : Callback<DefaultResponseData>{
                override fun onFailure(call: Call<DefaultResponseData>, t: Throwable) {
                    Toast.makeText(button.context,"로그인에 실패했습니다",Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(
                    call: Call<DefaultResponseData>,
                    response: Response<DefaultResponseData>
                ) {

                    when(response.code()) {
                        200 -> {
                            if(response.body()?.message == "로그인 성공") {
                                val intent = Intent(button.context, MainActivity::class.java)
                                button.context.startActivity(intent)
                            }
                        }

                        400 -> Toast.makeText(button.context,"비밀번호가 일치하지 않습니다",Toast.LENGTH_SHORT).show()
                        404 -> Toast.makeText(button.context,"존재하지 않는 이메일입니다",Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }
    }

    @BindingAdapter("logout")
    @JvmStatic
    fun logout(button: Button, userEmail : String?) {
        button.setOnClickListener {
            val errorMessage = Toast.makeText(button.context,"로그아웃에 실패했습니다",Toast.LENGTH_SHORT)

            RetrofitBuilder.networkService.logout("a@a.com").enqueue(object : Callback<DefaultResponseData> {
                override fun onFailure(call: Call<DefaultResponseData>, t: Throwable) {
                    errorMessage.show()
                }

                override fun onResponse(
                    call: Call<DefaultResponseData>,
                    response: Response<DefaultResponseData>
                ) {

                    when(response.code()) {
                        204 -> (button.context as Activity).finish()
                        else -> errorMessage.show()
                    }
                }
            })
        }
    }

    @BindingAdapter("withdraw")
    @JvmStatic
    fun withDraw(button: Button, email : String?) {
        button.setOnClickListener {
            val errorMessage = Toast.makeText(button.context,"탈퇴에 실패했습니다",Toast.LENGTH_SHORT)
            RetrofitBuilder.networkService.withdraw("a@a.com").enqueue(object : Callback<DefaultResponseData> {
                override fun onFailure(call: Call<DefaultResponseData>, t: Throwable) {
                    errorMessage.show()
                }

                override fun onResponse(
                    call: Call<DefaultResponseData>,
                    response: Response<DefaultResponseData>
                ) {

                    when(response.code()) {
                        204 -> {
                            Toast.makeText(button.context,"성공적으로 탈퇴했습니다", Toast.LENGTH_SHORT).show()
                            (button.context as Activity).finish()
                        }
                        else -> errorMessage.show()
                    }
                }
            })
        }
    }
}