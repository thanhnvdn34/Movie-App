package com.thanhnvdn.tmdbclient.data.repository.tvshow.datasourceImpl

import com.thanhnvdn.tmdbclient.data.db.TvShowDao
import com.thanhnvdn.tmdbclient.data.model.tvshow.TvShow
import com.thanhnvdn.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDatasourceImpl(private val tvShowDao: TvShowDao): TvShowLocalDatasource {

    override suspend fun getTvShowsFromDB(): List<TvShow> = tvShowDao.getTvShows()

    override suspend fun saveTvShowsToDB(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShow(tvShows)
        }
    }

    override suspend fun clearALl() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.getTvShows()
        }
    }
}