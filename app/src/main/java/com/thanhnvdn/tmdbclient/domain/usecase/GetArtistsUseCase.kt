package com.thanhnvdn.tmdbclient.domain.usecase

import com.thanhnvdn.tmdbclient.data.model.artist.Artist
import com.thanhnvdn.tmdbclient.domain.repository.ArtistRepository

class GetArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.getArtists()
}