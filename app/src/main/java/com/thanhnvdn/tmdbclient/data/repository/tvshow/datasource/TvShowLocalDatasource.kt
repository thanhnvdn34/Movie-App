package com.thanhnvdn.tmdbclient.data.repository.tvshow.datasource

import com.thanhnvdn.tmdbclient.data.model.tvshow.TvShow

interface TvShowLocalDatasource {
    suspend fun getTvShowsFromDB(): List<TvShow>
    suspend fun saveTvShowsToDB(tvShows: List<TvShow>)
    suspend fun clearALl()
}