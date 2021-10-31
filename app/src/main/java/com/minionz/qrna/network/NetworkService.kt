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
        @Path ("id") id : Long,
        @Path ("role") userType: String
    ) : Call<DefaultResponseData>

    @DELETE("/api/v1/users/withdraw/{id}/{role}")
    fun withdraw(
        @Path ("id") userId : Long,
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

    @DELETE("/api/v1/shops/{id}")
    fun deleteShop(
        @Path ("shopId") shopId : Long
    ) : Call<DefaultResponseData>

    @GET("/api/v1/shops")
    fun inquireShop() : Call<List<StoreListData>>

    @GET("/api/v1/users/page/{id}/{role}")
    fun getMyInfo(
        @Path("id") userId: Long,
        @Path("role") userType: String
    ) : Call<UserInfoData>

    @POST("/api/v1/users/bookmark")
    fun addBookMark(
        @Body bookMarkRequestData: AddBookMarkRequestData
    ) : Call<DefaultResponseData>

    @DELETE("/api/v1/users/bookmark/{userId}/{shopId}")
    fun deleteBookMark(
        @Path ("userId") userId : Long,
        @Path ("shopId") shopId : Long
    ) : Call<DefaultResponseData>
}