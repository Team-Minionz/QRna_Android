package com.minionz.qrna.data

data class LoginResponseData(
    val userId : Int,
    val message : ResponseMessage
)
data class ResponseMessage(
    val message : String?
)
