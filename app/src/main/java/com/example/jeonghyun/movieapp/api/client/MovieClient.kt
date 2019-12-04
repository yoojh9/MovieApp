package com.example.jeonghyun.movieapp.api.client

import com.example.jeonghyun.movieapp.api.ApiResponse
import com.example.jeonghyun.movieapp.api.async
import com.example.jeonghyun.movieapp.api.service.MovieService
import com.example.jeonghyun.movieapp.models.network.KeywordListResponse

class MovieClient(private val service: MovieService) {

    fun fetchKeywords(
        id: Int,
        onResult: (response: ApiResponse<KeywordListResponse>) -> Unit
    ) {
        this.service.fetchKeyword(id).async(onResult)
    }
}