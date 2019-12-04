package com.example.jeonghyun.movieapp.models.entity

import android.os.Parcelable
import androidx.room.Entity
import com.example.jeonghyun.movieapp.models.Keyword
import com.example.jeonghyun.movieapp.models.Review
import com.example.jeonghyun.movieapp.models.Video
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(primaryKeys = [("id")])
data class Movie(
    var page: Int,
    var keywords: List<Keyword>? = ArrayList(),
    var videos: List<Video>? = ArrayList(),
    var reviews: List<Review>? = ArrayList(),
    val poster_path: String?,
    val adult: Boolean,
    val release_date: String?,
    val genre_ids: List<Int>,
    val id: Int,
    val original_title: String,
    val original_langauge: String,
    val title: String,
    val backdrop_path: String?,
    val popularity: Float,
    val vote_count: Int,
    val video: Boolean,
    val vote_average: Float
): Parcelable