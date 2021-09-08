package com.thanhnvdn.tmdbclient.data.repository.tvshow.datasourceImpl

import com.thanhnvdn.tmdbclient.data.api.TMDBService
import com.thanhnvdn.tmdbclient.data.model.tvshow.TvShowList
import com.thanhnvdn.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import retrofit2.Response

class TvShowRemoteDatasourceImpl(
    private val tmdbService: TMDBService, private val apiKey: String
): TvShowRemoteDatasource {
    override suspend fun getTvShows(): Response<TvShowList> = tmdbService.getPopularTvShows(apiKey)
}