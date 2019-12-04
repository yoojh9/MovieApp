package com.example.jeonghyun.movieapp.view.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.example.jeonghyun.movieapp.compose.DispatchViewModel
import com.example.jeonghyun.movieapp.models.entity.Movie
import com.example.jeonghyun.movieapp.repository.DiscoverRepository
import timber.log.Timber

class MainActivityViewModel constructor(
    private val discoverRepository: DiscoverRepository
) : DispatchViewModel() {

    private var moviePageLiveData: MutableLiveData<Int> = MutableLiveData()
    val movieListLiveData: LiveData<List<Movie>>

    val toastLiveData: MutableLiveData<String> = MutableLiveData()

    init {
        Timber.d("injection MainActivityViewModel")

        this.movieListLiveData = moviePageLiveData.switchMap { page ->
            launchOnViewModelScope {
                discoverRepository.loadMovies(page) { toastLiveData.postValue(it)}
            }
        }
    }

    fun postMoviePage(page: Int) = moviePageLiveData.postValue(page)
}