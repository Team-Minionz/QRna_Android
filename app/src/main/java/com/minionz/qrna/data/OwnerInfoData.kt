package com.minionz.qrna.data

import com.google.gson.annotations.SerializedName

data class OwnerInfoData(
    @SerializedName ("nickname")
    val nickName : String,
    val telNumber : String
)
