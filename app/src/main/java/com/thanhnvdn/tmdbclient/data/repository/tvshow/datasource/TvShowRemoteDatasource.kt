package com.thanhnvdn.tmdbclient.data.repository.tvshow.datasource

import com.thanhnvdn.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDatasource {
    suspend fun getTvShows(): Response<TvShowList>

}