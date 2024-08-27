package com.example.skycast.ultils

import android.app.Application
import com.example.skycast.dependency_injection.networkModule
import com.example.skycast.dependency_injection.repositoryModule
import com.example.skycast.dependency_injection.serializerModule
import com.example.skycast.dependency_injection.storageModule
import com.example.skycast.dependency_injection.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class AppConfig : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppConfig)
            modules(listOf(repositoryModule, viewModelModule, serializerModule, storageModule, networkModule))
        }
    }

}