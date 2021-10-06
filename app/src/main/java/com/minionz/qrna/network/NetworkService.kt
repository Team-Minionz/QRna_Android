package com.minionz.qrna.network

import com.minionz.qrna.data.*
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
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

    @GET("/api/v1/users/logout/email")
    fun logout() : Call<LogoutResponseData>

    @DELETE("/api/v1/users/withdraw/email")
    fun withdraw(
        email : String
    ) : Call<WithdrawResponseData>
}