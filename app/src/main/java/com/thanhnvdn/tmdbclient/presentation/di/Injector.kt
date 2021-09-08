package com.thanhnvdn.tmdbclient.presentation.di

import com.thanhnvdn.tmdbclient.presentation.di.artist.ArtistSubComponent
import com.thanhnvdn.tmdbclient.presentation.di.movie.MovieSubComponent
import com.thanhnvdn.tmdbclient.presentation.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent

}