package com.example.jeonghyun.movieapp.repository

import androidx.lifecycle.MutableLiveData
import com.example.jeonghyun.movieapp.api.ApiResponse
import com.example.jeonghyun.movieapp.api.client.DiscoverClient
import com.example.jeonghyun.movieapp.api.message
import com.example.jeonghyun.movieapp.models.entity.Movie
import com.example.jeonghyun.movieapp.room.MovieDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber

class DiscoverRepository constructor(
    private val discoverClient: DiscoverClient,
    private val movieDao: MovieDao
): Repository {

    init{
        Timber.d("Injection DiscoverRepository")
    }

    suspend fun loadMovies(page: Int, error: (String)->Unit) = withContext(Dispatchers.IO) {
        val liveData = MutableLiveData<List<Movie>>()
        var movies = movieDao.getMovieList(page)
        if(movies.isEmpty()){
            // 마지막 파라미터가 람다식이면 중괄호 {} 부분을 소괄호 밖으로 뺄 수 있다.
            // 그 파라미터가 한개면, 생략 후 it 을 사용하여 대체 가능하다
            discoverClient.fetchDiscoverMovie(page) { response ->
                when(response) {
                    is ApiResponse.Success ->  {
                        response.data?.let { data ->
                            movies = data.results
                            movies.forEach{ it.page = page}
                            liveData.postValue(movies)
                        }
                    }
                    is ApiResponse.Failure.Error -> error(response.message())
                    is ApiResponse.Failure.Exception -> error(response.message())
                }
            }
        }
        liveData.apply { postValue(movies)}
    }

}