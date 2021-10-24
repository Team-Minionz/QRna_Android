package com.minionz.qrna.data

data class ShopRegisterRequestData(
    val name : String,
    val address : AddressInfo,
    val telNumber : String,
    val tableList : List<TableInfoData>
)
