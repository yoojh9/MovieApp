package com.example.jeonghyun.movieapp.api

import com.example.jeonghyun.movieapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

internal class RequestInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originUrl = originalRequest.url
        val url = originUrl.newBuilder()
            .addQueryParameter("api_key", BuildConfig.TMDB_API_KEY)
            .build()

        val requestBuilder = originalRequest.newBuilder().url(url)
        val request = requestBuilder.build()
        return chain.proceed(request)
    }

}