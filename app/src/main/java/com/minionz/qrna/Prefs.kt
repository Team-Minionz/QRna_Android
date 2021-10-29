package com.minionz.qrna

import android.content.Context
import android.content.Context.MODE_PRIVATE

class Prefs (context: Context) {
    private val prefNm = "mPref"
    private val prefs = context.getSharedPreferences(prefNm, MODE_PRIVATE)

    var userId : Long
    get() = prefs.getLong("userId",0)
    set(value) {
        prefs.edit().putLong("userId",value).apply()
    }
}