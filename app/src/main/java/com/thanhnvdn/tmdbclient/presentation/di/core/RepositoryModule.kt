package com.thanhnvdn.tmdbclient.presentation.di.core

import com.thanhnvdn.tmdbclient.data.repository.artist.ArtistRepositoryImpl
import com.thanhnvdn.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.thanhnvdn.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.thanhnvdn.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.thanhnvdn.tmdbclient.data.repository.movie.MovieRepositoryImpl
import com.thanhnvdn.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.thanhnvdn.tmdbclient.data.repository.movie.datasource.MovieLocalDatasource
import com.thanhnvdn.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.thanhnvdn.tmdbclient.data.repository.tvshow.TvShowRepositoryImpl
import com.thanhnvdn.tmdbclient.data.repository.tvshow.datasource.TvShowCacheDatasource
import com.thanhnvdn.tmdbclient.data.repository.tvshow.datasource.TvShowLocalDatasource
import com.thanhnvdn.tmdbclient.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.thanhnvdn.tmdbclient.domain.repository.ArtistRepository
import com.thanhnvdn.tmdbclient.domain.repository.MovieRepository
import com.thanhnvdn.tmdbclient.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDatasource: MovieRemoteDatasource,
        movieLocalDatasource: MovieLocalDatasource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(movieRemoteDatasource, movieLocalDatasource, movieCacheDataSource)
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDatasource: TvShowRemoteDatasource,
        tvShowLocalDatasource: TvShowLocalDatasource,
        tvShowCacheDatasource: TvShowCacheDatasource
    ): TvShowRepository {
        return TvShowRepositoryImpl(tvShowRemoteDatasource, tvShowLocalDatasource, tvShowCacheDatasource)
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {
        return ArtistRepositoryImpl(artistRemoteDataSource, artistLocalDataSource, artistCacheDataSource)
    }
}