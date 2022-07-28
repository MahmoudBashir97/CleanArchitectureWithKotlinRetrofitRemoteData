package com.mahmoud_bashir.cleanarchitecturewithkotlinretrofit

import android.app.Application
import com.mahmoud_bashir.cleanarchitecturewithkotlinretrofit.data.di.dataModule
import com.mahmoud_bashir.cleanarchitecturewithkotlinretrofit.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp:Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApp)
            modules(listOf(dataModule, appModule))
        }
    }
}