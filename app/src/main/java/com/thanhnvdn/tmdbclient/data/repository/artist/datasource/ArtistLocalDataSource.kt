package com.thanhnvdn.tmdbclient.data.repository.artist.datasource

import com.thanhnvdn.tmdbclient.data.model.artist.Artist

interface ArtistLocalDataSource {
    suspend fun getArtistsFromDB(): List<Artist>
    suspend fun saveArtistsToDB(artists: List<Artist>)
    suspend fun clearALl()
}