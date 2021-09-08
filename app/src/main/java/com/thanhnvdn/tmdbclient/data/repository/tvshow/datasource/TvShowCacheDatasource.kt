package com.thanhnvdn.tmdbclient.data.repository.tvshow.datasource

import com.thanhnvdn.tmdbclient.data.model.tvshow.TvShow

interface TvShowCacheDatasource {
    suspend fun getTvShowsFromCache(): List<TvShow>
    suspend fun saveTvShowsToCache(tvShows: List<TvShow>)
}