package com.example.skycast.data

//mo phong lai theo api
data class RemoteLocation(
    val name : String,
    val region: String,
    val country: String,
    val lat: Double,
    val lon: Double
)
