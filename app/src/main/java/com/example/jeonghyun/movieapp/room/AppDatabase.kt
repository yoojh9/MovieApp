package com.example.jeonghyun.movieapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.jeonghyun.movieapp.models.entity.Movie
import com.example.jeonghyun.movieapp.utils.*

@Database(entities = [(Movie::class)], version = 3, exportSchema = false)
@TypeConverters(value=[(StringListConverter::class), (IntegerListConverter::class),
    (KeywordListConverter::class), (VideoListConverter::class), (ReviewListConverter::class)])
abstract class AppDatabase: RoomDatabase() {
    abstract fun movieDao(): MovieDao
}