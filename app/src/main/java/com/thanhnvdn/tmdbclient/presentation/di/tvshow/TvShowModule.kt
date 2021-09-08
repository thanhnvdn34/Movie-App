package com.thanhnvdn.tmdbclient.presentation.di.tvshow

import com.thanhnvdn.tmdbclient.domain.usecase.GetTvShowsUseCase
import com.thanhnvdn.tmdbclient.domain.usecase.UpdateTvShowsUseCase
import com.thanhnvdn.tmdbclient.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(getTvShowsUseCase, updateTvShowsUseCase)
    }
}