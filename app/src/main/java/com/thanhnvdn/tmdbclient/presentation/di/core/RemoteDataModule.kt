package com.thanhnvdn.tmdbclient.presentation.di.core

import com.thanhnvdn.tmdbclient.data.api.TMDBService
import com.thanhnvdn.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.thanhnvdn.tmdbclient.data.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import com.thanhnvdn.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.thanhnvdn.tmdbclient.data.repository.movie.datasourceImpl.MovieRemoteDatasourceImpl
import com.thanhnvdn.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.thanhnvdn.tmdbclient.data.repository.tvshow.datasourceImpl.TvShowRemoteDatasourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(
    private val apiKey: String
) {

    @Singleton
    @Provides
    fun providesMovieRemoteDatasource(tmdbService: TMDBService): MovieRemoteDatasource {
        return MovieRemoteDatasourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun providesTvShowRemoteDatasource(tmdbService: TMDBService): TvShowRemoteDatasource {
        return TvShowRemoteDatasourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun providesArtistRemoteDatasource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }
}