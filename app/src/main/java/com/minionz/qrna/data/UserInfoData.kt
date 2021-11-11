package com.minionz.qrna.data

import com.google.gson.annotations.SerializedName

data class UserInfoData(
    @SerializedName("nickname")
    val nickName : String,
    val telNumber : String,
    val address : AddressInfo,
    val userVisitResponseList : ArrayList<VisitShopInfo>
)
data class VisitShopInfo(
    val shopName : String,
    val shopAddress : ShopAddress,
    val shopTelNumber : String,
    val visitedDate : String
)
data class ShopAddress(
    val street : String,
    val city : String
)