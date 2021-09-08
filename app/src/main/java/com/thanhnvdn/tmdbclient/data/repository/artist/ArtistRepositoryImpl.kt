package com.thanhnvdn.tmdbclient.data.repository.artist

import android.util.Log
import com.thanhnvdn.tmdbclient.data.model.artist.Artist
import com.thanhnvdn.tmdbclient.data.repository.artist.datasource.ArtistCacheDataSource
import com.thanhnvdn.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import com.thanhnvdn.tmdbclient.data.repository.artist.datasource.ArtistRemoteDataSource
import com.thanhnvdn.tmdbclient.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtists = getArtistsFromAPI()
        artistLocalDataSource.clearALl()
        artistLocalDataSource.saveArtistsToDB(newListOfArtists)
        artistCacheDataSource.saveArtistsToCache(newListOfArtists)
        return newListOfArtists
    }

    suspend fun getArtistsFromAPI(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            val response = artistRemoteDataSource.getArtists()
            val body = response.body()
            if (body != null) {
                artistList = body.artists
            }
        }catch (ex: Exception) {
            Log.i("TAG", ex.message.toString())
        }

        return artistList
    }

    private suspend fun getArtistsFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            artistList = artistLocalDataSource.getArtistsFromDB()
        }catch (ex: Exception) {
            Log.i("TAG", ex.message.toString())
        }
        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistsFromAPI()
            artistLocalDataSource.saveArtistsToDB(artistList)
        }

        return artistList
    }

    private suspend fun getArtistsFromCache(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            artistList = artistCacheDataSource.getArtistsFromCache()
        }catch (ex: Exception) {
            Log.i("TAG", ex.message.toString())
        }
        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistsFromDB()
            artistCacheDataSource.saveArtistsToCache(artistList)
        }

        return artistList
    }

}