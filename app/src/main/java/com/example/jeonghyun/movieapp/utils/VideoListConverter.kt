package com.example.jeonghyun.movieapp.utils

import androidx.room.TypeConverter
import com.example.jeonghyun.movieapp.models.Video
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

open class VideoListConverter {
    @TypeConverter
    fun fromString(value: String): List<Video>? {
        val listType = object: TypeToken<List<Video>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<Video>?): String {
        return Gson().toJson(list)
    }
}