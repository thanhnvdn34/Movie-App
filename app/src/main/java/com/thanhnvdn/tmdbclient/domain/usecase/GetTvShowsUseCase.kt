package com.thanhnvdn.tmdbclient.domain.usecase

import com.thanhnvdn.tmdbclient.data.model.tvshow.TvShow
import com.thanhnvdn.tmdbclient.domain.repository.TvShowRepository

class GetTvShowsUseCase(private val tvShowRepository: TvShowRepository) {

    suspend fun execute(): List<TvShow>? = tvShowRepository.getTvShows()
}