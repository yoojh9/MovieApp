package com.example.jeonghyun.movieapp

import android.app.Application
import com.example.jeonghyun.movieapp.di.networkModule
import com.example.jeonghyun.movieapp.di.repositoryModule
import com.example.jeonghyun.movieapp.di.roomModule
import com.example.jeonghyun.movieapp.di.viewModelModule
import com.facebook.stetho.Stetho
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class MoviesApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MoviesApplication)
            modules(networkModule)
            modules(roomModule)
            modules(repositoryModule)
            modules(viewModelModule)

        }

        // Timber 초기화 (debug용)
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }

        // Stetho 초기화
        Stetho.initializeWithDefaults(this)
    }


}