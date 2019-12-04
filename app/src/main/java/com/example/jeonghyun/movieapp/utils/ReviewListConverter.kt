package com.example.jeonghyun.movieapp.utils

import androidx.room.TypeConverter
import com.example.jeonghyun.movieapp.models.Review
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

open class ReviewListConverter {
    @TypeConverter
    fun fromString(value: String): List<Review>? {
        val listType = object : TypeToken<List<Review>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<Review>?): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}