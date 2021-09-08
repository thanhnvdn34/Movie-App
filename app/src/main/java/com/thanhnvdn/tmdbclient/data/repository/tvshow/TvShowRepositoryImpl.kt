package com.thanhnvdn.tmdbclient.data.repository.tvshow

import android.util.Log
import com.thanhnvdn.tmdbclient.data.model.tvshow.TvShow
import com.thanhnvdn.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDatasource
import com.thanhnvdn.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDatasource
import com.thanhnvdn.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.thanhnvdn.tmdbclient.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
    private val tvShowRemoteDatasource: TvShowRemoteDatasource,
    private val tvShowLocalDatasource: TvShowLocalDatasource,
    private val tvShowCacheDatasource: TvShowCacheDatasource
): TvShowRepository {
    override suspend fun getTvShows(): List<TvShow>? = getTvShowsFromCache()

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShows = getTvShowsFromApi()
        tvShowLocalDatasource.clearALl()
        tvShowLocalDatasource.saveTvShowsToDB(newListOfTvShows)
        tvShowCacheDatasource.saveTvShowsToCache(newListOfTvShows)
        return newListOfTvShows
    }

    private suspend fun getTvShowsFromApi(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            val response = tvShowRemoteDatasource.getTvShows()
            val body = response.body()
            if (body != null) {
                tvShowList = body.tvShows
            }
        }catch (ex: Exception) {
            Log.i("TAG", ex.message.toString())
        }

        return tvShowList
    }

    private suspend fun getTvShowsFromDB(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            tvShowList = tvShowLocalDatasource.getTvShowsFromDB()
        }catch (ex: Exception) {
            Log.i("TAG", ex.message.toString())
        }
        if (tvShowList.isNotEmpty()){
            return tvShowList
        } else {
            tvShowList = getTvShowsFromApi()
            tvShowLocalDatasource.saveTvShowsToDB(tvShowList)
        }

        return tvShowList
    }

    private suspend fun getTvShowsFromCache(): List<TvShow> {
        lateinit var tvShowList: List<TvShow>

        try {
            tvShowList = tvShowCacheDatasource.getTvShowsFromCache()
        }catch (ex: Exception) {
            Log.i("TAG", ex.message.toString())
        }
        if (tvShowList.isNotEmpty()){
            return tvShowList
        } else {
            tvShowList = getTvShowsFromDB()
            tvShowCacheDatasource.saveTvShowsToCache(tvShowList)
        }

        return tvShowList
    }
}