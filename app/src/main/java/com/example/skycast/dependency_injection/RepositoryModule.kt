package com.example.skycast.dependency_injection

import com.example.skycast.network.repository.WeatherDataRepository
import org.koin.dsl.module

val repositoryModule = module{
    single{
        WeatherDataRepository( weatherAPI = get() )
    }
}