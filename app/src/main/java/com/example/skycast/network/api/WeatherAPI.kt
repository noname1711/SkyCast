package com.example.skycast.network.api

import com.example.skycast.data.RemoteLocation
import com.example.skycast.data.RemoteWeatherData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {

    companion object{
        const val BASE_URL = "https://api.weatherapi.com/v1/"
        const val API_KEY = "01137be9e8554d979e9134826241508"
    }
    @GET("search.json")
    suspend fun searchLocation(
        @Query("key") key :String = API_KEY,
        @Query("q")  query: String
    ): Response<List<RemoteLocation>>

    @GET("forecast.json")
    suspend fun getWeatherData(
        @Query("key") key :String = API_KEY,
        @Query("q")  query: String
    ): Response<RemoteWeatherData>

}