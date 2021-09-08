package com.thanhnvdn.tmdbclient.presentation.di.core

import com.thanhnvdn.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.thanhnvdn.tmdbclient.data.repository.artist.datasourceImpl.ArtistCacheDataSourceImpl
import com.thanhnvdn.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.thanhnvdn.tmdbclient.data.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import com.thanhnvdn.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDatasource
import com.thanhnvdn.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowCacheDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun providesMovieCacheDatasource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun providesTvShowCacheDatasource(): TvShowCacheDatasource {
        return TvShowCacheDatasourceImpl()
    }

    @Singleton
    @Provides
    fun providesArtistCacheDatasource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }
}