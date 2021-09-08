package com.thanhnvdn.tmdbclient.data.repository.artist.datasource

import com.thanhnvdn.tmdbclient.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistsFromCache(): List<Artist>
    suspend fun saveArtistsToCache(movies: List<Artist>)
}