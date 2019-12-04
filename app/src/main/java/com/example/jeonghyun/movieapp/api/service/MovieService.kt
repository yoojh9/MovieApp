package com.example.jeonghyun.movieapp.api.service

import com.example.jeonghyun.movieapp.models.network.KeywordListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {

    @GET("/3/movie/{movie_id}/keywords")
    fun fetchKeyword(@Path("movie_id") id:Int): Call<KeywordListResponse>
}