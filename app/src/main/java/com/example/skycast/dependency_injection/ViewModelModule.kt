package com.example.skycast.dependency_injection

import com.example.skycast.fragments.home.HomeViewModel
import com.example.skycast.fragments.location.LocationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module{
    viewModel{
        HomeViewModel(weatherDataRepository = get())
    }
    viewModel{
        LocationViewModel(weatherDataRepository = get())
    }
}