package com.thanhnvdn.tmdbclient.domain.repository

import com.thanhnvdn.tmdbclient.data.model.tvshow.TvShow

interface TvShowRepository {
    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateTvShows(): List<TvShow>?
}