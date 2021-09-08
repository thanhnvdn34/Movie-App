package com.thanhnvdn.tmdbclient.presentation.di.artist

import com.thanhnvdn.tmdbclient.domain.usecase.GetArtistsUseCase
import com.thanhnvdn.tmdbclient.domain.usecase.UpdateArtistsUseCase
import com.thanhnvdn.tmdbclient.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(getArtistsUseCase, updateArtistsUseCase)
    }
}