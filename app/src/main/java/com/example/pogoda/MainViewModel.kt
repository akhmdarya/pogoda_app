package com.example.pogoda

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pogoda.adapters.WeatherModel

class MainViewModel:ViewModel() {
    val liveDataCurrent= MutableLiveData<WeatherModel>()
   val liveDataList= MutableLiveData<List<WeatherModel>>()
}