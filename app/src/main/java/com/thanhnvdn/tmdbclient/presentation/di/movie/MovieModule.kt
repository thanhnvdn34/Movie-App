package com.thanhnvdn.tmdbclient.presentation.di.movie

import com.thanhnvdn.tmdbclient.domain.usecase.GetMoviesUseCase
import com.thanhnvdn.tmdbclient.domain.usecase.UpdateMoviesUseCase
import com.thanhnvdn.tmdbclient.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(getMoviesUseCase, updateMoviesUseCase)
    }
}