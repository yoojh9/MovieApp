package com.example.jeonghyun.movieapp.room

import androidx.room.Dao
import androidx.room.Query
import com.example.jeonghyun.movieapp.models.entity.Movie

@Dao
interface MovieDao {
    @Query("SELECT * FROM Movie WHERE id = :id")
    fun getMovie(id: Int): Movie

    @Query("SELECT * FROM Movie WHERE page = :page")
    fun getMovieList(page: Int): List<Movie>
}