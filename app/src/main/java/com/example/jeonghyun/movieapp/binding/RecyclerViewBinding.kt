package com.example.jeonghyun.movieapp.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.jeonghyun.movieapp.models.entity.Movie
import com.example.jeonghyun.movieapp.view.adapter.MovieListAdapter
import com.skydoves.whatif.whatIfNotNull

@BindingAdapter("adapterMovieList")
fun bindAdapterMovieList(view: RecyclerView, movies: List<Movie>?) {
        movies?.let {
            val adapter = view.adapter as? MovieListAdapter
            adapter?.addMovieList(it)
        }
}