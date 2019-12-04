package com.example.jeonghyun.movieapp.api.service

import com.example.jeonghyun.movieapp.models.network.DiscoverMovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface DiscoverService {

    @GET("/3/discover/movie?language=en&sort_by=popularity.desc")
    fun fetchDiscoverMovie(@Query("page") page: Int): Call<DiscoverMovieResponse>
}