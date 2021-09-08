package com.thanhnvdn.tmdbclient.presentation.di.movie

import com.thanhnvdn.tmdbclient.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create():MovieSubComponent
    }
}