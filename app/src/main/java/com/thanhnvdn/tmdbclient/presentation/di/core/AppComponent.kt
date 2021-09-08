package com.thanhnvdn.tmdbclient.presentation.di.core

import com.thanhnvdn.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.thanhnvdn.tmdbclient.presentation.di.movie.MovieSubComponent
import com.thanhnvdn.tmdbclient.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
AppModule::class,
NetModule::class,
DatabaseModule::class,
UseCaseModule::class,
RepositoryModule::class,
RemoteDataModule::class,
LocalDataModule::class,
CacheDataModule::class
])
interface AppComponent {

    fun movieSubComponent(): MovieSubComponent.Factory
    fun artistSubComponent(): ArtistSubComponent.Factory
    fun tvShowSubComponent(): TvShowSubComponent.Factory
}