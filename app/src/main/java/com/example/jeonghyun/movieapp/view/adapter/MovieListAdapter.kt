package com.example.jeonghyun.movieapp.view.adapter

import android.view.View
import com.example.jeonghyun.movieapp.R
import com.example.jeonghyun.movieapp.models.entity.Movie
import com.example.jeonghyun.movieapp.view.viewholder.MovieListViewHolder
import com.skydoves.baserecyclerviewadapter.BaseAdapter
import com.skydoves.baserecyclerviewadapter.BaseViewHolder
import com.skydoves.baserecyclerviewadapter.SectionRow

class MovieListAdapter(private val delegate: MovieListViewHolder.Delegate) : BaseAdapter() {
    init {
        addSection(ArrayList<Movie>())
    }

    fun addMovieList(movies: List<Movie>) {
        val section = sections()[0]  // com.skydoves.baserecyclerviewadapter.BaseAdapter.section
        section.addAll(movies)
        notifyItemRangeInserted(section.size + 1, movies.size)
    }

    override fun layout(sectionRow: SectionRow) = R.layout.item_poster

    override fun viewHolder(layout: Int, view: View): BaseViewHolder = MovieListViewHolder(view, delegate)

}