package com.minionz.qrna.network

import com.minionz.qrna.data.*
import retrofit2.Call
import retrofit2.http.*

interface NetworkService {

    @POST("/api/v1/users/join")
    fun userSignUp(
        @Body signUpRequestBody : SignUpRequestData
    ) : Call<DefaultResponseData>

    @POST("/api/v1/owners/join")
    fun ownerSignUp(
        @Body signUpRequestBody : SignUpRequestData
    ) : Call<DefaultResponseData>

    @POST("/api/v1/users/login")
    fun userLogin(
        @Body loginRequestBody : LoginRequestData
    ) : Call<LoginResponseData>

    @POST("/api/v1/owners/login")
    fun ownerLogin(
        @Body loginRequestBody : LoginRequestData
    ) : Call<LoginResponseData>

    @GET("/api/v1/users/logout/{userId}")
    fun userLogout(
        @Path ("userId") id : Long
    ) : Call<DefaultResponseData>

    @GET("/api/v1/owners/logout/{ownerId}")
    fun ownerLogout(
        @Path ("userId") id : Long
    )

    @DELETE("/api/v1/users/withdraw/{userId}")
    fun userWithdraw(
        @Path ("userId") userId : Long
    ) : Call<DefaultResponseData>

    @DELETE("/api/v1/owners/withdraw/{ownerId}")
    fun ownerWithdraw(
        @Path ("userId") userId : Long
    ) : Call<DefaultResponseData>

    @POST("/api/v1/visits")
    fun certification(
        @Body certificationRequestData : QrCertificationRequestData
    ) : Call<DefaultResponseData>

    @POST("/api/v1/shops")
    fun registerShop(
        @Body registerRequestData: ShopRegisterRequestData
    ) : Call<DefaultResponseData>

    @DELETE("/api/v1/shops/{shopId}")
    fun deleteShop(
        @Path ("shopId") shopId : Long
    ) : Call<DefaultResponseData>

    @GET("/api/v1/shops")
    fun inquireShop() : Call<List<StoreListData>>

    @GET("/api/v1/users/page/{userId}")
    fun getUserInfo(
        @Path("userId") userId: Long
    ) : Call<UserInfoData>

    @GET("/api/v1/owners/page/{ownerId}")
    fun getOwnerInfo(
        @Path("userId") userId: Long
    ) : Call<OwnerInfoData>

    @POST("/api/v1/users/bookmark")
    fun addBookMark(
        @Body bookMarkRequestData: AddBookMarkRequestData
    ) : Call<DefaultResponseData>

    @DELETE("/api/v1/users/bookmark/{userId}/{shopId}")
    fun deleteBookMark(
        @Path ("userId") userId : Long,
        @Path ("shopId") shopId : Long
    ) : Call<DefaultResponseData>

    @GET("/api/v1/shops/{shopId}")
    fun inquireTableList(
        @Path ("shopId") shopId: Long
    ) : Call<List<ShopTableData>>

    @GET("/api/v1/shops/search")
    fun searchShop(
        @Query ("keyword") keyword : String
    ) : Call<List<ShopInfoData>>

    @GET("/api/v1/shops/search/region")
    fun regionSearchShop(
        @Query ("region") region : String,
        @Query ("keyword") keyword : String
    ) : Call<List<ShopInfoData>>

    @GET("/api/v1/shops/detail/{shopId}/{userId}")
    fun inquireDetailInfo(
        @Path ("shopId") shopId: Long,
        @Path ("userId") userId: Long
    ) : Call<ShopDetailInfo>

    @GET("/api/v1/shops/near")
    fun nearShopInquire(
        @Query ("sort") sort: String,
        @Query ("latitude") latitude : Double,
        @Query ("longitude") longitude : Double
    ) : Call<List<ShopInfoData>>

    @GET("/api/v1/owners/{ownerId}")
    fun inquireMyShop(
        @Path ("ownerId") ownerId : Long
    ) : Call<List<MyShopInfoData>>

    @GET("/api/v1/tables/tableId")
    fun tableExit(
        @Path ("tableId") tableId : Long
    ) : Call<DefaultResponseData>

    @GET("/api/v1/users/bookmark/{userId}")
    fun inquireBookMark(
        @Path ("userId") userId : Long
    ) : Call<List<ShopInfoData>>
}