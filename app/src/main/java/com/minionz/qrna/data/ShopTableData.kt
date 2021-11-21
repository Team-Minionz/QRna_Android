package com.minionz.qrna.data

data class ShopTableData(
    val tableId : Long,
    val tableNumber : Long,
    val maxUser : Int,
    val countUser: Int,
    var useStatus : String
)