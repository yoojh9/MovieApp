package com.example.jeonghyun.movieapp.utils

import androidx.room.TypeConverter
import com.example.jeonghyun.movieapp.models.Keyword
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

open class KeywordListConverter {
    @TypeConverter
    fun fromString(value: String): List<Keyword> ? {
        val listType = object: TypeToken<List<Keyword>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromList(list: List<Keyword>?): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}