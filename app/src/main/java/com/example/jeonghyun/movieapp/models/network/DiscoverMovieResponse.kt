package com.example.jeonghyun.movieapp.models.network

import com.example.jeonghyun.movieapp.models.NetworkResponseModel
import com.example.jeonghyun.movieapp.models.entity.Movie

data class DiscoverMovieResponse(
    val page: Int,
    val results: List<Movie>,
    val total_results: Int,
    val total_pages: Int
) : NetworkResponseModel