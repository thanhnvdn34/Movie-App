package com.thanhnvdn.tmdbclient.domain.repository

import com.thanhnvdn.tmdbclient.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtists(): List<Artist>?
}