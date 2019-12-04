package com.example.jeonghyun.movieapp.repository

import com.example.jeonghyun.movieapp.api.client.MovieClient
import com.example.jeonghyun.movieapp.room.MovieDao
import timber.log.Timber

class MovieRepository constructor(
    private val movieClient: MovieClient,
    private val movieDao: MovieDao
) : Repository {
    init {
        Timber.d("Injection MovieRepository")
    }
}