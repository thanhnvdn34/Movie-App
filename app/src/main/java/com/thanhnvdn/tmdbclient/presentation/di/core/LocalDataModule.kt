package com.thanhnvdn.tmdbclient.presentation.di.core

import com.thanhnvdn.tmdbclient.data.db.ArtistDao
import com.thanhnvdn.tmdbclient.data.db.MovieDao
import com.thanhnvdn.tmdbclient.data.db.TvShowDao
import com.thanhnvdn.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.thanhnvdn.tmdbclient.data.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.thanhnvdn.tmdbclient.data.repository.movie.datasource.MovieLocalDatasource
import com.thanhnvdn.tmdbclient.data.repository.movie.datasourceImpl.MovieLocalDatasourceImpl
import com.thanhnvdn.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDatasource
import com.thanhnvdn.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowLocalDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun providesMovieLocalDatasource(movieDao: MovieDao): MovieLocalDatasource {
        return MovieLocalDatasourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun providesArtistLocalDatasource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }

    @Singleton
    @Provides
    fun providesTvShowLocalDatasource(tvShowDao: TvShowDao): TvShowLocalDatasource {
        return TvShowLocalDatasourceImpl(tvShowDao)
    }
}