package com.thanhnvdn.tmdbclient.presentation

import android.app.Application
import com.thanhnvdn.tmdbclient.presentation.di.Injector
import com.thanhnvdn.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.thanhnvdn.tmdbclient.presentation.di.core.AppComponent
import com.thanhnvdn.tmdbclient.presentation.di.core.DaggerAppComponent
import com.thanhnvdn.tmdbclient.presentation.di.movie.MovieSubComponent
import com.thanhnvdn.tmdbclient.presentation.di.tvshow.TvShowSubComponent

class App: Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        TODO("Not yet implemented")
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        TODO("Not yet implemented")
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        TODO("Not yet implemented")
    }
}