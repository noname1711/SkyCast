package com.example.skycast.dependency_injection

import com.example.skycast.network.api.WeatherAPI
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module{
    factory { okHttpClient() }
    single { retrofit(okHttpClient = get()) }
    factory { weatherAPI(retrofit = get()) }
}

private fun okHttpClient() = OkHttpClient.Builder()
    .connectTimeout(30, TimeUnit.SECONDS)
    .writeTimeout(30, TimeUnit.SECONDS)
    .readTimeout(30, TimeUnit.SECONDS)
    .retryOnConnectionFailure(false)
    .build()

private fun retrofit(okHttpClient: OkHttpClient) = Retrofit.Builder()
    .client(okHttpClient)
    .baseUrl(WeatherAPI.BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

private fun weatherAPI(retrofit: Retrofit) = retrofit.create(WeatherAPI::class.java)