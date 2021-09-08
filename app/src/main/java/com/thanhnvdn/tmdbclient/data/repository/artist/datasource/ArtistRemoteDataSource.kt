package com.thanhnvdn.tmdbclient.data.repository.artist.datasource

import com.thanhnvdn.tmdbclient.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>
}