package com.minionz.qrna.data

import com.google.gson.annotations.SerializedName

data class UserInfoData(
    @SerializedName("nickname")
    val nickName : String,
    val telNumber : String,
    val address : AddressInfo
)