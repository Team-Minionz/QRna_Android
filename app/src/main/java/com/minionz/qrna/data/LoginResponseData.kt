package com.minionz.qrna.data

import com.google.gson.annotations.SerializedName

data class LoginResponseData(
    @SerializedName("id")
    val id : Long,
    @SerializedName("message")
    val message : String?
)