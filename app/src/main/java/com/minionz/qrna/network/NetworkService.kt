package com.minionz.qrna.network

import com.minionz.qrna.data.LoginRequestData
import com.minionz.qrna.data.LoginResponseData
import com.minionz.qrna.data.SignUpResponseData
import com.minionz.qrna.data.SignUpRequestData
import retrofit2.Call
import retrofit2.http.POST

interface NetworkService {

    @POST("/api/v1/users/join")
    fun signUp(
        signUpRequestBody : SignUpRequestData
    ) : Call<SignUpResponseData>

    @POST("/api/v1/users/login")
    fun login(
        loginRequestBody : LoginRequestData
    ) : Call<LoginResponseData>
}