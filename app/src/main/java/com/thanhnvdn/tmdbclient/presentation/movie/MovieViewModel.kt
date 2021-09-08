package com.thanhnvdn.tmdbclient.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.thanhnvdn.tmdbclient.domain.usecase.GetMoviesUseCase
import com.thanhnvdn.tmdbclient.domain.usecase.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
): ViewModel() {
    fun getMovies() = liveData {
        val response = getMoviesUseCase.execute()
        emit(response)
    }

    fun updateMovies() = liveData {
        val response = updateMoviesUseCase.execute()
        emit(response)
    }
}