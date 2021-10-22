package com.minionz.qrna.data

data class SignUpRequestData(
    val name : String,
    val email : String,
    val nickName : String,
    val telNumber : String,
    val password : String,
    val address : AddressInfo,
    val role : String
)
data class AddressInfo(
    val zipcode : String,
    val street : String,
    val city : String
)
