package com.minionz.qrna.network

import com.minionz.qrna.data.SIgnUpResponseData
import com.minionz.qrna.data.SignUpRequestData
import retrofit2.Call
import retrofit2.http.POST

interface NetworkService {

    @POST("/api/v1/users/join")
    fun signUp(
        signUpRequestBody : SignUpRequestData
    ) : Call<SIgnUpResponseData>

}