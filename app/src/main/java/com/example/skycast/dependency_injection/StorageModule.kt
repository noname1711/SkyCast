package com.example.skycast.dependency_injection

import com.example.skycast.storage.SharedPreferencesManager
import org.koin.dsl.module

val storageModule = module{
    single { SharedPreferencesManager(context = get(), gson = get())}
}