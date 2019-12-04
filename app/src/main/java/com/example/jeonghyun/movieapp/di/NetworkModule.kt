package com.example.jeonghyun.movieapp.di

import com.example.jeonghyun.movieapp.api.RequestInterceptor
import com.example.jeonghyun.movieapp.api.client.DiscoverClient
import com.example.jeonghyun.movieapp.api.client.MovieClient
import com.example.jeonghyun.movieapp.api.service.DiscoverService
import com.example.jeonghyun.movieapp.api.service.MovieService
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    single {
        OkHttpClient.Builder()
            .addInterceptor(RequestInterceptor())
            .addNetworkInterceptor(StethoInterceptor())
            .build()
    }

    single {
        Retrofit.Builder()
            .client(get<OkHttpClient>())
            .baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single{
        get<Retrofit>().create(DiscoverService::class.java)
    }

    single {
        get<Retrofit>().create(MovieService::class.java)
    }

    single { DiscoverClient(get()) }
    single { MovieClient(get())}
}