package com.example.jeonghyun.movieapp.di

import com.example.jeonghyun.movieapp.repository.DiscoverRepository
import com.example.jeonghyun.movieapp.repository.MovieRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { DiscoverRepository(get(), get()) }
    single { MovieRepository(get(), get()) }
}