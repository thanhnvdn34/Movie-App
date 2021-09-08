package com.thanhnvdn.tmdbclient.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.thanhnvdn.tmdbclient.domain.usecase.GetTvShowsUseCase
import com.thanhnvdn.tmdbclient.domain.usecase.UpdateTvShowsUseCase

class TvShowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
): ViewModel() {
    fun getTvShows() = liveData {
        val response = getTvShowsUseCase.execute()
        emit(response)
    }

    fun updateTvShows() = liveData {
        val response = updateTvShowsUseCase.execute()
        emit(response)
    }
}