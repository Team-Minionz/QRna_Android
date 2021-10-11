package com.minionz.qrna.network

import com.minionz.qrna.data.*
import retrofit2.Call
import retrofit2.http.*

interface NetworkService {

    @POST("/api/v1/users/join")
    fun signUp(
        @Body signUpRequestBody : SignUpRequestData
    ) : Call<DefaultResponseData>

    @POST("/api/v1/users/login")
    fun login(
        @Body loginRequestBody : LoginRequestData
    ) : Call<DefaultResponseData>

    @GET("/api/v1/users/logout/{email}")
    fun logout(
        @Path ("email") email : String
    ) : Call<DefaultResponseData>

    @DELETE("/api/v1/users/withdraw/{email}")
    fun withdraw(
        @Path ("email") email : String
    ) : Call<DefaultResponseData>

    @POST("/api/v1/visits")
    fun certification(
        @Body certificationRequestData : QrCertificationRequestData
    ) : Call<DefaultResponseData>
}