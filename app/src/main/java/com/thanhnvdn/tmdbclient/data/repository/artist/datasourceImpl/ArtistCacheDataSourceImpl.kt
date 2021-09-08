package com.thanhnvdn.tmdbclient.data.repository.artist.datasourceImpl

import com.thanhnvdn.tmdbclient.data.model.artist.Artist
import com.thanhnvdn.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource

class ArtistCacheDataSourceImpl: ArtistCacheDataSource {
    private var artistList = ArrayList<Artist>()
    override suspend fun getArtistsFromCache(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistsToCache(movies: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(movies)
    }
}