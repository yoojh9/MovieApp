package com.example.jeonghyun.movieapp.models.network

import com.example.jeonghyun.movieapp.models.Keyword
import com.example.jeonghyun.movieapp.models.NetworkResponseModel

data class KeywordListResponse(
    val id: Int,
    val keywords: List<Keyword>
): NetworkResponseModel