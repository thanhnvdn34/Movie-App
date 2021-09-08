package com.thanhnvdn.tmdbclient.data.repository.tvshow.datasourceImpl

import com.thanhnvdn.tmdbclient.data.model.tvshow.TvShow
import com.thanhnvdn.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDatasource

class TvShowCacheDatasourceImpl: TvShowCacheDatasource {
    private var tvShowList = ArrayList<TvShow>()
    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }
}