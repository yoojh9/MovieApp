package com.example.jeonghyun.movieapp.di

import androidx.room.Room
import com.example.jeonghyun.movieapp.room.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val roomModule = module {
    single {
        Room.databaseBuilder(androidApplication(), AppDatabase::class.java, "TheMovies.db")
            .allowMainThreadQueries()
            .build()
    }

    single { get<AppDatabase>().movieDao() }

}
