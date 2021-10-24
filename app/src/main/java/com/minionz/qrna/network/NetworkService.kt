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
    ) : Call<LoginResponseData>

    @GET("/api/v1/users/logout/{id}/{role}")
    fun logout(
        @Path ("id") id : Int,
        @Path ("role") userType: String
    ) : Call<DefaultResponseData>

    @DELETE("/api/v1/users/withdraw/{id}/{role}")
    fun withdraw(
        @Path ("id") userId : Int,
        @Path ("role") userType : String
    ) : Call<DefaultResponseData>

    @POST("/api/v1/visits")
    fun certification(
        @Body certificationRequestData : QrCertificationRequestData
    ) : Call<DefaultResponseData>

    @POST("/api/v1/shops")
    fun registerShop(
        @Body registerRequestData: ShopRegisterRequestData
    ) : Call<DefaultResponseData>

    @DELETE("/api/v1/shops/{}")
    fun deleteShop(
        @Path ("shopId") shopId : Int
    ) : Call<DefaultResponseData>

    @GET("/api/v1/shops")
    fun inquireShop() : Call<List<StoreListData>>
}