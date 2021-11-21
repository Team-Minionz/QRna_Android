package com.minionz.qrna.util

import android.app.Activity
import android.widget.Button
import androidx.databinding.BindingAdapter

object MainBindingAdapter {

    @BindingAdapter("setFinish")
    @JvmStatic
    fun setFinish(button: Button, userId : String?) {
        button.setOnClickListener {
            (button.context as Activity).finish()
        }
    }
}