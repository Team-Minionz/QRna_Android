package com.minionz.qrna.data

data class ShopInfoData(
    val id : Long,
    val name : String,
    val address : ShopAddress,
    val congestionStatus : String,
    val numberOfTables : Int,
    val useTables : Int
)