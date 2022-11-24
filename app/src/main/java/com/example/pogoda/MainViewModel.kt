package com.example.pogoda

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {
    val liveDataCurrent= MutableLiveData<String>()
    val liveDataString= MutableLiveData<List>()
}