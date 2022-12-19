package com.example.pogoda.adapters

data class WeatherModel (
    val city:String,
    val time:String,
    val condition:String,
    val currentTemp:String,
    val imageUrl:String,

    val maxTemp:String,
    val minTemp:String,
    val hours:String
        )