package com.thanhnvdn.tmdbclient.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.thanhnvdn.tmdbclient.domain.usecase.GetArtistsUseCase
import com.thanhnvdn.tmdbclient.domain.usecase.UpdateArtistsUseCase

class ArtistViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
): ViewModel() {
    fun getArtists() = liveData {
        val response = getArtistsUseCase.execute()
        emit(response)
    }

    fun updateArtists() = liveData {
        val response = updateArtistsUseCase.execute()
        emit(response)
    }
}