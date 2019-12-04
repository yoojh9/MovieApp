package com.example.jeonghyun.movieapp.view.viewholder

import android.view.View
import com.bumptech.glide.Glide
import com.example.jeonghyun.movieapp.api.Api
import com.example.jeonghyun.movieapp.models.entity.Movie
import com.github.florent37.glidepalette.BitmapPalette
import com.github.florent37.glidepalette.GlidePalette
import com.skydoves.baserecyclerviewadapter.BaseViewHolder
import kotlinx.android.synthetic.main.item_poster.view.*

class MovieListViewHolder(
    val view: View,
    private val delegate: Delegate
): BaseViewHolder(view) {

    interface Delegate {
        fun onItemClick(movie: Movie)
    }

    private lateinit var movie: Movie


    override fun bindData(data: kotlin.Any) {
        if(data is Movie){
            movie = data
            drawItem()
        }
    }

    private fun drawItem(){
        itemView.run {
            item_poster_title.text = movie.title
            movie.poster_path?.let {
                Glide.with(context)
                    .load(Api.getPosterPath(it))
                    .listener(GlidePalette.with(Api.getPosterPath(it))
                        .use(BitmapPalette.Profile.VIBRANT)
                        .intoBackground(item_poster_palette)
                        .crossfade(true)
                    )
                    .into(item_poster_post)
            }
        }
    }

    override fun onClick(p0: View?) {
        delegate.onItemClick(movie)
    }

    override fun onLongClick(p0: View?): Boolean = false

}