package com.example.jeonghyun.movieapp.api.client

import com.example.jeonghyun.movieapp.api.ApiResponse
import com.example.jeonghyun.movieapp.api.async
import com.example.jeonghyun.movieapp.api.service.DiscoverService
import com.example.jeonghyun.movieapp.models.network.DiscoverMovieResponse

class DiscoverClient(private val service: DiscoverService) {

    fun fetchDiscoverMovie(
        page: Int,
        onResult: (response: ApiResponse<DiscoverMovieResponse>) -> Unit
    ){
        this.service.fetchDiscoverMovie(page).async(onResult)
    }
}