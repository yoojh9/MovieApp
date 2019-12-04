package com.example.jeonghyun.movieapp.view.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import com.example.jeonghyun.movieapp.R
import com.example.jeonghyun.movieapp.compose.ViewModelFragment
import com.example.jeonghyun.movieapp.databinding.MainFragmentMovieBinding
import com.example.jeonghyun.movieapp.models.entity.Movie
import com.example.jeonghyun.movieapp.view.adapter.MovieListAdapter
import com.example.jeonghyun.movieapp.view.viewholder.MovieListViewHolder
import com.skydoves.baserecyclerviewadapter.RecyclerViewPaginator
import kotlinx.android.synthetic.main.main_fragment_movie.*
import org.jetbrains.anko.support.v4.toast
import org.koin.android.viewmodel.ext.android.viewModel

class MovieListFragment: ViewModelFragment(), MovieListViewHolder.Delegate {

    private val viewModel by viewModel<MainActivityViewModel>()
    private lateinit var binding: MainFragmentMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //binding = binding(inflater)
        binding = binding(inflater, R.layout.main_fragment_movie, container)
        binding.viewModel = viewModel
        binding.lifecycleOwner  = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeUI()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        loadMore(page = 1)
        observeMessages()
    }

    override fun onItemClick(movie: Movie) {

    }

    private fun initializeUI(){
        recyclerView.adapter = MovieListAdapter(this)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        RecyclerViewPaginator(
            recyclerView = recyclerView,
            isLoading = { false },
            loadMore = { loadMore(it)},
            onLast = { false }
        ).apply {
            threshold = 4
            currentPage = 1
        }
    }

    private fun loadMore(page: Int) = viewModel.postMoviePage(page)

    private fun observeMessages() = this.viewModel.toastLiveData.observe(this) { it -> toast(it) }

}