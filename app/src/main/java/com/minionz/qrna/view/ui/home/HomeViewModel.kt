package com.minionz.qrna.view.ui.home

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModel
import com.minionz.qrna.data.StoreListData

class HomeViewModel : ViewModel() {

    val storeList = ObservableArrayList<StoreListData>().apply {
        this.add(StoreListData("이름","주소","혼잡도"))
    }

}