package com.minionz.qrna.data

data class ShopDetailInfo(
    val name : String,
    val address : ShopAddress,
    val telNumber : String,
    val tableInfoList : ArrayList<TableInfo>,
    val congestionStatus : String,
    val useUser : Int,
    val maxUser : Int,
    val bookMark : Boolean
)
